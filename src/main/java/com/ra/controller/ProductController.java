package com.ra.controller;

import com.ra.model.dao.category.CategoryDAO;

import com.ra.model.entity.Product;
import com.ra.service.category.CategoryService;
import com.ra.service.product.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public String products(Model model){
        model.addAttribute("products", productService.findAll());

        return "product/index";
    }

    //=============================== Add ===================================================
    @GetMapping("/add")
    public String getAdd(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "product/add";
    }


    @PostMapping("/add")
    public String create(@ModelAttribute Product product, Model model){


        if(productService.save(product)){
            return "redirect:/";
        }
        return "redirect:/";
    }

    //============================================= update ========================================
    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findById(Math.toIntExact(id)));
        model.addAttribute("categories", categoryService.findAll());
        return "product/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, Model model){

        model.addAttribute("err","Sai thông tin tài khoản");

        if(productService.update(product)){
            return "redirect:/";
        }
        return "redirect:/";
    }

    //============================================= delete ========================================

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/";
    }


}
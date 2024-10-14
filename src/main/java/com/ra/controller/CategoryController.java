package com.ra.controller;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;
import com.ra.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public String categories(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "category/index";
    }

    //=============================== Add ===================================================
    @GetMapping("/add")
    public String getAdd(Model model){
        model.addAttribute("category",new Category());
        return "category/add";
    }


    @PostMapping("/add")
    public String create(@ModelAttribute Category category, Model model){
        if (category.getName().isEmpty()){
            model.addAttribute("nameErr","category name is empty");
            return "/category/add";

        }

        if(categoryService.save(category)){
            return "redirect:/category";
        }
        return "redirect:/category";
    }

    //============================================= update ========================================
    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryService.findById(Math.toIntExact(id)));
        return "category/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category,Model model){
        List<Category> categoryList = categoryService.findAll();

        if (category.getName().isEmpty()){
            model.addAttribute("nameErr","category name is empty");
            return "/category/update";

        }

        if(categoryService.update(category)){
            return "redirect:/category";
        }
        return "redirect:/category";
    }

    //============================================= delete ========================================

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        categoryService.delete(id);
        return "redirect:/category";
    }


}
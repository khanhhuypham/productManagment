package com.ra.controller;

import com.ra.model.dao.category.CategoryDAO;

import com.ra.model.entity.Product;
import com.ra.service.category.CategoryService;
import com.ra.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;



@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ServletContext context; // môi trường chạy

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
    public String create(@ModelAttribute Product product, @RequestParam("imgFile") MultipartFile image ,Model model){

        // Kiểm tra nếu người dùng upload file ảnh mới
        if (!image.isEmpty()) {
            String fileName = image.getOriginalFilename();
            String uploadPath = context.getRealPath("/uploads");
            File file = new File(uploadPath);

            if (!file.exists()){
                file.mkdirs() ;  //tạo mới thu muc
            }

            String fileImageName = image.getOriginalFilename(); // lấy ra tên file
            // copy file ngưoi dùng gửi lên vào thư mục uploads

            try {
                FileCopyUtils.copy(image.getBytes(),new File(uploadPath+File.separator+fileImageName));
                product.setImage(fileImageName);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

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
    public String update(
            @ModelAttribute Product product,
            @RequestParam("imgFile") MultipartFile image,
            Model model){

        Product existingProduct = productService.findById(product.getId());


        // Kiểm tra nếu người dùng upload file ảnh mới
        if (!image.isEmpty()) {
            String fileName = image.getOriginalFilename();
            String uploadPath = context.getRealPath("/uploads");
            File file = new File(uploadPath);

            if (!file.exists()){
                file.mkdirs() ;  //tạo mới thu muc
            }

            String fileImageName = image.getOriginalFilename(); // lấy ra tên file
            // copy file ngưoi dùng gửi lên vào thư mục uploads

            try {
                FileCopyUtils.copy(image.getBytes(),new File(uploadPath+File.separator+fileImageName));
                product.setImage(fileImageName);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            // Giữ lại ảnh cũ nếu không có file mới
            product.setImage(existingProduct.getImage());
        }


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
package com.example.spring_thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Preemphat Pawatnavakun");
        model.addAttribute("studentId", "สวัสดี พรีมภัทร ภาวัฒนวคุณ รหัส นักศึกษา 673380594-9");
        return "home";  
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("ab", "สวัสดีค่ะ ชื่อ พรีมภัทรค่ะ รหัสนักศึกษา 673380594-9 ชื่อเล่น พรีมค่ะ 676767");
        return "about";  
    }   
}
    

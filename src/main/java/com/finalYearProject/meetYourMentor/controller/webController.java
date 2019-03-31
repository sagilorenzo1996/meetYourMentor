package com.finalYearProject.meetYourMentor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class webController {

    @GetMapping("/")
    public String home() {
        return "login.html";
    }

    @GetMapping("/studentDashboard")
    public String studentPage() {
        return "studentDashboard.html";
    }

    @GetMapping("/user/lecturer")
    public String lecturerPage() {
        return "lecturer.html";
    }
//
    @GetMapping("/admin")
    public String register() {
        return "admin.html";
    }
//
//    @GetMapping("/myAccount")
//    public String myAccount() {
//        return "myAccount.html";
//    }
//
//    @GetMapping("/all")
//    public String all() {
//        return "all.html";
//    }
//
//    @GetMapping("/category/{category}")
//    public String category(@PathVariable String category) {
//        return "category.html";
//    }
//
//    @GetMapping("/cart")
//    public String itemPage(@RequestParam Long id) {
//        return "item.html";
//    }



//    @GetMapping("/listing")
//    public Object listing() {
//        return "listing.html";
//    }
//
//    @GetMapping("/error")
//    public Object error() {
//        return "404.html";
//    }
}

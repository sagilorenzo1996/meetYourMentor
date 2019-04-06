package com.finalYearProject.meetYourMentor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class webController {

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/studentDashboard")
    public String studentPage() {
        return "studentDashboard.html";
    }

    @GetMapping("/lecturerDashboard")
    public String lecturerPage() {
        return "lecturerDashboard.html";
    }

    @GetMapping("/studentLogin")
    public String studentLoginPage() {
        return "studentLogin.html";
    }

    @GetMapping("/lecturerLogin")
    public String lecturerLoginPage() {
        return "lecturerLogin.html";
    }

    @GetMapping("/adminLogin")
    public String adminLoginPage() {
        return "adminLogin.html";
    }

    @GetMapping("/lecturerMeeting")
    public String lecturerMeeting() {
        return "lecturerMeeting.html";
    }

    @GetMapping("/studentMeeting")
    public String studentMeeting() {
        return "studentMeeting.html";
    }

    @GetMapping("/add/users")
    public String register() {
        return "admin.html";
    }

    @GetMapping("/add/grades")
    public String addGrades() {
        return "admin.html";
    }
}

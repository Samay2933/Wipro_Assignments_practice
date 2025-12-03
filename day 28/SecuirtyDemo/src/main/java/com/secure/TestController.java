package com.secure;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String home() {
        return "Home page";
    }

    @GetMapping("/public/welcome")
    public String getWelcome(){
        return "Welcome to our Hotel";
    }

    @GetMapping("api/user/userinfo")
    public String getVoucher(){
        return "Your voucher code is generated: ";
    }

    @GetMapping("/api/admin/admininfo")
    public String getUserInfo(){
        return "admin dashboard will get open";
    }
}

package com.example.demo.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private UserDetailsManager userDetailsManager; // JdbcUserDetailsManagerを注入

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttribute) {
        // パスワードをハッシュ化して保存
        UserDetails user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .authorities("USER") // 権限（今回はダミー）
                .build();
        
        userDetailsManager.createUser(user);
        
        redirectAttribute.addFlashAttribute("msg","ユーザー登録が完了しました");
        
        return "redirect:/register-complete";
    }
    
    
}
package com.sluiters.second.video.suilerSecondVideo.controllers;


import com.sluiters.second.video.suilerSecondVideo.models.LoginModel;
import com.sluiters.second.video.suilerSecondVideo.models.RegisterModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping("/")
    public String showRegisterPage(Model model){

        model.addAttribute("registerModel", new RegisterModel());

        return "registerForm";
    }

    @PostMapping("/registerProcess")
    public  String processLogin(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("registerModel", registerModel);
            return "registerForm";
        }

        model.addAttribute("registerModel", registerModel);
        return "redirect:/login/";

    }
}

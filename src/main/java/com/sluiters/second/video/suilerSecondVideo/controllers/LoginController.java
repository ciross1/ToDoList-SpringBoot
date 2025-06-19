package com.sluiters.second.video.suilerSecondVideo.controllers;


import com.sluiters.second.video.suilerSecondVideo.models.LoginModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
/* RequestMapping ->  Specifies that any request starting with /login will be handled by methods inside this controller.
This sets the base URL for all handler methods inside the class.*/
public class LoginController {

    @GetMapping("/")
    public  String displayLoginForm(Model model){

        // The model is ready to bind user input to LoginModel.
        model.addAttribute("loginModel", new LoginModel());
        return "loginForm";

    }

    @PostMapping("/processLogin")
    public  String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){

        /*@Valid tells Spring to automatically validate the fields of LoginModel using annotations like @NotBlank, @Email, etc*/
        /*If there are validation errors, bindingResult.hasErrors() will return true.*/

        //important: BindingResult must come right after the @Valid parameter. Otherwise, Spring throws an error.
        if(bindingResult.hasErrors()){
            model.addAttribute("loginModel", loginModel);
            return "loginForm";
        }

        model.addAttribute("loginModel", loginModel);
        return "loginResults";

    }
}

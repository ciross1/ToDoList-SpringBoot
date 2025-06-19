package com.sluiters.second.video.suilerSecondVideo.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterModel {

    @NotNull
    @Size(min = 8, max = 15, message = " Username must be between 8 and 15 characters ")
    private String username;

    @NotNull
    @Size(min = 8, max = 15, message = " Password must be between 8 and 15 characters ")
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String confirmEmail;


    public RegisterModel() {
    }

    public RegisterModel(String username, String password, String email, String confirmEmail) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.confirmEmail = confirmEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }
}

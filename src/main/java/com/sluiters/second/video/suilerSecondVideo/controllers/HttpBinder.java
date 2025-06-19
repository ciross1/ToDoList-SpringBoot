package com.sluiters.second.video.suilerSecondVideo.controllers;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @ControllerAdvice is a special Spring annotation that allows
// you to write code that applies globally to all (or many) controllers in your application.

@ControllerAdvice
public class HttpBinder {


    @InitBinder
    public void initBinder(WebDataBinder binder) {

        // We have to solve one problem and is the date input, Spring can not convert text into localDate
        //When we try to convert the input String from the date picker, we have to convert it into a LocalDate
        // Because otherwise Spring Boot won't be able to catch it as in our model we defined LocalDate type data

// This method  tells Spring: “When the user enters a date like 2025-12-22, convert it into a LocalDate.”

        //@InitBinder is an annotation you put on a method inside your controller
// that lets you customize how Spring binds HTTP request parameters to Java objects.


        //Create a date formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //In this line spring tells: When you bind data for the type LocalDate, use this custom editor.
        // Inside the PropertyEditorSupport you define how to convert a string into a LocalDate
        binder.registerCustomEditor(LocalDate.class, new java.beans.PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(LocalDate.parse(text, formatter));
            }
        });
    }
}

package com.sluiters.second.video.suilerSecondVideo.controllers;

import com.sluiters.second.video.suilerSecondVideo.models.SearchModel;
import com.sluiters.second.video.suilerSecondVideo.models.ToDoModel;
import com.sluiters.second.video.suilerSecondVideo.service.TodoBusinessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    TodoBusinessService service;

    public ToDoController(TodoBusinessService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String showTheWholeList(Model model) {

        List<ToDoModel> lists = service.getAllLists();

        model.addAttribute("lists", lists);

        return "todo";
    }


    @GetMapping("/add/form")
    public String form(Model model) {

        model.addAttribute("lists", new ToDoModel());

        return "addForm";
    }


    @PostMapping("add/list")
    public String addOne(@Valid ToDoModel todoList, BindingResult bindingResult, Model model) {

        // Using BindingResult is very important when you're
        // working with form validation in Spring Model view controller (MVC)  (like with @Valid and @PostMapping).

        // if  you don’t include it, you won’t be able to check for validation errors, and your app might crash or behave
        // unpredictably.

        //Add the new todo list
        service.addOne(todoList);

        //Get all the lists then:
        List<ToDoModel> lists = service.getAllLists();

        //Display it on the model:
        model.addAttribute("lists", lists);


        return "todo";
    }


    @GetMapping("/admin")
    public String admin(Model model) {

        //get all todo lists
        List<ToDoModel> lists = service.getAllLists();

        //display them
        model.addAttribute("lists", lists);

        return "todoAdmin";
    }

    @PostMapping("/update/form")
    public String getForm(ToDoModel selectedList, Model model) {

        model.addAttribute("list", selectedList);
        model.addAttribute("text", "Update");

        return "updateForm";
    }

    @PostMapping("/update")
    public String saveUpdate(@Valid ToDoModel toDoModel, BindingResult bindingResult, Model model) {

        //Save and update the new updated List:
        service.updateOne(toDoModel.getId(), toDoModel);

        //Get again all the lists:
        List<ToDoModel> lists = service.getAllLists();

        model.addAttribute("lists", lists);

        //Return again the the admin page:
        return "todoAdmin";

    }


    @PostMapping("/delete")
    public String deleteList(ToDoModel toDoModel, Model model) {


        System.out.println(toDoModel.getDate());
        System.out.println(toDoModel.getId());
        System.out.println(toDoModel.getDescription());
        boolean deleted = service.deleteList(toDoModel.getId());
        System.out.println("Deleted? " + deleted);

        model.addAttribute("lists", service.getAllLists());
        return "todoAdmin";
    }


    @GetMapping("/showSearchForm")
    public String showSearchForm(Model model) {

        model.addAttribute("searchModel", new SearchModel());

        return "searchForm";
    }


    @PostMapping("/search")
    public String searchList(@Valid SearchModel searchMode, BindingResult bindingResult, Model model) {

        String searchTerm = searchMode.getSearchTerm();

        List<ToDoModel> listFound = service.searchOne(searchTerm);

        model.addAttribute("lists", listFound);


        return "todo";
    }

    @GetMapping("/date/form")
    public String searchByDate(Model model) {

        //Lets bind the object in the template:
        model.addAttribute("list", new ToDoModel());

        return "searchByDateForm";
    }

    @PostMapping("/date/found")  //As the parameter we need to valid the form
    public String getFoundDate(@Valid ToDoModel toDoModel, BindingResult bindingResult, Model model){

        //Lets get first date we picked:
        LocalDate selectedDate = toDoModel.getDate();

        //Then get all the lists that search the selected date:
        List<ToDoModel> lists = service.searchOneByDate(selectedDate);

        //And finally display it
        model.addAttribute("lists", lists);

        return "todo";


}


}

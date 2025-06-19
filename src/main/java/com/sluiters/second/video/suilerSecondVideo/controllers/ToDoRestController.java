package com.sluiters.second.video.suilerSecondVideo.controllers;


import com.sluiters.second.video.suilerSecondVideo.models.ToDoModel;
import com.sluiters.second.video.suilerSecondVideo.service.TodoBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Important to use here the restController because we are only working with data
@RequestMapping("/api/todo")
public class ToDoRestController {

    @Autowired
    TodoBusinessService service;
    public ToDoRestController(TodoBusinessService service ){
        this.service = service;
    }



    @GetMapping("/list")
    public List<ToDoModel> getAllToDoLists(){
     return service.getAllLists();
    }

    @PostMapping("/add/list") //Very importat to use @RequestBody to create new data / add data
    public long addOne (@RequestBody  ToDoModel todoList){
        return service.addOne(todoList);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteOne(@PathVariable(name="id")  long id){
        return service.deleteList(id);
    }


}

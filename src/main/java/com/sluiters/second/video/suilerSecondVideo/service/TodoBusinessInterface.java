package com.sluiters.second.video.suilerSecondVideo.service;

import com.sluiters.second.video.suilerSecondVideo.models.ToDoModel;

import java.time.LocalDate;
import java.util.List;

public interface TodoBusinessInterface {

    public void init();
    public void delete();

      //Future methods:
    //get all the todo lists
    //delete one todo list
    // add one todo list
    // update a todo list
    //search a specific todo list
    //get by date a todo list

   public List<ToDoModel> getAllLists ();
   public  boolean deleteList(long id);
   public long addOne(ToDoModel todoList);
   public ToDoModel updateOne(long id, ToDoModel update);
   public List<ToDoModel> searchOne(String searchTerm);
   public List<ToDoModel>searchOneByDate(LocalDate localDate);
}

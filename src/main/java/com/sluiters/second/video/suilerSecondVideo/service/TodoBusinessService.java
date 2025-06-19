package com.sluiters.second.video.suilerSecondVideo.service;

import com.sluiters.second.video.suilerSecondVideo.data.ToDoDataAccessInterface;
import com.sluiters.second.video.suilerSecondVideo.data.ToDoDataService;
import com.sluiters.second.video.suilerSecondVideo.models.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Primary
public class TodoBusinessService implements TodoBusinessInterface{


@Autowired
    ToDoDataAccessInterface<ToDoModel> toDoDataService;


    @Override
    public List<ToDoModel> getAllLists() {
        return toDoDataService.getAllLists();
    }

    @Override
    public boolean deleteList(long id) {
        return toDoDataService.deleteList(id);
    }

    @Override
    public long addOne(ToDoModel todoList) {
        return toDoDataService.addOne(todoList);
    }

    @Override
    public ToDoModel updateOne(long id, ToDoModel update) {
        return toDoDataService.updateOne(id, update);
    }

    @Override
    public List<ToDoModel> searchOne(String searchTerm) {
        return toDoDataService.searchOne(searchTerm);
    }

    @Override
    public List<ToDoModel> searchOneByDate(LocalDate date) {

        return toDoDataService.searchOneByDate(date);
    }

    @Override
    public void init() {

    }

    @Override
    public void delete() {

    }
}

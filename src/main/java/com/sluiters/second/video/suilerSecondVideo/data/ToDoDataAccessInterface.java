package com.sluiters.second.video.suilerSecondVideo.data;

import com.sluiters.second.video.suilerSecondVideo.models.ToDoModel;

import java.time.LocalDate;
import java.util.List;

public interface ToDoDataAccessInterface <T>{
    public List<T> getAllLists ();
    public  boolean deleteList(long id);
    public long addOne(T todoList);
    public T updateOne(long id, T update);
    public List<T> searchOne(String searchTerm);
    public List<T>searchOneByDate(LocalDate date);

}

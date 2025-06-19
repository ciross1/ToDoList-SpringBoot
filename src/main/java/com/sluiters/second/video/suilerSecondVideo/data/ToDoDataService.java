package com.sluiters.second.video.suilerSecondVideo.data;

import com.sluiters.second.video.suilerSecondVideo.models.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ToDoDataService implements ToDoDataAccessInterface<ToDoModel>{

  @Autowired
  ToDoDataRepository toDoRepository;

    @Override
    public List<ToDoModel> getAllLists() {

        List<ToDoModel> getAll = toDoRepository.findAll();

        return getAll;
    }

    @Override
    public boolean deleteList(long id) {

            if (toDoRepository.existsById(id)) {
                toDoRepository.deleteById(id);
                return true;
            }else{
                return false;

            }


    }
    @Override
    public long addOne(ToDoModel todoList) {

         ToDoModel savedList = toDoRepository.save(todoList);

         return savedList.getId();

    }

    @Override
    public ToDoModel updateOne(long id, ToDoModel update) {

        if(toDoRepository.existsById(id)){
           return toDoRepository.save(update);

        }
        return null;
    }

    @Override
    public List<ToDoModel> searchOne(String searchTerm) {
        return toDoRepository.
                findByAssignmentContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchTerm, searchTerm);
    }

    @Override
    public List<ToDoModel> searchOneByDate(LocalDate date) {
        return toDoRepository.findByDate(date);
    }
}

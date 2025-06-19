package com.sluiters.second.video.suilerSecondVideo.data;

import com.sluiters.second.video.suilerSecondVideo.models.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//JPA is the same as CrudRepository but more advanced

@Repository
public interface ToDoDataRepository extends JpaRepository<ToDoModel, Long> {

    //This will search for 2 parameters:

    List<ToDoModel>
    findByAssignmentContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String searchTerm, String searchTerm2);



    //This will search by date:

    List<ToDoModel> findByDate(LocalDate localDate);


}

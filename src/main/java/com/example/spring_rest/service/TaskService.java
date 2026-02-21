package com.example.spring_rest.service;

import com.example.spring_rest.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.spring_rest.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public List<Task> getUserTask(int userId){
        return taskRepo.getTaskByUserId(userId);
    }

    public Boolean addTask(Task tk){
        Boolean isCreated =  taskRepo.addTask(tk);
        return isCreated;
    }
}

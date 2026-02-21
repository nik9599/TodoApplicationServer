package com.example.spring_rest.controller;

import com.example.spring_rest.dto.ApiResponse;
import com.example.spring_rest.model.Task;
import com.example.spring_rest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskController {

    @Autowired
    private TaskService ts;

    @GetMapping("task/{userId}")
    public List<Task> getUserTask(@PathVariable int userId){
        return ts.getUserTask(userId);
    }

    @PostMapping("createTask")
    public ApiResponse creatTask(@RequestBody Task userTask){
        System.out.println(userTask);
        Boolean isCreated = ts.addTask(userTask);
        if(isCreated){
            return new ApiResponse("Task Created", 200);
        }else{
            return new ApiResponse("failed in creating task",  400);
        }
    }

}

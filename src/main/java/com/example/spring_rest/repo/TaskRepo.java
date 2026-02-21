package com.example.spring_rest.repo;

import com.example.spring_rest.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class TaskRepo {

    List<Task> taskList = new ArrayList<>(Arrays.asList(

            new Task(1, "Testing API",
                    "Test the login API functionality",
                    false, new Date(), "low", 1),

            new Task(2, "Fix Bug #101",
                    "Resolve null pointer exception in user service",
                    true, new Date(), "high", 2),

            new Task(3, "UI Improvement",
                    "Improve dashboard layout responsiveness",
                    false, new Date(), "medium", 3),

            new Task(4, "Write Unit Tests",
                    "Add unit tests for authentication module",
                    false, new Date(), "high", 4),

            new Task(5, "Database Optimization",
                    "Optimize slow running queries",
                    true, new Date(), "medium", 5),

            new Task(6, "Update Documentation",
                    "Update API documentation for new endpoints",
                    false, new Date(), "low", 1),

            new Task(7, "Code Refactoring",
                    "Refactor service layer for better readability",
                    false, new Date(), "medium", 2),

            new Task(8, "Security Check",
                    "Review password encryption implementation",
                    true, new Date(), "high", 3),

            new Task(9, "Implement Feature X",
                    "Develop task filtering functionality",
                    false, new Date(), "medium", 4),

            new Task(10, "Deployment Setup",
                    "Prepare staging environment configuration",
                    false, new Date(), "low", 5)

    ));

    public List<Task> getTaskByUserId(int userID){
        List<Task> userTask = new ArrayList<>();
        for (Task tk : taskList){
            if(tk.getUserId() == userID){
                userTask.add(tk);
            }
        }
        return  userTask;
    }

    public Boolean addTask(Task tk){
        int newTkId = tk.getId();
        taskList.add(tk);
        for (Task tl : taskList){
            if(tl.getId() == newTkId){
                return  true;
            }
        }
        return  false;
    }

}

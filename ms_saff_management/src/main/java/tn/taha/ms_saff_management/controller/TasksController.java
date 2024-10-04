package tn.taha.ms_saff_management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.taha.ms_saff_management.entities.Tasks;
import tn.taha.ms_saff_management.services.TaskServiceImp;


import java.util.List;

@RestController
@RequestMapping(value = "/api/tasks")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TasksController {
    @Autowired
    private TaskServiceImp taskService;

    // Endpoint to create a new task for a staff member
    @PostMapping("/add/{staffId}")
    public Tasks addTaskToStaff(@PathVariable int staffId, @RequestBody Tasks task) {
        return taskService.addTasktostaff(staffId, task);
    }

    // Endpoint to retrieve a task by ID
    @GetMapping("/gettask/{idTask}")
    public Tasks getTask(@PathVariable int idTask) {
        return taskService.GetTask(idTask);
    }

    // Endpoint to update a task by ID
    @PutMapping("/edit/{idTask}")
    public Tasks updateTask(@PathVariable int idTask, @RequestBody Tasks newTask) {
        return taskService.update(idTask, newTask);
    }

    // Endpoint to list all tasks of a specific staff member
    @GetMapping("/all/{staffId}")
    public List<Tasks> getAllTasksOfStaff(@PathVariable int staffId) {
        return taskService.all_tasks_ofstaff(staffId);
    }

    // Endpoint to delete a task by ID
    @DeleteMapping("/delete/{idTask}")
    public boolean deleteTask(@PathVariable int idTask) {
        return taskService.DeleteTask(idTask);
    }

}
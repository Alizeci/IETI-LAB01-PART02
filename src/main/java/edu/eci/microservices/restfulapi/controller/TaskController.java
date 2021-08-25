package edu.eci.microservices.restfulapi.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.eci.microservices.restfulapi.data.Task;
import edu.eci.microservices.restfulapi.dto.TaskDto;
import edu.eci.microservices.restfulapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> create (@RequestBody TaskDto taskDto) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(taskDto.getDueDate(), format);

        Task newTask = new Task(taskDto.getName(), taskDto.getDescription(), taskDto.getStatus() , taskDto.getAssignedTo(), date, LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(newTask));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Task> findById(@PathVariable String id){
     return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
    }

    @GetMapping
    public  ResponseEntity<List<Task>> all(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.all());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById (@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.deleteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDto taskDto, @PathVariable String id){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(taskDto.getDueDate(), format);

        Task taskUpdate = new Task(taskDto.getName(), taskDto.getDescription(), taskDto.getStatus() , taskDto.getAssignedTo(), date, LocalDate.now());
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(taskUpdate, id));
    }

}

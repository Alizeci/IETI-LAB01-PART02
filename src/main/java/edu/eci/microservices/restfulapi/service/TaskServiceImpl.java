package edu.eci.microservices.restfulapi.service;

import edu.eci.microservices.restfulapi.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaskServiceImpl implements TaskService {

    private HashMap<String, Task> tasks = new HashMap<>();
    private final AtomicInteger idGenerated = new AtomicInteger(0);

    @Override
    public Task create(Task task) {
        if (!tasks.containsKey(task.getId())) {
            String newId = ((Integer) idGenerated.getAndIncrement()).toString();
            task.setId(newId);
            tasks.put(newId, task);
        }
        return task;
    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> all() {
        List<Task> allTasks = new ArrayList<>();
        tasks.forEach((k, v) -> allTasks.add(v));
        return allTasks;
    }

    @Override
    public boolean deleteById(String id) {
        tasks.remove(id);
        return !tasks.containsKey(id);
    }

    @Override
    public Task update(Task task, String id) {
        task.setId(id);
        return tasks.put(id, task);
    }
}

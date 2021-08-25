package edu.eci.microservices.restfulapi.data;

import java.time.LocalDate;

public class Task {

    private String id;
    private String name;
    private String description;
    Status status;
    private String assignedTo;
    private LocalDate dueDate;
    private LocalDate created;

    public Task(String name, String description, Status status, String assignedTo, LocalDate dueDate, LocalDate created) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

}

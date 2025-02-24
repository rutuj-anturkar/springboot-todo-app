package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User extends BaseModel{

    private String userName;
    private String password;

    //@JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ToDo> tasklist = new ArrayList<>();

    // helper methods to add bidirectional association
    public void addTask(ToDo task){
        tasklist.add(task);
        task.setUser(this);
    }

    // to remove
    public void removeTask(ToDo task){
        tasklist.remove(task);
        task.setUser(null);
    }
}

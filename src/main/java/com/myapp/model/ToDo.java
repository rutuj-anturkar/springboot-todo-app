package com.myapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Tasks")
public class ToDo extends BaseModel{
    private String taskName;
    private String description;
    private LocalDateTime completionDate;

    @Enumerated(EnumType.STRING)
    private Status status= com.myapp.model.Status.CREATED;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

package com.myapp.dto;

import com.myapp.model.Status;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class TodoDTO extends BaseDTO{
    private String taskName;
    private String description;
    private LocalDateTime completionDate;
    private Status status= Status.CREATED;
}

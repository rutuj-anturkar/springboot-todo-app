package com.myapp.dto;

import com.myapp.model.Status;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class TodoDTO extends BaseDTO{
    @NotBlank
    private String taskName;
    @Max(value = 50, message = "Description cannot exceed 50 characters")
    private String description;
    private LocalDateTime completionDate;
    private Status status= Status.CREATED;
}

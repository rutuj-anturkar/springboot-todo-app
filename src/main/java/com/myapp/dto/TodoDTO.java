package com.myapp.dto;

import com.myapp.model.Status;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoDTO extends BaseDTO{
    @NotBlank
    private String taskName;
    @Length(min = 4,max = 50)
    private String description;
    private LocalDateTime completionDate;
    private Status status= Status.CREATED;
}

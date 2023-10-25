package com.example.ControllerAdvice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Serializable {
    private Long employeeId;
    private String name;
    private String email;
}

package com.hitit.interview.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {

    @Id
    @NotBlank(message = "Project Key is required field")
    private String key;

    @NotBlank(message = "Project Name is required field")
    private String name;

}

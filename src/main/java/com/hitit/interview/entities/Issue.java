package com.hitit.interview.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Issue {

    @Id
    @NotBlank(message = "Issue Key is required field")
    private String key;

    @NotBlank(message = "Issue Name is required field")
    private String name;

    @NotBlank(message = "Project Key is required field")
    private String projectKey;

}

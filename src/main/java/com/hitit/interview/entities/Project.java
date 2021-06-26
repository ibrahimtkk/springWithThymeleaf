package com.hitit.interview.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Project {

    @Id
    @NotBlank(message = "Project Key is required field")
    private String key;

    @NotBlank(message = "Project Name is required field")
    private String name;


    public Project() {}

    public Project(@NotBlank(message = "Project Key is required field") String key, @NotBlank(message = "Project Name is required field") String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

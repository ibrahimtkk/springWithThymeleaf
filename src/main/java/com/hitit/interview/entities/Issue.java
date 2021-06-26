package com.hitit.interview.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Issue {

    @Id
    @NotBlank(message = "Issue Key is required field")
    private String key;

    @NotBlank(message = "Issue Name is required field")
    private String name;

    @NotBlank(message = "Project Key is required field")
    private String projectKey;


    public Issue() {}

    public Issue(@NotBlank(message = "Issue Key is required field") String key, @NotBlank(message = "Issue Name is required field") String name, @NotBlank(message = "Project Key is required field") String projectKey) {
        this.key = key;
        this.name = name;
        this.projectKey = projectKey;
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

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }
}

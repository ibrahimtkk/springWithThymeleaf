package com.hitit.interview.restControllers;

import com.hitit.interview.POJO.IssueField;
import com.hitit.interview.POJO.ProjectField;
import com.hitit.interview.entities.Issue;
import com.hitit.interview.entities.Project;
import com.hitit.interview.repositories.IssueRepository;
import com.hitit.interview.repositories.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projectRest/")
public class ProjectRestController {

    private final ProjectRepository projectRepository;

    public ProjectRestController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping(value = "createProject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createProject(@RequestBody ProjectField projectField) {
        Project project = new Project(projectField.getProjectKey(), projectField.getProjectName());
        projectRepository.save(project);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}

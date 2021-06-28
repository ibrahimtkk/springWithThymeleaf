package com.hitit.interview.controllers;

import com.hitit.interview.entities.Issue;
import com.hitit.interview.entities.Project;
import com.hitit.interview.repositories.IssueRepository;
import com.hitit.interview.repositories.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectController {

    private final ProjectRepository projectRepository;
    public static IssueRepository issueRepository;
    private static Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    public ProjectController(ProjectRepository projectRepository, IssueRepository issueRepository) {
        this.projectRepository = projectRepository;
        this.issueRepository = issueRepository;
    }

    @GetMapping("/")
    public String empty(Model model) {
        List<Project> projects = (List<Project>) projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "index";
    }

    @GetMapping("/project/{key}")
    public String projectView(@PathVariable("key") String key, Model model) {
        Project project = projectRepository.findById(key).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + key));
        model.addAttribute("projectOf", project);
        List<Issue> issueList = issueRepository.findIssuesByProjectKey(key);
        model.addAttribute("issueList", issueList);
        return "view-project";
    }

    @GetMapping("/createProject")
    public String createProject(Project project) {
        return "add-project";
    }

    @PostMapping("/addProject")
    public String addProject(@Valid Project project, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-project";
        }

        projectRepository.save(project);
        return "redirect:/";
    }

    @GetMapping("/editProject/{key}")
    public String showProjectUpdateForm(@PathVariable("key") String key, Model model) {
        Project project = projectRepository.findByKey(key);
        model.addAttribute("project", project);

        return "update-project";
    }

    @PostMapping("/updateProject/{key}")
    public String updateProject(@PathVariable("key") String key, @Valid Project project, BindingResult result, Model model) {
        if (result.hasErrors()) {
            project.setKey(key);
            return "update-project";
        }

        projectRepository.save(project);

        return "redirect:/";
    }

}

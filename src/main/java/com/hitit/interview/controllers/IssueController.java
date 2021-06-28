package com.hitit.interview.controllers;

import com.hitit.interview.entities.Issue;
import com.hitit.interview.entities.Project;
import com.hitit.interview.repositories.IssueRepository;
import com.hitit.interview.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class IssueController {

    private final IssueRepository issueRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public IssueController(IssueRepository issueRepository, ProjectRepository projectRepository) {
        this.issueRepository = issueRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/createIssue/{projectKey}")
    public String createIssue(@PathVariable("projectKey") String projectKey, Model model) {
        model.addAttribute("projectKey", projectKey);
        return "add-issue";
    }

    @GetMapping("/issueByProject/{projectKey}")
    public String getIssuesByProjectKey(@PathVariable("projectKey") String projectKey, Model model) {
        List<Issue> issueList = issueRepository.findIssuesByProjectKey(projectKey);
        model.addAttribute("issueList", issueList);
        Project project = projectRepository.findById(projectKey).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + projectKey));
        model.addAttribute("projectOf", project);
        return "view-project";
    }

    @PostMapping("/addIssue")
    public String addProject(@Valid Issue issue, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-issue";
        }
        issueRepository.save(issue);
        return "redirect:/";
    }

    @GetMapping("/deleteIssue/{key}")
    public String deleteIssue(HttpServletRequest request, @PathVariable("key") String key, Model model) {
        List<Issue> issues = (List<Issue>) issueRepository.findAll();
        Optional<Issue> optionalIssue = issueRepository.findById(key);
        Issue issue = optionalIssue.get();
        issueRepository.delete(issue);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}

package com.hitit.interview.restControllers;

import com.hitit.interview.POJO.IssueField;
import com.hitit.interview.entities.Issue;
import com.hitit.interview.repositories.IssueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issueRest/")
public class IssueRestController {

    private final IssueRepository issueRepository;

    public IssueRestController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @RequestMapping(value = "createIssue", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createIssue(@RequestBody IssueField issueField) {
        Issue issue = new Issue(issueField.getIssueKey(), issueField.getIssueName(), issueField.getProjectKey());
        issueRepository.save(issue);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}

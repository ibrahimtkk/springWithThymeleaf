package com.hitit.interview.repositories;

import com.hitit.interview.entities.Issue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends CrudRepository<Issue, String> {

    List<Issue> findIssuesByProjectKey(String projectKey);

}

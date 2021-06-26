package com.hitit.interview.repositories;

import com.hitit.interview.entities.Issue;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends CrudRepository<Issue, String> {

    Issue findByName(String name);

    @Modifying
    @Query(value = "SELECT i FROM Issue i WHERE i.key= ?1")
    Issue findByKey(String key);


    @Modifying
    @Query(value = "SELECT p FROM Issue p WHERE p.projectKey= ?1")
    List<Issue> findByProjectKey(String projectKey);

    @Modifying
    @Query("delete from Issue u where u.key=:key")
    void deleteIssueByIssueKey(@Param("key") String key);

}

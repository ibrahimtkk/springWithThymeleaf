package com.hitit.interview.repositories;

import com.hitit.interview.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

    Project findByKey(String key);

}

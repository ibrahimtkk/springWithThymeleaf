package com.hitit.interview.repositories;

import com.hitit.interview.entities.Project;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

    Project findByName(String name);

    @Modifying
    @Query(value = "SELECT p FROM Project p WHERE p.key= ?1")
    Project findByKey(String key);

}

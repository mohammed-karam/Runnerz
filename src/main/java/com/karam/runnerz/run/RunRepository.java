package com.karam.runnerz.run;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunRepository extends ListCrudRepository<Run, Integer> {
    List<Run> findByLocation(String location);
}

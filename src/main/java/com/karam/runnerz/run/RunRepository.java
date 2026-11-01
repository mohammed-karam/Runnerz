package com.karam.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    public List<Run> findAll() {
        return runs;
    }

    public Optional<Run> findById(int id) {
        return runs.stream().filter(
                run -> Objects.equals(run.id(), id)
        ).findFirst();
    }

    public void addRun(Run run){
        runs.add(run);
    }

    public void updateRun(Run run,Integer id){
        Optional<Run> byId = findById(id);
        if(byId.isPresent()){
            runs.set(runs.indexOf(byId.get()), run);
        }
    }

    public void deleteRun(Integer id){
        runs.removeIf(run -> Objects.equals(run.id(), id));
    }

    @PostConstruct
    public void init() {
        runs.add(
                new Run(
                        1, "Monday", LocalDateTime.now(),
                        LocalDateTime.now().plus(30,
                                ChronoUnit.MINUTES),
                        3, Location.INDOOR
                )
        );
        runs.add(
                new Run(
                        2, "Thursday", LocalDateTime.now(),
                        LocalDateTime.now().plus(30,
                                ChronoUnit.MINUTES),
                        3, Location.OUTDOOR
                )
        );
    }
}

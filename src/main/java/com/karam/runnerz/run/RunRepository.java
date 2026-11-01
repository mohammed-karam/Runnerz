package com.karam.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
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

    final JdbcClient jdbcClient;
    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    private List<Run> runs = new ArrayList<>();

    public List<Run> findAll (){
        return jdbcClient.sql(
                "SELECT * FROM Run"
        ).query(Run.class).list();
    }

    public Optional<Run> findById(int id) {
        return jdbcClient.sql("SELECT * FROM Run WHERE id = :id").param("id",id).query(Run.class).optional();
    }

    public void create(Run run) {
        jdbcClient.sql("INSERT INTO Run (id, title, start_time, completed_on, miles, location) VALUES (?, ?, ?, ?, ?, ?)")
                .params(List.of(run.id(), run.title(), run.startTime(),
                        run.completedOn(), run.miles(), run.location().toString()))
                .update();
    }

    public void update(Run run, Integer id) {
        jdbcClient.sql("UPDATE Run SET title = ?, start_time = ?, completed_on = ?, miles = ?, location = ? WHERE id = ?")
                .params(List.of(run.title(), run.startTime(), run.completedOn(),
                        run.miles(), run.location().toString(), id))
                .update();
    }

    public void delete(Integer id) {
        jdbcClient.sql("DELETE FROM Run WHERE id = :id")
                .param("id", id)
                .update();
    }

    public int count() {
        return jdbcClient.sql("SELECT COUNT(*) FROM Run")
                .query()
                .listOfRows()
                .size();
    }





}

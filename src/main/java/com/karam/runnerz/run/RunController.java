package com.karam.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("/hello")
    String home (){
        return "Hello, Runnerz";
    }

    @GetMapping("")
    List<Run> runs(){
        return runRepository.findAll();
    }


    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> byId = runRepository.findById(id);
        if(byId.isEmpty()){
            throw new RunNotFoundException("Run with id " + id + " not found");
        }
        return byId.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void addRun(@Valid @RequestBody Run run){
        runRepository.create(run);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    void updateRun(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    void deleteRun(@PathVariable Integer id){
        runRepository.delete(id);
    }
}

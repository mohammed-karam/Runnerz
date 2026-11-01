package com.karam.runnerz.run;

import aj.org.objectweb.asm.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

import java.io.InputStream;

@Component
public class JsonLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JsonLoader.class);

    private final RunRepository runRepository;
    private final JsonMapper jsonMapper;

    public JsonLoader(RunRepository runRepository, JsonMapper jsonMapper) {
        this.runRepository = runRepository;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (runRepository.count() <=1) {
            try (InputStream in = TypeReference.class.getResourceAsStream("/data/runs.json")) {
                Runs allRuns = jsonMapper.readValue(in, Runs.class);
                log.info("Reading {} runs from JSON data", allRuns.runs().size());
                allRuns.runs().forEach(runRepository::create);
            }
        } else {
            log.info("Not loading runs from JSON because the collection contains data.");
            log.info (runRepository.count() + " runs");
        }
    }
}
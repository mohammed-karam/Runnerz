package com.karam.runnerz.run;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(
        @Id
        Integer id,

        @NotEmpty
        String title,

        LocalDateTime startTime,
        LocalDateTime completedOn,

        @Positive
        Integer miles,
        Location location,
        @Version
        Integer version
) {
    public Run {
        if (!completedOn.isAfter(startTime)) {
            throw new IllegalArgumentException("completedOn can't be before start time " + LocalDateTime.now());
        }
    }
}

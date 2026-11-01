package com.karam.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,

        @NotEmpty
        String title,

        LocalDateTime startTime,
        LocalDateTime completedOn,

        @Positive
        Integer miles,
        Location location
) {
    public Run {
        if (!completedOn.isAfter(startTime)) {
            throw new IllegalArgumentException("completedOn can't be before start time " + LocalDateTime.now());
        }
    }
}

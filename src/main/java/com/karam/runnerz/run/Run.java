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
        if (completedOn.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("completedOn can't be before start time " + LocalDateTime.now());
        }
    }
}

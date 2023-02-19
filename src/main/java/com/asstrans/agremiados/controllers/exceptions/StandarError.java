package com.asstrans.agremiados.controllers.exceptions;

import java.time.Instant;

public record StandarError(
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path
) {
}

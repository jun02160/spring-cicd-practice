package com.example.seminar.controller;

import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    private final HealthCheckController healthCheckController;

    public HealthCheckService(HealthCheckController healthCheckController) {
        this.healthCheckController = healthCheckController;
    }

}

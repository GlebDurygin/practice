package com.company.practice.service;

import com.company.practice.entity.Algorithm;

public interface ProcessService {
    String NAME = "practice_ProcessService";

    Algorithm run(Algorithm algorithm);
}
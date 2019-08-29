package com.company.practice.service;

import com.company.practice.entity.Algorithm;

public interface RandomNumberService {
    String NAME = "practice_RandomNumberService";

    long run(Algorithm algorithm);
}
package com.company.practice.service;

import com.company.practice.entity.Algorithm;

public interface HashService {
    String NAME = "practice_HashService";

    long run(Algorithm algorithm);
}
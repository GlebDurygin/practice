package com.company.practice.service;

import com.company.practice.entity.Algorithm;

public interface VerifierService {
    String NAME = "practice_VerifierService";

    void run(Algorithm algorithm);
}
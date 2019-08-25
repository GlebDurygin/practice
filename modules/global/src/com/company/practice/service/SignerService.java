package com.company.practice.service;

import com.company.practice.entity.Algorithm;

public interface SignerService {
    String NAME = "practice_SignerService";

    void run(Algorithm algorithm);
}
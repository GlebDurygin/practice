package com.company.practice.service;

import com.company.practice.entity.Algorithm;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(ProcessService.NAME)
public class ProcessServiceBean implements ProcessService {

    protected static final int NUMBER_OF_OPERATIONS = 10;

    @Inject
    protected HashService hashService;
    @Inject
    protected SignerService signerService;
    @Inject
    protected VerifierService verifierService;
    @Inject
    protected RandomNumberService randomNumberService;

    @Override
    public long[] run(Algorithm algorithm) {
        long start = System.currentTimeMillis();
        long memoryStart = Runtime.getRuntime().freeMemory();
        long memoryFinish = 0;
        switch (algorithm.getInfo().getType()) {
            case HASH:
                memoryFinish = hashService.run(algorithm);
                break;
            case SIGNING:
                memoryFinish = signerService.run(algorithm);
                break;
            case VERIFYING:
                memoryFinish = verifierService.run(algorithm);
                break;
            case RANDOM_NUMBER:
                memoryFinish = randomNumberService.run(algorithm);
                break;
            default:
                break;
        }
        long finish = System.currentTimeMillis();
        long[] results = new long[2];
        results[0] = finish - start;
        results[1] = Math.abs((memoryStart - memoryFinish) / 1024);
        return results;
    }

    @Override
    public Algorithm runAlgorithm(Algorithm algorithm) {
        long[] times = new long[NUMBER_OF_OPERATIONS];
        long[] memories = new long[NUMBER_OF_OPERATIONS];
        for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
            long[] results = run(algorithm);
            times[i] = results[0];
            memories[i] = results[1];
        }
        double time = Arrays.stream(times).average().orElse(Double.NaN);
        double memory = Arrays.stream(memories).average().orElse(Double.NaN);
        algorithm.setTime(time);
        algorithm.setMemory(memory);
        return algorithm;
    }
}
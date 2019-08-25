package com.company.practice.service;

import com.company.practice.entity.Algorithm;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(ProcessService.NAME)
public class ProcessServiceBean implements ProcessService {

    @Inject
    protected HashService hashService;
    @Inject
    protected SignerService signerService;
    @Inject
    protected VerifierService verifierService;
    @Inject
    protected RandomNumberService randomNumberService;

    @Override
    public Algorithm run(Algorithm algorithm) {
        long start = System.currentTimeMillis();
        long memoryStart = Runtime.getRuntime().freeMemory();
        switch (algorithm.getInfo().getType()) {
            case HASH:
                hashService.run(algorithm);
                break;
            case SIGNING:
                signerService.run(algorithm);
                break;
            case VERIFYING:
                verifierService.run(algorithm);
                break;
            case RANDOM_NUMBER:
                randomNumberService.run(algorithm);
                break;
            default:
                break;
        }
        long finish = System.currentTimeMillis();
        long memoryFinish = Runtime.getRuntime().freeMemory();
        algorithm.setTime(finish - start);
        algorithm.setMemory(Math.abs((double) ((memoryStart - memoryFinish) / 1024)));
        return algorithm;
    }
}
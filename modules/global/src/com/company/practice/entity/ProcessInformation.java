package com.company.practice.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

public enum ProcessInformation implements EnumClass<String> {
    // Hash functions
    HASH_GOST3411("BC.Hash GOST R 34.11-94", AlgorithmType.HASH),
    HASH_MD2("BC.Hash MD2", AlgorithmType.HASH),
    HASH_MD4("BC.Hash MD4", AlgorithmType.HASH),
    HASH_MD5("BC.Hash MD5", AlgorithmType.HASH),
    HASH_SHA1("BC.Hash SHA-1", AlgorithmType.HASH),
    HASH_SHA224("BC.Hash SHA-224", AlgorithmType.HASH),
    HASH_SHA256("BC.Hash SHA-256", AlgorithmType.HASH),
    HASH_SHA384("BC.Hash SHA-384", AlgorithmType.HASH),
    HASH_SHA512("BC.Hash SHA-512", AlgorithmType.HASH),
    HASH_TIGER("BC.Hash Tiger", AlgorithmType.HASH),
    HASH_RIPEMD128("BC.Hash RIPEMD128", AlgorithmType.HASH),
    HASH_RIPEMD160("BC.Hash RIPEMD160", AlgorithmType.HASH),
    HASH_RIPEMD256("BC.Hash RIPEMD256", AlgorithmType.HASH),
    HASH_RIPEMD320("BC.Hash RIPEMD320", AlgorithmType.HASH),
    HASH_WHIRLPOOL("BC.Hash Whirlpool", AlgorithmType.HASH),

    // Signing
    SIGNING_DSA("BC.Signing DSA", AlgorithmType.SIGNING),
    SIGNING_RSA("BC.Signing RSA", AlgorithmType.SIGNING),
    SIGNING_ECDSA("BC.Signing ECDSA", AlgorithmType.SIGNING),

    // Verifying signature
    VERIFYING_DSA("BC.Verifying DSA", AlgorithmType.VERIFYING),
    VERIFYING_RSA("BC.Verifying RSA", AlgorithmType.VERIFYING),
    VERIFYING_ECDSA("BC.Verifying ECDSA", AlgorithmType.VERIFYING),

    // Random generators based on the digest with counter
    RANDOM_NUMBER_GOST3411("BC.Random number GOST R 34.11-94", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_MD2("BC.Random number MD2", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_MD4("BC.Random number MD4", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_MD5("BC.Random number MD5", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_SHA1("BC.Random number SHA-1", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_SHA224("BC.Random number SHA-224", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_SHA256("BC.Random number SHA-256", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_SHA384("BC.Random number SHA-384", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_SHA512("BC.Random number SHA-512", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_TIGER("BC.Random number Tiger", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_RIPEMD128("BC.Random number RIPEMD128", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_RIPEMD160("BC.Random number RIPEMD160", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_RIPEMD256("BC.Random number RIPEMD256", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_RIPEMD320("BC.Random number RIPEMD320", AlgorithmType.RANDOM_NUMBER),
    RANDOM_NUMBER_WHIRLPOOL("BC.Random number Whirlpool", AlgorithmType.RANDOM_NUMBER);

    private final String name;
    private AlgorithmType type;

    ProcessInformation(String name, AlgorithmType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getId() {
        return name;
    }

    public static String getId(ProcessInformation process) {
        return process != null ? process.getId() : null;
    }

    public static ProcessInformation fromId(String id) {
        for (ProcessInformation process : values()) {
            if (process.getId().equals(id)) {
                return process;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public AlgorithmType getType() {
        return type;
    }
}

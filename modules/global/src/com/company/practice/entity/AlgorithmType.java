package com.company.practice.entity;


import com.haulmont.chile.core.datatypes.impl.EnumClass;

public enum AlgorithmType implements EnumClass<Integer> {
    HASH(1),
    SIGNING(2),
    VERIFYING(3),
    RANDOM_NUMBER(4);

    private final Integer id;

    AlgorithmType(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public static Integer getId(AlgorithmType algorithmType) {
        return algorithmType != null ? algorithmType.getId() : null;
    }

    public static AlgorithmType fromId(Integer id) {
        for (AlgorithmType algorithmType : values()) {
            if (algorithmType.getId().equals(id)) {
                return algorithmType;
            }
        }
        return null;
    }
}

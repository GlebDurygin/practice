package com.company.practice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|name")
@Table(name = "PRACTICE_ALGORITHM")
@Entity(name = "practice_Algorithm")
public class Algorithm extends StandardEntity {
    private static final long serialVersionUID = -5900169551749997635L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "TYPE_")
    protected Integer type;

    @Column(name = "INFO")
    protected String info;

    @Column(name = "TIME_")
    protected Double time;

    @Column(name = "MEMORY")
    protected Double memory;

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getTime() {
        return time;
    }

    public AlgorithmType getType() {
        return type == null ? null : AlgorithmType.fromId(type);
    }

    public void setType(AlgorithmType type) {
        this.type = type == null ? null : type.getId();
    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }

    public Double getMemory() {
        return memory;
    }

    public ProcessInformation getInfo() {
        return info == null ? null : ProcessInformation.fromId(info);
    }

    public void setInfo(ProcessInformation info) {
        this.info = info == null ? null : info.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
package com.microservices.alexandre.limitsservices.bean;

import lombok.Data;

@Data
public class LimitConfiguration {

    private int min;
    private int max;

    public LimitConfiguration(int min, int max) {
        this.min = min;
        this.max = max;
    }
}


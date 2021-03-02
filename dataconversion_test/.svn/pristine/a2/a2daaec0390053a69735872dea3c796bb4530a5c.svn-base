package com.haiziwang.commodity.utils;

public class PerformanceUtil {
    long startStake = 0L;

    public PerformanceUtil() {
        startStake = System.currentTimeMillis();
    }

    public long PERFORM_TIME() {
        long perform = System.currentTimeMillis() - startStake;
        startStake = System.currentTimeMillis();
        return perform;
    }
}

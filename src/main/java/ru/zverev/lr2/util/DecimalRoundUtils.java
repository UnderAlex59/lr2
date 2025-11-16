package ru.zverev.lr2.util;

public class DecimalRoundUtils {

    public static Double roundWithPrecision(Double value, Integer precision) {
        return Math.round(value * Math.pow(10, precision)) / Math.pow(10, precision);
    }
}

package com.epam.aicode.java;

import java.math.BigDecimal;
import java.util.List;

public final class BigDecimalUtils {

    private BigDecimalUtils() {
    }

    public static void transform(List<BigDecimal> numbers, BigDecimalTransformer transformer) {
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, transformer.transform(numbers.get(i)));
        }
    }
}

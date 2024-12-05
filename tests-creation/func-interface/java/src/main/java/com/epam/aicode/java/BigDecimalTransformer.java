package com.epam.aicode.java;

import java.math.BigDecimal;

@FunctionalInterface
public interface BigDecimalTransformer {
    BigDecimal transform(BigDecimal value);
}

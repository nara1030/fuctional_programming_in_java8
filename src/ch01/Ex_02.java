package ch01;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Ex_02 {
    public static void main(final String[] args) {
        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"),
                new BigDecimal("30"),
                new BigDecimal("17"),
                new BigDecimal("20"),
                new BigDecimal("15"),
                new BigDecimal("18"),
                new BigDecimal("45"),
                new BigDecimal("12")
        );

        DiscountImperative discountImperative = new DiscountImperative();
        discountImperative.discountImperative(prices);

        DiscountFunctional discountFunctional = new DiscountFunctional();
        discountFunctional.discountFunctional(prices);
    }
}

class DiscountImperative {
    BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

    void discountImperative(final List<BigDecimal> prices) {
        for (BigDecimal price : prices) {
            if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }
}

class DiscountFunctional {
    void discountFunctional(final List<BigDecimal> prices) {
        final BigDecimal totalOfDiscountedPrices = prices
                .stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }
}
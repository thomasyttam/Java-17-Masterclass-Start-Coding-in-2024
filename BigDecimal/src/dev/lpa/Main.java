package dev.lpa;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        double policyAmount = 100_000_000;
        int beneficiaries = 3;
        float percentageFloat = 1.0f / beneficiaries;
        double percentage = 1.0 / beneficiaries;

        System.out.printf("Payout = %,.2f%n", policyAmount * percentageFloat); // 33,333,334.33
        System.out.printf("Payout = %,.2f%n", policyAmount * percentage); //33,333,333.33

        double totalUsingFloat = policyAmount -
                ((policyAmount * percentageFloat) * beneficiaries);
        System.out.printf("totalUsingFloat: %,.2f%n", totalUsingFloat); // -2.98

        double total = policyAmount -
                ((policyAmount * percentage) * beneficiaries);
        System.out.printf("total: %,.2f%n", total); // 0

        String[] tests = {"15.456", "8", "10000.000001", ".123"};
        BigDecimal[] bds = new BigDecimal[tests.length];
        Arrays.setAll(bds, i -> new BigDecimal(tests[i]));

        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale",
                "Precision");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

//        double[] doubles = {15.450, 8, 10000.000001, .123};
        double[] doubles = {15.456, 8, 10000.000001, .125};
//        Arrays.setAll(bds, i -> new BigDecimal(doubles[i])); // use floating point approximation which is unpredictable
        Arrays.setAll(bds, i -> BigDecimal.valueOf(doubles[i])); // Double. toString(double)
        System.out.println("---------------------------");
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale",
                "Precision");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
//            bd.setScale(2, RoundingMode.HALF_UP);
            bd = bd.setScale(2, RoundingMode.HALF_UP); // BigDecimal is immutable, every method use on BigDecimal, will need to be assigned to some variable.
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

//        BigDecimal policyPayout = new BigDecimal("100_000_000"); // cannot use underline, L, F, "," in the string for BigDecimal
        BigDecimal policyPayoutTemp = new BigDecimal("100000000");
        BigDecimal policyPayoutTemp2 = new BigDecimal("100e6");
        BigDecimal policyPayout = new BigDecimal("100000000.00");
        System.out.printf("%-15s %-15d %-8d %d %n",
                policyPayoutTemp, policyPayoutTemp.unscaledValue(), policyPayoutTemp.scale(),
                policyPayoutTemp.precision());
        System.out.printf("%-15s %-15d %-8d %d %n",
                policyPayoutTemp2, policyPayoutTemp2.unscaledValue(), policyPayoutTemp2.scale(),
                policyPayoutTemp2.precision());
        System.out.printf("%-15s %-15d %-8d %d %n",
                policyPayout, policyPayout.unscaledValue(), policyPayout.scale(),
                policyPayout.precision());

//        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries));
//        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries),
//                MathContext.UNLIMITED);
//        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries),
//                MathContext.DECIMAL128); // DECIMAL32 7 scale, DECIMAL64 16 digit, DECIMAL128 34 digit
        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries),
                new MathContext(60, RoundingMode.UP));
        System.out.println(percent);

        BigDecimal checkAmount = policyPayout.multiply(percent);
        System.out.printf("%.2f%n", checkAmount);
        checkAmount = checkAmount.setScale(2, RoundingMode.HALF_UP); // set scale of checkAmount to 2 same as policyPayout
        System.out.printf("%-15s %-15d %-8d %d %n",
                checkAmount, checkAmount.unscaledValue(), checkAmount.scale(),
                checkAmount.precision());

        BigDecimal totalChecksAmount = checkAmount.multiply(
                BigDecimal.valueOf(beneficiaries));
        System.out.printf("Combined: %.2f%n", totalChecksAmount);
        System.out.println("Remaining = " + policyPayout.subtract(totalChecksAmount));

        System.out.printf("%-15s %-15d %-8d %d %n",
                totalChecksAmount, totalChecksAmount.unscaledValue(),
                totalChecksAmount.scale(), totalChecksAmount.precision());

//        BigDecimal test1 = new BigDecimal("1.1111122222333334444455555");
//        BigDecimal test2 = BigDecimal.valueOf(1.1111122222333334444455555);
//
//        System.out.println("---------------------------");
//        System.out.printf("%-30s %-30s %-8s %s%n", "Value", "Unscaled Value", "Scale",
//                "Precision");
//        System.out.printf("%-30s %-30d %-8d %d %n",
//                test1, test1.unscaledValue(), test1.scale(), test1.precision());
//        System.out.printf("%-30s %-30d %-8d %d %n",
//                test2, test2.unscaledValue(), test2.scale(), test2.precision()); // scale(decimal place) only 16 as float


    }
}

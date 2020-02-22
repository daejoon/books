package com.ddoong2.chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() >= 100_000 ?
                12 * ( payData.getPayAmount() / 100_000) +
                payData.getPayAmount() % 100_000 / 10_000
                : payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
        if (isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)) {

            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            if (dayLenOfCandiMon <
                    dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(
                        dayLenOfCandiMon
                );
            }

            return candidateExp.withDayOfMonth(
                    dayOfFirstBilling
            );
        } else {
            return candidateExp;
        }
    }

    private boolean isSameDayOfMonth(LocalDate fistBillingDate, LocalDate candidateExp) {
        return fistBillingDate.getDayOfMonth() != candidateExp.getDayOfMonth();
    }

    private int lastDayOfMonth(LocalDate candidateExp) {
        return YearMonth.from(candidateExp).lengthOfMonth();
    }
}

package Homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Studio {
    private final int id;
    private BigDecimal pricePerHour;
    private int maxWorkingHours;
    private int workedHours;
    private static BigDecimal minPricePerHour = BigDecimal.ZERO;
    private static BigDecimal currencyEuro;

    public Studio(int id, int maxWorkingHours) {
        this.id = id;
        this.maxWorkingHours = (maxWorkingHours >= 0 && maxWorkingHours <= 24) ? maxWorkingHours : 24;
        this.workedHours = 0;
    }

    public static void setMinPricePerHour(BigDecimal minPrice) {
        minPricePerHour = minPrice.compareTo(BigDecimal.ZERO) >= 0 ? minPrice : BigDecimal.ZERO;
    }

    public static void setCurrencyEuro(BigDecimal currency) {
        currencyEuro = currency;
    }

    public void setPricePerHour(BigDecimal price) {
        this.pricePerHour = price.compareTo(minPricePerHour) >= 0 ? price : minPricePerHour;
    }

    public void setWorkedHours(int hours) {
        this.workedHours = (hours <= maxWorkingHours) ? hours : maxWorkingHours;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public static BigDecimal getMinPricePerHour() {
        return minPricePerHour;
    }

    public static BigDecimal getCurrencyEuro() {
        return currencyEuro;
    }

    public BigDecimal getTurnoverInLev() {
        return pricePerHour.multiply(BigDecimal.valueOf(workedHours)).setScale(1, RoundingMode.HALF_UP);
    }

    public BigDecimal getTurnoverInEuro() {
        return getTurnoverInLev().multiply(currencyEuro).setScale(3, RoundingMode.HALF_UP);
    }

    public static Studio compareByPrice(Studio s1, Studio s2) {
        return s1.getPricePerHour().compareTo(s2.getPricePerHour()) > 0 ? s1 : s2;
    }

    public static boolean compareByTurnover(Studio s1, Studio s2) {
        return s1.getTurnoverInLev().compareTo(s2.getTurnoverInLev()) > 0;
    }
}

public class StudioTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int id1 = scanner.nextInt();
        int maxHours1 = scanner.nextInt();
        BigDecimal minPrice = scanner.nextBigDecimal();
        BigDecimal currency = scanner.nextBigDecimal();
        BigDecimal price1 = scanner.nextBigDecimal();
        int workedHours1 = scanner.nextInt();

        int id2 = scanner.nextInt();
        int maxHours2 = scanner.nextInt();
        BigDecimal price2 = scanner.nextBigDecimal();
        int workedHours2 = scanner.nextInt();

        Studio.setMinPricePerHour(minPrice);
        Studio.setCurrencyEuro(currency);

        Studio studio1 = new Studio(id1, maxHours1);
        studio1.setPricePerHour(price1);
        studio1.setWorkedHours(workedHours1);

        Studio studio2 = new Studio(id2, maxHours2);
        studio2.setPricePerHour(price2);
        studio2.setWorkedHours(workedHours2);

        System.out.println(studio1.getTurnoverInLev());
        System.out.println(studio1.getTurnoverInEuro());
        System.out.println(Studio.compareByPrice(studio1, studio2).getId());
        System.out.println(Studio.compareByTurnover(studio1, studio2));
    }
}



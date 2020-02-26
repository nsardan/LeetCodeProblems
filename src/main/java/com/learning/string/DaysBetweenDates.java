package com.learning.string;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DaysBetweenDates {

    public int daysBetweenDates(String date1, String date2) {
        String formatter = "yyyy-MM-dd";
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern(formatter);
        LocalDate d1 = LocalDate.parse(date1, sdf);
        LocalDate d2 = LocalDate.parse(date2, sdf);

        Period period = Period.between(d1, d2);
        if(period.getDays()< 0){
            return -1*period.getDays();
        }

        return period.getDays();
    }

    public static void main(String[] args) {
        DaysBetweenDates dates = new DaysBetweenDates();
        String date1 = "2020-01-15";
        String date2 = "2019-12-31";
        int date = dates.daysBetweenDates(date1, date2);
        System.out.println(date);

    }
}

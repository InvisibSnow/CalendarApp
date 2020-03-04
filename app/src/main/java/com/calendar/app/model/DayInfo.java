package com.calendar.app.model;

public class DayInfo {

    private int dateNumber;

    public DayInfo(int firstDayOfTheMonth) {
        this.dateNumber = firstDayOfTheMonth;
    }

    public int getDateNumber() {
        return dateNumber;
    }
}

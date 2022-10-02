package com.jinho.jihusenpai.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateService {
    private SimpleDateFormat dateFormat;
    DateService() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getTodayDateString() {
        Date today = new Date();
        return dateFormat.format(today);
    }
    public String getYesterdayDateString() {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, -1);
        return dateFormat.format(calendar.getTime());
    }
}

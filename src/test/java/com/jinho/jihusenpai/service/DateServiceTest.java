package com.jinho.jihusenpai.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DateServiceTest {
    SimpleDateFormat dateFormat;

    @Test
    void getTodayDateStringTest() {
        Date today = new Date();
        System.out.println("testtesttest " + today);
    }
}
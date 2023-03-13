package com.highandbrightdev.bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrettyPrinter {
    static final DateTimeFormatter exactTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSS");
    static void doubleLines(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("=");
        }
        System.out.println(sb);
    }

    static String exactTime(LocalDateTime at) {
        return at.format(exactTimeFormatter);
    }
}

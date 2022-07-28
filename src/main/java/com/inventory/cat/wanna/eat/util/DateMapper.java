package com.inventory.cat.wanna.eat.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateMapper {
    public String asString(LocalDate date) {
        return date != null ? DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .format(date) : null;
    }

    public LocalDate asDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return date != null ? LocalDate.parse(date, dtf) : null;
        }
        catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }
}

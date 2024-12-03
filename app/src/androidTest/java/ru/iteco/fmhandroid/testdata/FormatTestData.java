package ru.iteco.fmhandroid.testdata;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class FormatTestData {

    public static final String TODAY =  OffsetDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    public static final String TOMORROW =  OffsetDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    public static final String LAST_DAY = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("31.12.2100"));
}

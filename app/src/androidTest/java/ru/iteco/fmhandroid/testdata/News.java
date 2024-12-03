package ru.iteco.fmhandroid.testdata;

import static ru.iteco.fmhandroid.testdata.FormatTestData.TODAY;
import static ru.iteco.fmhandroid.testdata.FormatTestData.TOMORROW;
import static ru.iteco.fmhandroid.testdata.FormatTestData.LAST_DAY;

public enum News {

    TODAY_NEWS(
            "Зарплата",
            "Внимание!!!",
            TODAY,
            "00:01",
            "13 зарплата!!!",
            "Лебедев Д.А."
    ),
    TOMORROW_NEWS(
            "Профсоюз",
            "ДР Сидорова!!",
            TOMORROW,
            "01:00",
            "Сдаём по 1000р.",
            "Лебедев Д.А."
    ),
    LAST_DAY_NEWS(
            "Праздник",
            "ДАЗДАПЕРМА!!",
            LAST_DAY,
            "00:00",
            "С праздником, " +
                    "дорогие товарищи!!",
            "Лебедев Д.А."
    ),
    EMPTY_NEWS(
            "",
            "",
            "",
            "",
            "",
            "Лебедев Д.А."
    );

    private final String category;
    private final String title;
    private final String publicationDate;
    private final String time;
    private final String description;
    private final String author;

    News(String category, String title, String publicationDate,
         String time, String description, String author) {
        this.category = category;
        this.title = title;
        this.publicationDate = publicationDate;
        this.time = time;
        this.description = description;
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }
}

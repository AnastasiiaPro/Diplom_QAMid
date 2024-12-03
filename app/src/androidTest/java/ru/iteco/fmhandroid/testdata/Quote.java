package ru.iteco.fmhandroid.testdata;

public enum Quote {

    QUOTE(
            "Хоспис в своем истинном понимании - это творчество",
            "Нет шаблона и стандарта, есть только дух, " +
                    "который живет в разных домах по-разному. " +
                    "Но всегда он добрый, любящий и помогающий.");

    private final String title;
    private final String description;

    Quote(String login, String description) {
        this.title = login;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

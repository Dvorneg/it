package ru.inventarit.model;

public enum TypeOf {
    BUILDINGS("Здания"),
    OFFICE_EQUIPMENT("Офисное оборудование"),
    OTHER("Другие");

    private String title;

    TypeOf(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "TypeOf{" +
                "title='" + title + '\'' +
                '}';
    }

}

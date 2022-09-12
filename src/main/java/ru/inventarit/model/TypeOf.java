package ru.inventarit.model;


public enum TypeOf  {
    BUILDINGS("Здания"),
    FACILITIES("Сооружения"),
    //Machines and equipment (except for office one)
    MACHINES_AND_EQUIPMENT("Машины и оборудование (кроме офисного)"),
    OFFICE_EQUIPMENT ("Офисное оборудование"),
    VEHICLES ("Транспортные средства"),
    //Production and maintenance tools
    PRODUCTION_AND_MAINTENANCE ("Производственный и хозяйственный инвентарь"),
    LAND_LOTS ("Земельные участки"),
    //Capital investment in leased assets
    CAPITAL_INVESTMENT("Капитальные вложения в арендованное имущество"),
    //Other objects requiring the state registration and classified as real estate according to article 130 of the CC of the RF
    //OTHER_STATE_REGISTRATION_TO_ARTICLE_130("Прочие объекты, требующие государственной регистрации, относимые статьей 130 ГК РФ к недвижимости"),
    OTHER("Другие");

    private final String name;

    TypeOf(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeOf{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }


}

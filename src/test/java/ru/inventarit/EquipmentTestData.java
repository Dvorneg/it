package ru.inventarit;

import ru.inventarit.model.*;
import ru.inventarit.to.EquipmentTo;
import ru.inventarit.to.UserTo;
import ru.inventarit.util.UserUtil;
import ru.inventarit.web.MatcherFactory;

import static java.time.LocalDate.of;
import java.time.Month;

import java.time.temporal.ChronoUnit;
import java.util.List;


public class EquipmentTestData {

    public static final MatcherFactory.Matcher<Equipment> EQUIPMENT_MATCHER = MatcherFactory.usingEqualsComparator(Equipment.class);
    public static MatcherFactory.Matcher<EquipmentTo> TO_MATCHER = MatcherFactory.usingEqualsComparator(EquipmentTo.class);

    public static final int START_SEQ = 0;
    public static final int EQUIPMENT_ID = START_SEQ + 2; //id that is not in the database for error generation
    public static final int ADMIN_EQUIPMENT_ID = START_SEQ + 9;


    public static final Company companyUser= new Company("USER Фирма");
    public static final Company companyAdmin= new Company("ООО ЖКХ");

    //public static final Equipment equipment1 = new Equipment(1,"Монитор","company1","description1",  "responsible_person1", of(2021, 1, 11), TypeOf.BUILDINGS);
    //public static final Equipment equipment2 = new Equipment(2,"Принтер","company21","description2",  "responsible_person2", of(2022, Month.FEBRUARY, 2), TypeOf.BUILDINGS);
    public static final Equipment equipment1 = new Equipment(1, "Монитор", "оф-1", "Samsung", "description1", "responsible_person1", of(2021, 1, 03), TypeOf.OFFICE_EQUIPMENT,companyUser);
    public static final Equipment equipment2 = new Equipment(2, "Принтер", "оф-2", "LG", "description2", "responsible_person2", of(2022, Month.FEBRUARY, 2), TypeOf.OTHER,companyUser);
    public static final Equipment equipment3 = new Equipment(9, "Принтер", "оф-3", "LG", "description3", "responsible_person3", of(2022, Month.FEBRUARY, 3), TypeOf.BUILDINGS,companyUser);
    public static final Equipment adminEquipment = new Equipment(ADMIN_EQUIPMENT_ID, "Принтер", "оф-3", "LG", "description3", "responsible_person2", of(2022, Month.FEBRUARY, 2), TypeOf.OTHER,companyAdmin);

    public static final String USER_MAIL = "123";
    public static final String ADMIN_MAIL = "admin@gmail.com";

    public static final User USER_TEST = new User(null,"Тест юзер", USER_MAIL, "123", Role.USER);
    public static final UserTo USER_TEST_TO = UserUtil.asTo(USER_TEST);

    public static final List<Equipment> equipments = List.of(equipment1, equipment2,equipment3);

    public static Equipment getNew() {
        return new Equipment(null, "Монитор", "оф-1", "Samsung", "description1", "Kolya", of(2020, Month.FEBRUARY, 1), TypeOf.BUILDINGS,companyUser);
    }

    public static Equipment getUpdated() {
        return new Equipment(EQUIPMENT_ID,"Монитор","оф-2","Samsung", "admin equipment", "Igor", equipment1.getReleaseDate().plus(2, ChronoUnit.DAYS), TypeOf.OTHER,companyUser);
    }

}




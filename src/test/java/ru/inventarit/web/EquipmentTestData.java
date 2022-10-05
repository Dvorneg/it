package ru.inventarit.web;

import ru.inventarit.model.Equipment;
import ru.inventarit.model.TypeOf;

import static java.time.LocalDate.of;
import java.time.Month;

import java.util.List;


public class EquipmentTestData {

    public static final MatcherFactory.Matcher<Equipment> EQUIPMENT_MATCHER = MatcherFactory.usingEqualsComparator(Equipment.class);

    public static final Equipment equipment1 = new Equipment(1,"Монитор","company1","description1",  "responsible_person1", of(2021, 1, 11), TypeOf.OFFICE_EQUIPMENT);
    public static final Equipment equipment2 = new Equipment(2,"Принтер","company21","description2",  "responsible_person2", of(2022, Month.FEBRUARY, 2), TypeOf.OFFICE_EQUIPMENT);

    public static final List<Equipment> equipments = List.of(equipment1, equipment2);
}
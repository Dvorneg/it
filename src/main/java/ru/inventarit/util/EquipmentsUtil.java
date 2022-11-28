package ru.inventarit.util;

import ru.inventarit.model.Equipment;
import ru.inventarit.model.TypeOf;
import ru.inventarit.to.EquipmentTo;

import java.util.List;
import java.util.stream.Collectors;

public class EquipmentsUtil {

    //two language
    public static TypeOf[] getAllTypeOf() {
        return TypeOf.values();
    }

    public static List<EquipmentTo> getTos(List<Equipment> equipments) {
        return filterByPredicate(equipments);
    }

    public static List<EquipmentTo> filterByPredicate(List<Equipment> equipments) {

        return equipments.stream()
                //.filter(filter)
                .map(EquipmentsUtil::createTo)
                .collect(Collectors.toList());

    }

    public static EquipmentTo createTo(Equipment equipment) {
        return new EquipmentTo(equipment.getId(), equipment.getName(),equipment.getCompany(), equipment.getDescription(), equipment.getResponsiblePerson(), equipment.getReleaseDate(),equipment.getTypeOf(),equipment.getInventoryNumber());
    }

}

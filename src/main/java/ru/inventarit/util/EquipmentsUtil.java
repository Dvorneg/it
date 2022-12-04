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


    public static List<EquipmentTo> getTos(List<Equipment> equipments, String language) {
        return filterByPredicate(equipments,language);
    }

    public static List<EquipmentTo> getTos(List<Equipment> equipments) {
        String language="en";
        return filterByPredicate(equipments, language);
    }

    public static List<EquipmentTo> filterByPredicate(List<Equipment> equipments,String language) {

        return equipments.stream()
                //.filter(filter)
                // .map(EquipmentsUtil::createTo)
                .map(e->EquipmentsUtil.createTo(e,language))
                .collect(Collectors.toList());
    }

    public static EquipmentTo createTo(Equipment equipment,String language) {
        return new EquipmentTo(equipment.getId(), equipment.getName(),equipment.getCompany(), equipment.getDescription(), equipment.getResponsiblePerson(), equipment.getReleaseDate(),equipment.getTypeOf().getTitle(language),equipment.getInventoryNumber());
    }

}

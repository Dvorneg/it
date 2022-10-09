package ru.inventarit.util;

import ru.inventarit.model.TypeOf;

public class EquipmentsUtil {

    //Для выбора типа, передаём в форму все типы
    public static String[] getAllTypeOf()
    {
        String[] s = new String[TypeOf.values().length];
        int i=0;
        for (TypeOf t : TypeOf.values()) {
            s[i++]= t.name();
        }
        return s;
    }

}

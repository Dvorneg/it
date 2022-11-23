package ru.inventarit.model;


import org.springframework.context.i18n.LocaleContextHolder;

import java.io.Serializable;
import java.util.Map;

public enum TypeOf  implements Serializable {

    //BUILDINGS( new HashMap<String,String>("Здания","Buildings","1","1")   );
    BUILDINGS( Map.of("ru","Здания","en","Buildings") ),
    FACILITIES( Map.of("ru","Сооружения","en","Facilities") ),
    MACHINES_AND_EQUIPMENT(Map.of("ru","Машины и оборудование (кроме офисного)","en","Machines and equipment")),
    OFFICE_EQUIPMENT(Map.of("ru","Офисное оборудование","en","Office equipment")),
    VEHICLES(Map.of("ru","Транспортные средства","en","Vehicles")),
    PRODUCTION_AND_MAINTENANCE(Map.of("ru","Производственный и хозяйственный инвентарь","en","Production and maintenance")),
    LAND_LOTS(Map.of("ru","Земельные участки","en","Lands lot")),
    CAPITAL_INVESTMENT(Map.of("ru","Капитальные вложения в арендованное имущество","en","Capital investment")),
    OTHER(Map.of("ru","Другие","en","Other"));

/*   БАЗА FACILITIES("Сооружения",""),
    //Machines and equipment (except for office one)
    MACHINES_AND_EQUIPMENT("Машины и оборудование (кроме офисного)",""),
    OFFICE_EQUIPMENT ("Офисное оборудование",""),
    VEHICLES ("Транспортные средства",""),
    //Production and maintenance tools
    PRODUCTION_AND_MAINTENANCE ("Производственный и хозяйственный инвентарь",""),
    LAND_LOTS ("Земельные участки",""),
    //Capital investment in leased assets
    CAPITAL_INVESTMENT("Капитальные вложения в арендованное имущество",""),
    //Other objects requiring the state registration and classified as real estate according to article 130 of the CC of the RF
    //OTHER_STATE_REGISTRATION_TO_ARTICLE_130("Прочие объекты, требующие государственной регистрации, относимые статьей 130 ГК РФ к недвижимости"),
    OTHER("Другие","");*/

    private Map<String,String> lang;
    //public String name;

    TypeOf(Map lang) {
        this.lang = lang;
        //this.en = en;
    }
/*    TypeOf(String en) {
        this.en = en;
    }*/

  @Override
  public String toString() {return name();}
/*    public String toString() {
        return "TypeOf{" +
                "title='" + title + '\'' +
                '}';
    }*/


    public String getTitle(String language) {
        if (language.equals("ru"))
            return this.lang.get("ru");
        else
            return lang.get("en");
    }

    public String getTitle(){
        if ( LocaleContextHolder.getLocale().getLanguage().equals("ru") )
            return lang.get("ru");
        else
            return lang.get("en");
    }


}

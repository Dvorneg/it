package ru.inventarit.to;


import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.inventarit.model.TypeOf;

import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class EquipmentTo extends NamedTo{

     LocalDate releaseDate;

     String description;

     String company;

     String responsiblePerson;

     String typeOf;

    //Inv. No.
     String inventoryNumber;

    public EquipmentTo(Integer id, String name, String company, String description, String responsiblePerson, LocalDate releaseDate, TypeOf typeOf, String inventoryNumber) {
        super(id, name);
        this.company = company;
        this.description = description;
        this.responsiblePerson = responsiblePerson;
        this.releaseDate = releaseDate;
        this.typeOf = typeOf.getTitle();
        this.inventoryNumber = inventoryNumber;
    }

}

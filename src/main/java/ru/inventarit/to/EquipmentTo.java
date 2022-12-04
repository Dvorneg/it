package ru.inventarit.to;

import lombok.EqualsAndHashCode;
import lombok.Value;
import java.time.LocalDate;
import java.util.Objects;

@Value
@EqualsAndHashCode(callSuper = true)
public class EquipmentTo extends NamedTo {

    LocalDate releaseDate;

    String description;

    String company;

    String responsiblePerson;

    String typeOf;

    //Inv. No.
    String inventoryNumber;

    public EquipmentTo(Integer id, String name, String company, String description, String responsiblePerson, LocalDate releaseDate, String typeOf, String inventoryNumber) {
        super(id, name);
        this.company = company;
        this.description = description;
        this.responsiblePerson = responsiblePerson;
        this.releaseDate = releaseDate;
        this.typeOf = typeOf;
        this.inventoryNumber = inventoryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentTo equipmentTo = (EquipmentTo) o;
        return Objects.equals(typeOf, equipmentTo.typeOf )&&
                //excess == equipmentTo.excess &&
                Objects.equals(id, equipmentTo.id) &&
                Objects.equals(releaseDate, equipmentTo.releaseDate) &&
                Objects.equals(company, equipmentTo.company) &&
                Objects.equals(inventoryNumber, equipmentTo.inventoryNumber) &&
                Objects.equals(responsiblePerson, equipmentTo.responsiblePerson) &&
                Objects.equals(description, equipmentTo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, releaseDate, description, responsiblePerson, company,inventoryNumber,typeOf);
    }

}

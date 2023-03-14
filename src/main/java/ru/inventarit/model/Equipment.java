package ru.inventarit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
@Entity
//@EqualsAndHashCode(callSuper = true)
@Table(name = "equipment")
public class Equipment extends NamedEntity{

    @Column(name = "release_date", nullable = false )
    //if need time refactor, columnDefinition = "timestamp default now()")
    @NotNull
    @JsonFormat( pattern = "yy-MM-dd")
    @DateTimeFormat(pattern = "yy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    //@JsonDeserialize(using = JsonUtil.class)
    private LocalDate releaseDate = LocalDate.now();

    //add location?
    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    //(manufacturer company?)
    @Column(name = "manufacturer", nullable = false)
    @Size(min = 2, max = 70)
    private String manufacturer;

    @Column(name = "responsible_person" )
    private String responsiblePerson;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "type_of" )
    private TypeOf typeOf;

    //Inv. No.
    @Column(name = "inventory_number" )
    private String inventoryNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Company company;

/*    public Equipment(Integer id, String name, String inventoryNumber, String manufacturer, String description,String responsiblePerson,LocalDate releaseDate,TypeOf typeOf) {
        super(id, name);
        this.inventoryNumber = inventoryNumber;
        this.manufacturer = manufacturer;
        this.description = description;
        this.responsiblePerson = responsiblePerson;
        this.releaseDate = releaseDate;
        this.typeOf = typeOf;
    }*/

    public Equipment(Integer id, String name, String inventoryNumber, String manufacturer, String description,String responsiblePerson,LocalDate releaseDate,TypeOf typeOf,Company company) {
        super(id, name);
        this.inventoryNumber = inventoryNumber;
        this.manufacturer = manufacturer;
        this.description = description;
        this.responsiblePerson = responsiblePerson;
        this.releaseDate = releaseDate;
        this.typeOf = typeOf;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                "Inv. No=" + inventoryNumber +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(releaseDate, equipment.releaseDate) && Objects.equals(description, equipment.description) && Objects.equals(manufacturer, equipment.manufacturer) && Objects.equals(responsiblePerson, equipment.responsiblePerson) && typeOf == equipment.typeOf && Objects.equals(inventoryNumber, equipment.inventoryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), releaseDate, description, manufacturer, responsiblePerson, typeOf, inventoryNumber);
    }
}

package ru.inventarit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "equipment")
public class Equipment extends NamedEntity{

/*  Дата принятия?*/
    @Column(name = "release_date", nullable = false )
    //Переопределить, если нужно будет время, columnDefinition = "timestamp default now()")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd")
    @DateTimeFormat(pattern = "yy-MM-dd")
    private LocalDate releaseDate= LocalDate.now();

    //местоположение
    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    //фирма производитель (manufacturer company)
    @Column(name = "company", nullable = false)
    @Size(min = 2, max = 70)
    private String company;

    //МОЛ
    @Column(name = "responsible_person" )
    private String responsiblePerson;

    //Группа ОС ->enum
    @Enumerated(EnumType.STRING)
    @Column(name = "type_of" )
    private TypeOf typeOf;

    //Inv. No.
    @Column(name = "inventory_number" )
    private String inventoryNumber;


    public Equipment(Integer id, String name, String company, String description,String responsiblePerson,LocalDate releaseDate,TypeOf typeOf) {
        super(id, name);
        this.company = company;
        this.description = description;
        this.responsiblePerson = responsiblePerson;
        this.releaseDate = releaseDate;
        this.typeOf = typeOf;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                "Inv. No=" + inventoryNumber +
                ", description='" + description + '\'' +
                '}';
    }
}

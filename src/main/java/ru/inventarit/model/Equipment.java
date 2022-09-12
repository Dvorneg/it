package ru.inventarit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "equipment")
public class Equipment extends BaseEntity{

/*  Дата принятия?*/
    @Column(name = "release_date", nullable = false )
    //Переопределить, если нужно будет время, columnDefinition = "timestamp default now()")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate= LocalDate.now();

    //местоположение
    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    //компания
    @Column(name = "company", nullable = false)
    private String company;

    //МОЛ
    @Column(name = "responsible_person" )
    private String responsiblePerson;

    //Группа ОС ->enum
    @Enumerated(EnumType.STRING)
    @Column(name = "type_of" )
    private TypeOf typeOf;

    public Equipment(Integer id, String company, String description,String responsiblePerson,LocalDate releaseDate,TypeOf typeOf) {
        super(id);
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
                ", description='" + description + '\'' +
                '}';
    }
}

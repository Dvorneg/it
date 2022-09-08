package ru.inventarit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "equipment")
public class Equipment extends BaseEntity{

/*  Дата принятия?
    @NotNull
    @Column(name = "date_time", nullable = false,columnDefinition = "timestamp default now()", updatable = false)
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dateTime= new Date();*/
    @NotNull
    @Column(name = "release_date", nullable = false,columnDefinition = "date default now()")
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

    public Equipment(Integer id, String company, String description,String responsiblePerson,LocalDate releaseDate) {
        super(id);
        this.company = company;
        this.description = description;
        this.responsiblePerson = responsiblePerson;
        this.releaseDate = releaseDate;
    }

/*    //Группа ОС ->enum
    @Column(name = "responsible_person" )
    private String typeOf;*/

}

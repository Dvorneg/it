package ru.inventarit.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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
    @Column(name = "date_receipt", nullable = false,columnDefinition = "timestamp default now()")
    private Date receiptDate= new Date();

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

}

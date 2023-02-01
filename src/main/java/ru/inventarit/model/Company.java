package ru.inventarit.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Company extends NamedEntity{

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @ManyToMany(mappedBy = "companies")
    private List<User> users;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    //@OrderBy("dateTime DESC")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    //@OneToMany(mappedBy = "company")
    private List<Equipment> equipments;

    public Company(String user_фирма) {
    }

    @Override
    public String toString() {
        return "Company{" +
                "description='" + description + '\'' +
                '}';
    }
}

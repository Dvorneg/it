package ru.inventarit.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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

    @Override
    public String toString() {
        return "Company{" +
                "description='" + description + '\'' +
                '}';
    }
}

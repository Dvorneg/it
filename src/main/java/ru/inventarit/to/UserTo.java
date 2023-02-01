package ru.inventarit.to;


import ru.inventarit.HasIdAndEmail;
import ru.inventarit.model.Company;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class UserTo extends BaseTo implements HasIdAndEmail, Serializable {
    //@Serial
    //private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(min = 5, max = 32)
    private String password;

    //@NotBlank
    //@Size(min = 5, max = 32)
    private Integer defaultCompanyId;


    public UserTo() {
    }

    public UserTo(Integer id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserTo(Integer id, String name, String email, String password, Integer defaultCompanyId) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.defaultCompanyId = defaultCompanyId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDefaultCompanyId() {
        return defaultCompanyId;
    }

    public void setDefaultCompanyId(Integer defaultCompanyId) {
        this.defaultCompanyId = defaultCompanyId;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

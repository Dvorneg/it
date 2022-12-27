package ru.inventarit.web;

import lombok.Getter;
import ru.inventarit.model.User;
import ru.inventarit.to.UserTo;
import ru.inventarit.util.UserUtil;

@Getter
public class AuthUser extends org.springframework.security.core.userdetails.User {

   private UserTo userTo;

    public AuthUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        setTo(UserUtil.asTo(user));
    }

    public int getId() {
        return userTo.id();
    }

    public void setTo(UserTo newTo) {
        newTo.setPassword(null);
        userTo = newTo;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    @Override
    public String toString() {
        return userTo.toString();
    }


}

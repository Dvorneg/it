package ru.inventarit;

import ru.inventarit.model.Role;
import ru.inventarit.model.User;
import ru.inventarit.to.UserTo;
import ru.inventarit.util.UserUtil;

import java.io.Serial;


/*@Getter
@ToString(of = "user")*/
public class AuthUser extends org.springframework.security.core.userdetails.User {

    @Serial
    private static final long serialVersionUID = 1L;

   private UserTo userTo;
   //private User user;

    public AuthUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        System.out.println(user); //-
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

/*   public User getUser() {
        return user;
    }*/

 /*   public Object getUserTo() {
        return new User(12,"Тфыв123","123", "123", Role.USER);
    }*/
}

package ru.inventarit.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.inventarit.web.AuthUser;

import static java.util.Objects.requireNonNull;

public class SecurityUtil {

    private SecurityUtil() {
    }

    public static AuthUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthUser) ? (AuthUser) principal : null;
    }

    public static AuthUser get() {
        return requireNonNull(safeGet(), "No authorized user found");
    }

    public static int authUserId() {
        return get().getUserTo().id();
    }



    public static int authUserDefaultCompanyId() {
        return get().getUserTo().getDefaultCompanyId();
    }

/*    public static int authUserCaloriesPerDay() {
        return get().getUserTo().getCaloriesPerDay();
    }*/
}

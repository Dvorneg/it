package ru.inventarit.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.inventarit.model.User;
import ru.inventarit.service.UserService;
import ru.inventarit.to.UserTo;
import ru.inventarit.util.UserUtil;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/profile")
public class ProfileUIController  {


    @Autowired
    private UserService service;

/*    @Autowired
    private UniqueMailValidator emailValidator;*/


    @GetMapping
    public String profile(ModelMap model, @AuthenticationPrincipal AuthUser authUser) {
        model.addAttribute("userTo", authUser.getUserTo());
        return "profile";
    }

    @PostMapping
    //public String updateProfile(@Validated(View.Web.class) UserTo userTo, BindingResult result, SessionStatus status, @AuthenticationPrincipal AuthorizedUser authUser) {
    public String updateProfile(UserTo userTo, BindingResult result, SessionStatus status, @AuthenticationPrincipal AuthUser authUser) {
        if (result.hasErrors()) {
            return "profile";
        }
        update(userTo, authUser.getId());
        authUser.setTo(userTo);
        status.setComplete();
        return "redirect:/meals";
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    //public String saveRegister(@Validated(View.Web.class) UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
    public String saveRegister(UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        }
        create(userTo);
        status.setComplete();
        return "redirect:/login?message=app.registered&username=" + userTo.getEmail();
    }

/*    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(emailValidator);
    }*/

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(UserTo userTo) {
        log.info("create {}", userTo);
        //checkNew(userTo);
        return service.create(UserUtil.createNewFromTo(userTo));
    }

    public User create(User user) {
        log.info("create {}", user);
        //checkNew(user);
        return service.create(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        //assureIdConsistent(user, id);
        service.update(user);
    }

    public void update(UserTo userTo, int id) {
        log.info("update {} with id={}", userTo, id);
        //assureIdConsistent(userTo, id);
        service.update(userTo);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }

/*    public User getWithMeals(int id) {
        log.info("getWithMeals {}", id);
        return service.getWithMeals(id);
    }*/

    public void enable(int id, boolean enabled) {
        log.info(enabled ? "enable {}" : "disable {}", id);
        service.enable(id, enabled);
    }


}


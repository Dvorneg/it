package ru.inventarit.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.inventarit.model.Company;
import ru.inventarit.model.User;
import ru.inventarit.repository.UserRepository;
import ru.inventarit.to.UserTo;
import ru.inventarit.util.UserUtil;
import ru.inventarit.AuthUser;

import java.util.List;
import java.util.Optional;

import static ru.inventarit.util.UserUtil.prepareToSave;


@Service("userService")
@Slf4j
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @CacheEvict(value = "users", allEntries = true)
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return prepareAndSave(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    public void delete(int id) {
        //checkModificationAllowed(id);
        //checkNotFoundWithId(repository.delete(id), id);
        repository.delete(id);
    }

    public List<Company> getUserCompany(int userId) {
        //check?
        User user = repository.getReferenceById(userId);
        return user.getCompanies();
    }

    public User get(int id) {
        //return checkNotFoundWithId(repository.get(id), id);
        return repository.getReferenceById(id);
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return repository.findByEmailIgnoreCase(email).get();
        //return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

/*    //@Override
    protected UserDetailsService userDetailsService() {
        return email -> {
            log.debug("Authenticating '{}'", email);
            Optional<User> optionalUser = repository.findByEmailIgnoreCase(email);
            return new AuthUser(optionalUser.orElseThrow(
                    () -> new UsernameNotFoundException("User '" + email + "' was not found")));
        };

    }*/

    @Override
    public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> users = repository.findByEmailIgnoreCase(username);

        if (users.isEmpty())
            throw new UsernameNotFoundException("User not found");

        //UserTo userTo = (UserUtil.asTo(users.get()));
        log.info("loadUserByUsername" + users.get());
        return new AuthUser(users.get());
    }

    @Cacheable("users")
    public List<User> getAll() {
        return repository.findAll();
    }

    @CacheEvict(value = "users", allEntries = true)
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
//      checkNotFoundWithId : check works only for JDBC, disabled
        //checkModificationAllowed(user.id());
        prepareAndSave(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public void update(UserTo userTo) {
        //checkModificationAllowed(userTo.id());
        User user = get(userTo.id());
        prepareAndSave(UserUtil.updateFromTo(user, userTo));
    }

    private User prepareAndSave(User user) {
        return repository.save(prepareToSave(user, passwordEncoder));
        //return repository.save(user);
    }

/*    protected void checkModificationAllowed(int id) {
        if (modificationRestriction && id < AbstractBaseEntity.START_SEQ + 2) {
            throw new UpdateRestrictionException();
        }
    }*/


/*    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public void enable(int id, boolean enabled) {
        //checkModificationAllowed(id);
        User user = get(id);
        user.setEnabled(enabled);
        repository.save(user);  // !! need only for JDBC implementation
    }

/*    public User getWithMeals(int id) {
        return checkNotFoundWithId(repository.getWithMeals(id), id);
    }*/

/*    protected void checkModificationAllowed(int id) {
        if (modificationRestriction && id < AbstractBaseEntity.START_SEQ + 2) {
            throw new UpdateRestrictionException();
        }
    }*/

}

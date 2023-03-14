package ru.inventarit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inventarit.model.Company;

import ru.inventarit.model.User;
import ru.inventarit.repository.CompanyRepository;
import ru.inventarit.repository.UserRepository;
import ru.inventarit.util.SecurityUtil;

@Service
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }



    public void create(Company company, Integer userId) {
        companyRepository.save(company);
        //Objects.requireNonNull(SecurityUtil.safeGet()).getUserTo().setDefaultCompanyId(company.id());
        User user = userRepository.getReferenceById(userId);
        user.getCompanies().add(company);
        user.setDefaultCompanyId(company.id());
        userRepository.save(user);
    }

    //userService?
    public void setDefaultCompanyId(Integer companyId, Integer userId) {
        SecurityUtil.authUserSetDefaultCompanyId(companyId);

        User user = userRepository.getReferenceById(userId);
        user.setDefaultCompanyId(companyId);
        userRepository.save(user);
    }

}

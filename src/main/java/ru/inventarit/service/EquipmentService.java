package ru.inventarit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inventarit.model.Company;
import ru.inventarit.model.Equipment;
import ru.inventarit.repository.CompanyRepository;
import ru.inventarit.repository.EquipmentRepository;
import ru.inventarit.util.SecurityUtil;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class EquipmentService {
    private final EquipmentRepository repository;
    private final CompanyRepository companyRepository;

    public List<Equipment> getAll() {
        //UserTo userTo = SecurityUtil.get();
        return repository.getAllByCompanyId(SecurityUtil.authUserDefaultCompanyId());
    }

    public Equipment getById(int id)
    {
        //optional return ResponseEntity.of(repository.getReferenceById(id));
        return repository.findById(id).get();
    }

/*    @Transactional
    public Equipment save(Equipment equipment) {
        return repository.save(equipment);
    }*/

    public Equipment create(Equipment equipment) {
        Company company = companyRepository.getReferenceById(SecurityUtil.authUserDefaultCompanyId());
        equipment.setCompany(company);
        return repository.save(equipment);
    }

    public void update(Equipment equipment) {
        //Check null, otherUser
        Company company = companyRepository.getReferenceById(SecurityUtil.authUserDefaultCompanyId());
        equipment.setCompany(company);
        repository.save(equipment);
    }

    public void delete(int id) {
        //Check null, otherUser
        repository.delete(repository.getReferenceById(id));
    }

}

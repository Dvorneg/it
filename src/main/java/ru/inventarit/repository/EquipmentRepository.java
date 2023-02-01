package ru.inventarit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.inventarit.model.Company;
import ru.inventarit.model.Equipment;

import java.util.List;

@Transactional(readOnly = true)
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    List<Equipment> getAllByCompanyId(int companyId);

}

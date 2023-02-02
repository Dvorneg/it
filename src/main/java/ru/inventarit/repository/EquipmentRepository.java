package ru.inventarit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inventarit.model.Equipment;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    List<Equipment> getAllByCompanyId(int companyId);

}

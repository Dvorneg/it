package ru.inventarit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.inventarit.model.Equipment;

@Transactional(readOnly = true)
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
}

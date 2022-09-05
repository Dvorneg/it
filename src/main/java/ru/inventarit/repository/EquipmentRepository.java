package ru.inventarit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inventarit.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
}

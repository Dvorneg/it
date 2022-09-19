package ru.inventarit.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.inventarit.model.Equipment;
import ru.inventarit.repository.EquipmentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipmentService {
    private final EquipmentRepository repository;

    public List<Equipment> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<Equipment> getById(int id)
    {
        return ResponseEntity.of(repository.findById(id));

    }


}

package ru.inventarit.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public Equipment getById(int id)
    {
        //optional return ResponseEntity.of(repository.getReferenceById(id));
        return repository.getReferenceById(id);
    }

/*    @Transactional
    public Equipment save(Equipment equipment) {
        return repository.save(equipment);
    }*/

    public Equipment create(Equipment equipment) {
        return repository.save(equipment);
    }


}

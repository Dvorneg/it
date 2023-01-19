package ru.inventarit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inventarit.model.Equipment;
import ru.inventarit.repository.EquipmentRepository;
import java.util.List;
import java.util.Optional;

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
        return repository.findById(id).get();
    }

/*    @Transactional
    public Equipment save(Equipment equipment) {
        return repository.save(equipment);
    }*/

    public Equipment create(Equipment equipment) {
        return repository.save(equipment);
    }

    public void update(Equipment equipment) {
        //Check null, otherUser
        repository.save(equipment);
    }

    public void delete(int id) {
        //Check null, otherUser
        repository.delete(repository.getReferenceById(id));
    }

}

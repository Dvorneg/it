package ru.inventarit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inventarit.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}

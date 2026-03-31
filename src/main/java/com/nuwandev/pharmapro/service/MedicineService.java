package com.nuwandev.pharmapro.service;

import com.nuwandev.pharmapro.model.Medicine;
import com.nuwandev.pharmapro.repository.MedicineRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MedicineService {
    private final MedicineRepository repository = new MedicineRepository();

    public List<Medicine> search(String query) throws SQLException {
        if (query == null || query.isBlank()) {
            return repository.findAll();
        }
        return repository.search(query);
    }

    public List<Medicine> listAll() throws SQLException {
        return repository.findAll();
    }

    public Optional<Medicine> get(Long id) throws SQLException {
        return repository.findById(id);
    }

    public Medicine add(Medicine medicine) throws SQLException {
        return repository.save(medicine);
    }

    public Medicine update(Medicine medicine) throws SQLException {
        return repository.update(medicine);
    }

    public void delete(Long id) throws SQLException {
        repository.delete(id);
    }
}

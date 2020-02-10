package com.shawnle007.bites.kafkatopostgres.service;

import com.shawnle007.bites.kafkatopostgres.domain.DatabaseEntry;
import com.shawnle007.bites.kafkatopostgres.repository.DatabaseRepository;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    private DatabaseRepository databaseRepository;

    public DatabaseService(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public void receiveAndSave(DatabaseEntry databaseEntry) {
        databaseRepository.save(databaseEntry);
    }

}

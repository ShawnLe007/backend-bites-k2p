package com.shawnle007.bites.kafkatopostgres.service;

import com.shawnle007.bites.kafkatopostgres.domain.DatabaseEntry;
import com.shawnle007.bites.kafkatopostgres.repository.DatabaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class DatabaseServiceTest {

    private DatabaseService subject;

    @Autowired
    private DatabaseRepository databaseRepository;

    private DatabaseEntry databaseEntry;

    @BeforeEach
    void setUp() {
        databaseEntry = DatabaseEntry.builder()
        .bucketPath("s3:aws/bucket")
        .id(2L)
        .name("John Doe")
        .build();

        subject = new DatabaseService(databaseRepository);
    }

    @Test
    void receiveAndSave() {
        subject.receiveAndSave(databaseEntry);

        Iterable<DatabaseEntry> results = databaseRepository.findAll();


    }
}
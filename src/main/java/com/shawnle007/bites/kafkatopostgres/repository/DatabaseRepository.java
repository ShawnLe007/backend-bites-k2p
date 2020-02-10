package com.shawnle007.bites.kafkatopostgres.repository;

import com.shawnle007.bites.kafkatopostgres.domain.DatabaseEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends CrudRepository<DatabaseEntry, Long> {

}

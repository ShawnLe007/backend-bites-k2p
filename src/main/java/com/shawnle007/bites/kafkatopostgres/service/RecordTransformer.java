package com.shawnle007.bites.kafkatopostgres.service;

import com.shawnle007.bites.kafkatopostgres.domain.DatabaseEntry;
import org.apache.avro.generic.GenericRecord;
import org.springframework.stereotype.Service;

@Service
public class RecordTransformer {

    public DatabaseEntry transformToRecord(GenericRecord incomingRecord) {
        return DatabaseEntry.builder()
                .id(Long.parseLong(incomingRecord.get("id").toString()))
                .name(incomingRecord.get("name").toString())
                .bucketPath(incomingRecord.get("bucket").toString())
                .build();
    }

}

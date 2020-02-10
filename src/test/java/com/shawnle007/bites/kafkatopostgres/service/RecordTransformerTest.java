package com.shawnle007.bites.kafkatopostgres.service;

import com.shawnle007.bites.kafkatopostgres.domain.DatabaseEntry;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
class RecordTransformerTest {

    private GenericRecord incomingMessage;

    private RecordTransformer subject;

    @BeforeEach
    void setUp() throws IOException {
        Schema schema = new Schema.Parser().parse(
                new File("/Users/sle.lab/workspace/kafkatopostgres/src/test/resources/schemas/DatabaseEntry.avsc"));
        incomingMessage = new GenericData.Record(schema);

        incomingMessage.put("id", 1L);
        incomingMessage.put("name", "John Doe");
        incomingMessage.put("bucket", "s3:aws/is/an/ok/platform");

        subject = new RecordTransformer();
    }

    @Test
    void transformToRecord_givenIncomingGenericRecord_transformsToEntity() {
        DatabaseEntry databaseEntry = subject.transformToRecord(incomingMessage);

        assertEquals(databaseEntry.getId(), 1L);
        assertEquals(databaseEntry.getName(), "John Doe");
        assertEquals(databaseEntry.getBucketPath(), "s3:aws/is/an/ok/platform");
    }
}
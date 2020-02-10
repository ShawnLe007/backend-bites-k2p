package com.shawnle007.bites.kafkatopostgres.stream;

import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@Slf4j
public class KafkaListener {

    @StreamListener(Sink.INPUT)
    public void handle(GenericRecord incomingRecord) {
        log.debug("Received incoming message id {}", incomingRecord.get("id"));
    }
}

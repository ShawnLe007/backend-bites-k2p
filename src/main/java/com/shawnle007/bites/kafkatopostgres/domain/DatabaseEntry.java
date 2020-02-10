package com.shawnle007.bites.kafkatopostgres.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseEntry {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String bucketPath;

}

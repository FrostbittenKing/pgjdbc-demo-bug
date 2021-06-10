package com.github.frostbittenking.pgjdbcBugDemo.persistence.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class LobTestTable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Lob
    private byte[] testData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getTestData() {
        return testData;
    }

    public void setTestData(byte[] testData) {
        this.testData = testData;
    }
}

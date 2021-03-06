package com.github.frostbittenking.pgjdbcBugDemo.persistence.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LobTestTable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Lob
    private byte[] testData;
}

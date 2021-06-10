package com.github.frostbittenking.pgjdbcBugDemo.persistence.jpa.repository;

import com.github.frostbittenking.pgjdbcBugDemo.persistence.jpa.entity.LobTestTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LobTestRepository extends JpaRepository<LobTestTable,Long> {
}

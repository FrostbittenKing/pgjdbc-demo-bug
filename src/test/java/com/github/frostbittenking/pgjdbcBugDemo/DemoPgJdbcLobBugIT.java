package com.github.frostbittenking.pgjdbcBugDemo;

import com.github.frostbittenking.pgjdbcBugDemo.persistence.jpa.entity.LobTestTable;
import com.github.frostbittenking.pgjdbcBugDemo.persistence.jpa.repository.LobTestRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

public class DemoPgJdbcLobBugIT extends AbstractIntegrationTest {

    @Autowired
    private LobTestRepository repository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    public void testPgjdbcWriteAndReadLobEntity_shouldNotThrowException() throws Exception {
        final LobTestTable lobTestTable = new LobTestTable();
        final byte[] testData = new byte[]{'a', 'b', 'c', 'd', 'e'};
        lobTestTable.setTestData(testData);

        LobTestTable result = transactionTemplate.execute(status -> repository.save(lobTestTable));
        Assertions.assertThat(result.getId()).isNotNull();
        Assertions.assertThatNoException().isThrownBy(() -> repository.findById(result.getId()));

        transactionTemplate.execute(status -> {
            final LobTestTable readBack = repository.getOne(result.getId());
            Assertions.assertThat(readBack.getTestData()).isEqualTo(testData);
            return null;
        });

    }
}

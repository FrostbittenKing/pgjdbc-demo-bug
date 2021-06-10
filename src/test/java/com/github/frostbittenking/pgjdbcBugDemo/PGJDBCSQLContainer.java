package com.github.frostbittenking.pgjdbcBugDemo;

import com.impossibl.postgres.jdbc.PGDriver;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class PGJDBCSQLContainer extends PostgreSQLContainer {

    public PGJDBCSQLContainer(DockerImageName dockerImageName) {
        super(dockerImageName);
    }

    public PGJDBCSQLContainer(String dockerImageName) {
        super(dockerImageName);
    }

    @Override
    public String getDriverClassName() {
        return PGDriver.class.getName();
    }

    @Override
    public String getJdbcUrl() {
        String additionalUrlParams = constructUrlParameters("?", "&");
        return "jdbc:pgsql://" + getContainerIpAddress() + ":" + getMappedPort(POSTGRESQL_PORT)
                + "/" + getDatabaseName() + additionalUrlParams;
    }
}

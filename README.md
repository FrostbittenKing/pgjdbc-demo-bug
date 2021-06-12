# pgjdbc-demo-bug
Demo repo to demonstrate pgjdbc bug <https://github.com/impossibl/pgjdbc-ng/issues/550>

## Bug demonstration

1. Run test: DemoPgjdbcLobBugIT test class
2. mvn clean verify -Pintegration-tests

This will fail with a RuntimeException ("java.lang.RuntimeException: Unable to load base type: loid), and could be fixed by entering following sql statement:
  "create domain loid as oid;"

Verify this by adding the statement listed above into init.sql

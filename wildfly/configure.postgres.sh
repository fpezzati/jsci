echo 'module add --name=org.postgresql --resources=/tmp/postgresql-42.2.0.jar --dependencies=javax.api,javax.transaction.api' | /opt/jboss/wildfly/bin/jboss-cli.sh --connect
echo '/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgresql",driver-class-name="org.postgresql.Driver")' | /opt/jboss/wildfly/bin/jboss-cli.sh --connect
echo 'data-source add --jndi-name=java:jboss/datasources/StenusysDemoDS --name=StenusysDemoDS --connection-url=jdbc:postgresql://localhost:5432/StenusysDemo --driver-name=postgres --user-name=postgres --password=postgres' | /opt/jboss/wildfly/bin/jboss-cli.sh --connect
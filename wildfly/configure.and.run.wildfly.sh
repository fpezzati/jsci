#!/bin/bash
echo "usage: ./configure.and.run.wildfly.sh PG_HOST PG_PORT PG_DATABASE PG_USER PG_PASSWORD"
function wait_for_server() {
  until `/opt/jboss/wildfly/bin/jboss-cli.sh -c ":read-attribute(name=server-state)" 2> /dev/null | grep -q running`; do
    sleep 1
  done
}

/opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 &
echo "booting wildfly"
wait_for_server
echo "wildfly booted"

echo 'module add --name=org.postgresql --resources=/tmp/postgresql-42.2.0.jar --dependencies=javax.api,javax.transaction.api' | /opt/jboss/wildfly/bin/jboss-cli.sh --connect
echo '/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgresql",driver-class-name="org.postgresql.Driver")' | /opt/jboss/wildfly/bin/jboss-cli.sh --connect
echo 'data-source add --jndi-name=java:jboss/datasources/postgres --name=postgres --connection-url=jdbc:postgresql://$1:$2/$3 --driver-name=postgres --user-name=$4 --password=$5' | /opt/jboss/wildfly/bin/jboss-cli.sh --connect

echo "shutting wildfly down"
/opt/jboss/wildfly/bin/jboss-cli.sh -c ":shutdown"
echo "booting widlfly again"
/opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0
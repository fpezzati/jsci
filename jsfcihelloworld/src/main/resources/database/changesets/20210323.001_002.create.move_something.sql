-- liquibase formatted sql
-- changeset francesco.pezzati:20210323:001
CREATE TABLE move_something (id UUID NOT NULL, ends_at TIMESTAMP WITHOUT TIME ZONE, starts_at TIMESTAMP WITHOUT TIME ZONE, CONSTRAINT "move_somethingPK" PRIMARY KEY (id));

-- changeset francesco.pezzati:20210323:002
CREATE TABLE shipment_actor (id UUID NOT NULL, description VARCHAR(255), since TIMESTAMP WITHOUT TIME ZONE, CONSTRAINT "shipment_actorPK" PRIMARY KEY (id));
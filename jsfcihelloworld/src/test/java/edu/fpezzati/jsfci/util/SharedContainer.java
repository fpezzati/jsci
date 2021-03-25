package edu.fpezzati.jsfci.util;

/**
 * Containers are an heavy load in a test and this is an issue. We can mitigate
 * this by having two type of database containers: one type is the 'raised and
 * dropped', the other type is the 'shared'. We may not need to throw away a
 * database after each test, especially if test does not involves transactions
 * and can simply rollback. Testcontainers suggests to use inheritance in order
 * to share a container among tests: here is where I start to investigate.
 *
 * @author francesco.pezzati
 *
 */
public class SharedContainer {

	// TODO
}

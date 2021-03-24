package edu.fpezzati.jsfci;

import java.util.UUID;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fpezzati.jsfci.model.Kind;
import jakarta.inject.Inject;

@EnableWeld
public class KindControllerTest {

	@WeldSetup
	public WeldInitiator weldInitiator = WeldInitiator.of(WeldInitiator.createWeld().enableDiscovery());

	@Inject
	private KindController sut;

	@Test
	public void sutProvidesTheRightEditLink() {
		Kind kind = new Kind();
		String uuid = "85c76711-58a3-40b8-b157-c08654da228e";
		kind.setId(UUID.fromString(uuid));
		Assertions.assertEquals("./edit.xhtml?id=" + uuid, sut.getEditLink(kind));
	}
}

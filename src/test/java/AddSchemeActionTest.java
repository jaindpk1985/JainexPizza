
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.AddSchemeAction;

import process.SchemeOffersProcess;
import dao.OffersInfo;

public class AddSchemeActionTest {
	
	private SchemeOffersProcess schemeOffersProcess;

	private OffersInfo offersInfo;

	private String userFullName;
	
	private AddSchemeAction addSchemeAction;


	@Before
	public void setUp() throws Exception {
		schemeOffersProcess = new SchemeOffersProcess();

		offersInfo = new OffersInfo();

		userFullName = "deepak jain";
		
		addSchemeAction = new AddSchemeAction();

	}
	@Test
	public void testAllSetterGetter() {
		addSchemeAction.setSchemeOffersProcess(schemeOffersProcess);
		addSchemeAction.setOffersInfo(offersInfo);
		addSchemeAction.setUserFullName(userFullName);
		assertNotNull(addSchemeAction.getSchemeOffersProcess());
		assertNotNull(addSchemeAction.getOffersInfo());
		assertNotNull(addSchemeAction.getUserFullName());
	}
	
	@After
	public void tearDown() throws Exception {
		schemeOffersProcess = null;

		offersInfo = null;

		userFullName = null;
	}

}

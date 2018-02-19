package JUnitTests;
import PassengerCheckInApp.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class CheckInSummaryReportTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCheckInSummaryReport() {
		AllBooking b=null;
		AllFlight f=null;
		
		CheckInSummaryReport chSummary=new CheckInSummaryReport(b, f);
	}

}

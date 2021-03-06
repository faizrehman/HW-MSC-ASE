package JUnitTests;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JUnitTestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Result result = JUnitCore.runClasses(AllBookingTest.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      result = JUnitCore.runClasses(AllFlightTest.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      
	      result = JUnitCore.runClasses(CheckInSummaryReportTest.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      
	      System.out.println(result.wasSuccessful());
		
	}

}

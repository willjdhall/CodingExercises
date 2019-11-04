import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunTest {

	public static void main(String[] args) {
		JUnitCore jUnitCore = new JUnitCore();
		Result results = jUnitCore.run(XKCDTests.class);
		
		if(results.getFailureCount() > 0){
			System.out.println("***********************Failure***********************");
			System.out.println("These tests failed while testing the XKCD website:");
			for(Failure f : results.getFailures()){
				System.out.println(f.getDescription().toString());
				System.out.println("	" + f.getMessage().toString());
			}
			System.out.println("*****************************************************");
		}else{
			System.out.println("***********************Success***********************");
			System.out.println("There were no failures while testing the XKCD website");
			System.out.println("*****************************************************");
		}
	}

}

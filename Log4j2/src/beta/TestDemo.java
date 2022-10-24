package beta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestDemo {

	private static Logger log=LogManager.getLogger(TestDemo.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.debug("beta: I am debugging the code.");
		log.error("beta: Object is not present.");
		log.info("beta: Test Case Passed");
		log.fatal("beta: Fatal error found");
		

	}

}

package alpha;

import org.apache.logging.log4j.*;

public class Log4j2Demo {
	
	private static Logger log=LogManager.getLogger(Log4j2Demo.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.debug("alpha: I am debugging the code.");
		log.error("alpha: Object is not present.");
		log.info("alpha: Test Case Passed");
		log.fatal("alpha: Fatal error found");

	}

}

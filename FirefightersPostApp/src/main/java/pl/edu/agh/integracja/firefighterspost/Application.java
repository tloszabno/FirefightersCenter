package pl.edu.agh.integracja.firefighterspost;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Application {

    private static final Logger LOG = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        LOG.info("MAIN FIREFIGHTERS APP");
    }
}

package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public Properties loadProperties() throws IOException {

        String propertyFilePath = "src/main/resources/paramteres.properties";
        //String propertyFilePath = "src/main/java/testBase/ReadProperties.java";
        Properties prop = new Properties();
        prop.load(new FileInputStream(propertyFilePath));
        return prop;

    }

}

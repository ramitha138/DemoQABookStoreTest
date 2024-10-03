package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    // Method to load properties from the specified properties file
    public Properties loadProperties() throws IOException {

        String propertyFilePath = "src/main/resources/paramteres.properties";
        Properties prop = new Properties();
        prop.load(new FileInputStream(propertyFilePath));
        return prop;

    }

}

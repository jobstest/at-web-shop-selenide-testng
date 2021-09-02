package utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Getter
public class TestConfig {
    String siteUrl;

    private static String getPropertyHandler(Properties property, String propertyKey){
        return System.getProperty(propertyKey) != null
                ? System.getProperty(propertyKey)
                : property.getProperty(propertyKey);
    }

    public TestConfig(){
        try (FileInputStream fis = new FileInputStream("src/main/resources/test.properties")){
            Properties property = new Properties();
            property.load(fis);
            siteUrl = getPropertyHandler(property, "siteUrl");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

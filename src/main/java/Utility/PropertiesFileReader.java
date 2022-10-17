package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

        public Properties getProperty(){
            FileInputStream inputstream=null;
            Properties properties= new Properties();
            try {
                properties.load(new FileInputStream("src/main/resources/browser-config.properties"));
            } catch (FileNotFoundException e) {
                  e.printStackTrace();
            } catch (IOException e) {
                   e.printStackTrace();
            }
            return properties;
        }

    }



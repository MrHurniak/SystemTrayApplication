package Application;

import java.io.*;
import java.util.Properties;

public class PropWorker {

    private String fileName = "src\\Prop\\App.properties";
    private Properties properties;

    public String getTrayImage(){
        properties = new Properties();
        try(InputStream stream = new FileInputStream(fileName)){
            properties.load(stream);
            return properties.getProperty("imageTray");
        }catch (IOException e){
            e.printStackTrace();
            return new String();
        }
    }
    public String getExitImage(){
        properties = new Properties();
        try(InputStream stream = new FileInputStream(fileName)){
            properties.load(stream);
            return properties.getProperty("imageExit");
        }catch (IOException e){
            e.printStackTrace();
            return new String();
        }
    }
    public String getSettingsImage(){
        properties = new Properties();
        try(InputStream stream = new FileInputStream(fileName)){
            properties.load(stream);
            return properties.getProperty("imageSettings");
        }catch (IOException e){
            e.printStackTrace();
            return new String();
        }
    }
}

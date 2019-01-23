package ApplicationPack;

import java.io.*;
import java.util.Properties;

public  class PropWorker {

    private String fileName = "src\\Files\\App.properties";
    private Properties properties;

    public String getTrayImage(){
        return getProperti("imageTray");
    }
    public String getExitImage(){
        return getProperti("imageExit");
    }
    public String getSettingsImage(){
        return getProperti("imageSettings");
    }
    public String getCountryISO2(){
        return getProperti("country");
    }
    public String getCity(){
        return getProperti("city");
    }

    public void setCountryISO2(String value){
        if(value.length()>2){
            System.out.println("Wrong country format");
            return;
        }
        setProperti("country",value);
    }

    public void setCity(String value){
        setProperti("city",value);
    }


    public String getProperti(String key){
        properties = new Properties();
        try(InputStream stream = new FileInputStream(fileName)){
            properties.load(stream);
            return properties.getProperty(key);
        }catch (IOException e){
            e.printStackTrace();
            return "";
        } finally {
            properties = null;
        }
    }

    public void setProperti(String key, String value){
        properties = new Properties();
        try(InputStream in = new FileInputStream(fileName)){
            properties.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.setProperty(key,value);
        try(OutputStream out = new FileOutputStream(fileName)){
            properties.store(out,null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

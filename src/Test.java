
import ApplicationPack.FullInfoGUI.InfoWindow;
import ApplicationPack.JsonISO2;
import ApplicationPack.PropWorker;
import ApplicationPack.Settings.SettingWindow;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
//        SwingUtilities.invokeLater( ()-> new SettingWindow());
        JsonISO2 jsonISO2 = new JsonISO2();
        System.out.println(jsonISO2.getCurrentCountry());
//        System.out.println(jsonISO2.getValue("US","alpha-2","name","Ukraine"));
/*
        JsonISO2 jsonISO2 = new JsonISO2();
//        jsonISO2.doSmtgJSON(jsonISO2.loadFile());
        String[] mass = jsonISO2.getAllValues("name",jsonISO2.loadFile());
        for(int i =0;i<mass.length;i++){
            System.out.println(mass[i]);
        }
*/
//        System.out.println(new JsonISO2().loadFile());
//        SwingUtilities.invokeLater(()-> new SettingWindow());
        /*FileInputStream in = new FileInputStream("src\\Files\\App.properties");
        FileOutputStream out = new FileOutputStream("src\\Files\\App.properties");
        Properties props = new Properties();
        props.load(in);



        props.setProperty("country", "amer1");
        props.store(out, null);
        out.close();
        in.close();*/

//        PropWorker prop = new PropWorker();
//        System.out.println(prop.getTrayImage());

        /*SwingUtilities.invokeLater(()->
        new InfoWindow());*/
        /*
        WeatherWorker worker = new WeatherWorker();

        System.out.println(worker.getInfo());
       /* Map<String,Object> result = worker.jsonToMap(worker.getInfo());
        Map<String,Object> mainMap = worker.jsonToMap(result.get("main").toString());
        Map<String,Object> windMap = worker.jsonToMap(result.get("wind").toString());

        System.out.println(mainMap.get("temp"));
        System.out.println(mainMap.get("pressure"));
        System.out.println(windMap.get("speed"));
        System.out.println(windMap.get("deg"));*/

    }
}

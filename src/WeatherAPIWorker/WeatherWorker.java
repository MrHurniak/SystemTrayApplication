package WeatherAPIWorker;

import ApplicationPack.PropWorker;
import com.google.gson.Gson;
import weather.WeatherContainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherWorker {

    private static volatile WeatherWorker instance;

    private PropWorker propWorker = new PropWorker();
    private WeatherContainer weatherContainer = null;
    private WeatherWorker(){
    }
    public static WeatherWorker getInstance(){
        if(instance==null){
            synchronized (WeatherWorker.class){
                if (instance==null){
                    instance=new WeatherWorker();
                }
            }
        }
        return instance;
    }



    public ImageIcon getImage(){
        //todo uncomment when end
        String ima = weatherContainer.getWeather().get(0).getIcon();
        try(InputStream in = new URL("https://openweathermap.org/img/w/"+ima+".png").openStream()){

            return new ImageIcon(ImageIO.read(in));
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new ImageIcon("src\\Icons\\not-found.png");
    }
    public void renew(){
        weatherContainer = container();
    }

    //Явно не дороблено
    //todo заглушка
    public String getInfo(){
//        String   help = "{\"coord\":{\"lon\":30.52,\"lat\":50.43},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":" +
//                "\"light snow\",\"icon\":\"13n\"}],\"base\":\"stations\",\"main\":{\"temp\":269.15,\"pressure\":1013," +
//                "\"humidity\":79,\"temp_min\":269.15,\"temp_max\":269.15},\"visibility\":10000,\"wind\":{\"speed\":8," +
//                "\"deg\":320,\"gust\":13},\"clouds\":{\"all\":90},\"dt\":1545766200,\"sys\":{\"type\":1,\"id\":8903," +
//                "\"message\":0.0596,\"country\":\"UA\"," +
//                "\"sunrise\":1545717463,\"sunset\":1545746341},\"id\":703448,\"name\":\"Kiev\",\"cod\":200}";
        String API_KEY = "39efa5943b045418b826924c44f513ae";
        String location = propWorker.getCity()+","+propWorker.getCountryISO2();
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+location+
                "&appid="+API_KEY;
        try{
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line=rd.readLine())!=null){
                result.append(line);
            }
            System.out.println(result);
            return result.toString();


        }catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }catch (IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Wrong value of city or country.");
            return "";
        }
    }

    private WeatherContainer container() {
        return new Gson().fromJson(getInfo(), WeatherContainer.class);
    }
    public WeatherContainer getWeatherContainer(){
        return weatherContainer;
    }
    public String getWeather(){
        return weatherContainer.shortFoCast();
    }
    public String getFullWeather() {return weatherContainer.getFullFoCast();}
    public String getCity(){
        return weatherContainer.getCountryCity();
    }
    public String getFullCity(){return weatherContainer.getName()+", "+weatherContainer.getSys().getCountry();}




}

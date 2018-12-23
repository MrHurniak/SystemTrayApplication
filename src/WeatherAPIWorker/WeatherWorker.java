package WeatherAPIWorker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherWorker {
    public void getImage(String urlString){
        //Погане рішення. Мені не подобається такий хід
        String ulrString;
        Image image;
        if(urlString.equals("")) {
            ulrString = "https://openweathermap.org/img/w/10n.png";
        }else
            ulrString = urlString;
        try(InputStream in = new URL(ulrString).openStream()){
            image = ImageIO.read(in);
            //todo зробити можливість переглянути картинку в GUI
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Явно не дороблено
    public String getInfo(){
        String API_KEY = "39efa5943b045418b826924c44f513ae";
        String location = "Kiev,UA";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+location+
                "&mode=xml&appid="+API_KEY;
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
            return new String("");
        }
        catch (IOException e){
            e.printStackTrace();
            return new String("");
        }
    }
    public String getWeather(){
        return "Go OUT and look YOURSELF,\n stupid man!";
    }
    /*try(InputStream in = new URL("https://openweathermap.org/img/w/10n.png").openStream()){
            Files.copy(in, Paths.get("D://image.jpg"));
        } catch (Exception e){
            e.printStackTrace();
        }*/
        /*String API_KEY = "39efa5943b045418b826924c44f513ae";
        String location = "Kiev,UA";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+location+
                "&mode=xml&appid="+API_KEY;
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


        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }*/
}

import Application.PropWorker;
import WeatherAPIWorker.WeatherWorker;
import weather.WeatherContainer;

import java.util.Map;

public class Test {
    public static void main(String[] args){
        WeatherWorker worker = new WeatherWorker();
        worker.getInfo();
        WeatherContainer container = worker.container();
        System.out.println(container.toString());
       /* Map<String,Object> result = worker.jsonToMap(worker.getInfo());
        Map<String,Object> mainMap = worker.jsonToMap(result.get("main").toString());
        Map<String,Object> windMap = worker.jsonToMap(result.get("wind").toString());

        System.out.println(mainMap.get("temp"));
        System.out.println(mainMap.get("pressure"));
        System.out.println(windMap.get("speed"));
        System.out.println(windMap.get("deg"));*/

    }
}

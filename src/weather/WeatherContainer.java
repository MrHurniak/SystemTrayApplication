package weather;

import java.util.List;

public class WeatherContainer {
    private Coordination coord;
    private List<Weather> weather;
    private String base;        //station
    private MainInfo main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private long id;
    private String name;

    public Coordination getCoord() {
        return coord;
    }

    public void setCoord(Coordination coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainInfo getMain() {
        return main;
    }

    public void setMain(MainInfo main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    private int cod;
    public String shortFoCast(){
        return weather.get(0).description+" "+Math.floor(main.temp-273.15);
    }
    //todo String is bed for memory. Use Builder
    public String getFullFoCast(){
        String res = "";
        for(Weather elem :weather){
            res+=elem.description+"\n";
        }
        res += "Pressure : " + main.pressure + "\n";
        res += "Humidity : " + main.humidity + "\n";
        res += "Visibility : " + visibility + "\n";
        res += "Wind: speed = " + wind.speed + ", deg = " + wind.deg + "\n";
        res += "Clouds " + clouds.all + "\n";
        res += "Sunrise " + sys.sunrise + "\n";
        res += "Sunset " + sys.sunset ;

        return res;
    }
    public String getCountryCity(){
        return sys.country+" "+name;
    }
    @Override
    public String toString() {
        return "WeatherContainer{" +
                "base='" + base + '\'' +
                ", visibility=" + visibility +
                ", dt=" + dt +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}

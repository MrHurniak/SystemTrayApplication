package weather;

public class Sys {
    int type;
    int id;
    double message;
    String country;

    public String getCountry() {
        return country;
    }

    long sunrise;
    long sunset;
}
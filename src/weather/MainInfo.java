package weather;

public class MainInfo {
    double temp;
    int pressure;
    int humidity;
    double temp_min;
    double temp_max;

    @Override
    public String toString() {
        return "MainInfo{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                '}';
    }
}

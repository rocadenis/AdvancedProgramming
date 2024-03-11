package Lab3;
import java.util.ArrayList;
import java.util.List;

class Trip {
    private String cityName;
    private String timePeriod;
    private List<Visitable> attractions;

    public Trip(String cityName, String timePeriod) {
        this.cityName = cityName;
        this.timePeriod = timePeriod;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Visitable attraction) {
        attractions.add(attraction);
    }
    public List<Visitable> getAttractions() {
        return attractions;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    // Nu este nevoie de getter și setter pentru lista de atracții


    @Override
    public String toString() {
        return "Trip{" +
                "cityName='" + cityName + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                ", attractions=" + attractions +
                '}';
    }
}

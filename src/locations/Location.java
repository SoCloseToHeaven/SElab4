package locations;

import enums.Weather;
import interfaces.Describable;

import java.util.Arrays;
import java.util.Objects;

public class Location implements Describable {
    private double longtitude;
    private double width;

    private Weather weather;


    private final String description;

    public Location(String description, Weather weather, double longtitude, double width) {
        this.longtitude = longtitude;
        this.width = width;
        this.description = description;
        this.weather = weather;
    }


    public String getWeather() {
        return "В локации " + this.describe() + " " + weather.describe();
    }
    public Location setWeather(Weather newWeather) {
        this.weather = newWeather;
        System.out.println(this.getWeather());
        return this;
    }
    @Override
    public String describe() { return description; }
    public double[] getCoordinates() {
        return new double[]{this.longtitude, this.width};
    }

    @Override
    public boolean equals(Object location) {
        if (location == null) return false;
        if (this.getClass() != location.getClass()) return false;
        if (this.describe().intern() != ((Location) location).describe().intern()) return false;
        return true;
    }

    @Override
    public String toString() {
        return description + ", расположенный по координатам: " + Arrays.toString(this.getCoordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(longtitude, width, description);
    }
}

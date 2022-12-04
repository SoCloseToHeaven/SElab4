package utils;

import characters.Person;
import exceptions.*;
import locations.Location;
import planes.Plane;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.regex.Pattern;

public final class Validation {
    public static final String UNDEFINED_NAME = "Неопределено";

    public static final int UNDEFINED_AGE = 0;

    private Validation() {}
    public static class CorrectName {
        private CorrectName(){}
        public static String validate(String name) throws InvalidNameException {
            if (isValidName(name) && CachedNames.isNotCached(name)) {
                CachedNames.cacheName(name);
                return name;
            } else {
                throw new InvalidNameException();
            }
        }
        private static boolean isValidName(String name) {
            return Pattern.matches("^[А-Я][а-я]*$", name);
        }
    }

    public static class CorrectAge {
        private CorrectAge(){}

        public static int validate(int age) throws InvalidAgeException{
            if (0<= age && age <=99)
                return age;
            else
                throw new InvalidAgeException();
        }
    }

    public static class CorrectFlightConditions {
        private CorrectFlightConditions() {}

        public static void validate(Plane plane, Location flightDestination) throws InvalidFlightConditionsException{ // рефлексия по приколу
            Field privatePassengers;
            Field privateInFlight;
            Field privateLocation;
            Class planeClass = plane.getClass();
            HashSet<Person> passengers = null;
            boolean inFlight = false;
            Location location = null;
            try {
                privatePassengers = planeClass.getDeclaredField("passengers");
                privateInFlight = planeClass.getDeclaredField("inFlight");
                privateLocation = planeClass.getDeclaredField("location");
                privatePassengers.setAccessible(true);
                privateInFlight.setAccessible(true);
                privateLocation.setAccessible(true);
                passengers = (HashSet<Person>) privatePassengers.get(plane);
                inFlight = (boolean) privateInFlight.get(plane);
                location = (Location) privateLocation.get(plane);
                if ((passengers.size() == 0) || (location.equals(flightDestination)) || inFlight)
                    throw new InvalidFlightConditionsException();
            }
            catch (NoSuchFieldException exception) {}
            catch (IllegalAccessException exception) {}
            catch (NullPointerException exception) {}
        }
    }

    @Override
    public boolean equals(Object obj) { // не имеет смысла, тк создать объект класса невозможно
        if (obj == null)
            return false;
        if (this.getClass() == obj.getClass())
            return true;
        return false;
    }

    @Override
    public int hashCode() { // у объекта класса нет полей
        return 31;
    }

    @Override
    public String toString() { // тоже смысла не имеет
        return "";
    }
}

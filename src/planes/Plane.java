package planes;

import characters.Person;
import enums.Action;
import exceptions.InvalidFlightConditionsException;
import interfaces.Describable;
import interfaces.Movable;
import locations.Location;
import utils.Validation;

import java.util.HashSet;
import java.util.Objects;

abstract public class Plane implements Describable, Movable {
    private Location location;
    private Location flightDestination;
    private boolean inFlight = false;

    private Baggage baggage;
    private HashSet<Person> passengers = new HashSet<Person>();
    public Plane(Location startLocation) {
        this.location = startLocation;
    }

    public Plane addPassenger(Person passenger) {
        if (passenger.getLocation().equals(this.location)) {
            passengers.add(passenger);
            System.out.println(passenger.getName() + " сел в самолёт");
        } else {
            System.out.println(passenger.getName() + " и самолёт находятся в разных локациях!");
        }
        return this;
    }

    public Plane fly(Location newLocation) {
        try {
            Validation.CorrectFlightConditions.validate(this, newLocation);
        } catch (InvalidFlightConditionsException exception) {
            System.out.println(exception.getMessage());
            return this;
        }
        this.inFlight = true;
        this.flightDestination = newLocation;
        passengers.forEach(person -> person.setAction(Action.FLYING_IN_PLANE));
        return this;
    }

    public Plane clearPassengers() {
        if (!inFlight) {
            for (Person iter : passengers) {
                System.out.println(iter.getName() + " высадился из самолёта");
                iter.setAction(Action.DOING_NOTHING).setLocation(this.location);
            }
            passengers = new HashSet<Person>();
        } else {
            System.out.println("Нельзя высадить пассажиров в полёте!");
        }
        return this;
    }

    public Plane land() {
        if (!inFlight) {
            System.out.println("Самолёт не находится в полёте");
            return this;
        }
        inFlight = false;
        return this.setLocation(this.flightDestination).clearPassengers();
    }

    public class Baggage implements Describable{

        private String description;

        public Baggage(String description) {
            this.description = description;
            System.out.println("Загрузили в самолёт следущий багаж: " + this.describe());
            baggage = this;
        }
        @Override
        public String describe() {
            return this.description;
        }
    }

    public String getBaggage() {
        try {
            return this.describe() + " имеет багаж: " + baggage.describe();
        } catch (NullPointerException exception) {
            return this.describe() + " не имеет багажа";
        }
    }

    @Override
    public Location getLocation() {return this.location;}

    @Override
    public Plane setLocation(Location newLocation) {
        this.location = newLocation;
        return this;
    }

    @Override
    public String toString() {
        return inFlight + location.toString() + passengers.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, flightDestination, inFlight, passengers);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        if (this.describe().intern() != ((Plane) obj).describe().intern()) return false;
        if (this.getLocation().equals(((Plane) obj).getLocation())) return false;
        return true;
    }
}

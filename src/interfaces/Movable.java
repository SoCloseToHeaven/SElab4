package interfaces;

import locations.Location;

public interface Movable {
    Movable setLocation(Location location);
    Location getLocation();
}

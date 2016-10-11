
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CS1635 Deliverable 2
 *
 * @author Nick Taglianetti
 */
public class Simulator {

    public Driver[] Drivers;

    private final Random random;


    public Simulator(int seed) {
        if ((seed < 0)) {
            try {
                throw new Exception("seed much be positive");
            } catch (Exception ex) {
                
            }
        }

        //  set seed to randomize route decisions
        this.random = new Random(seed);
        //  initialize drivers
        this.Drivers = new Driver[5];
        for (int index = 0; (index < this.Drivers.length); index++) {
            this.Drivers[index] = new Driver((index + 1), this.GetRandomLocationInCity());
        }

    }

    //  simulates all drivers moving through city
    public void RunSimulation() {
        //  loop through and move drivers through simulation
        for (int index = 0; (index < this.Drivers.length); index++) {
            int id = (index + 1);
            int counter = 0;
            while (this.Drivers[index].IsInsideCity()) {
                try {
                    this.SimulateMove(id);
                } catch (Exception ex) {
                    Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
                }
                counter++;
            }

            System.out.printf("Driver %d got %d cup(s) of coffee\n-----\n", id, this.Drivers[index].CupsCoffee);
        }

    }

    //  simululate a driver moving his location
    public void SimulateMove(int driverId) throws Exception {
        if (((driverId < 1) || (driverId > 5))) {
            throw new Exception("invalid driver id -- must be between 1 and 5");
        }

        int index = (driverId - 1);
        Driver.Location currentLocation = this.Drivers[index].CurrentLocation;
        Driver.Location newLocation = this.GetRandomLocationElsewhere(currentLocation);
        this.Drivers[index].UpdateLocation(newLocation);
        //  display source, route and distination of the driver
        System.out.printf("Driver %d heading from %s to %s via %s\n", driverId, currentLocation, newLocation, this.GetStreetTraveled(currentLocation, newLocation));
        if ((newLocation == Driver.Location.OutsideCity)) {
            Driver.City newCity = null;
            // if went to OutsideCity past Diner
            if ((currentLocation == Driver.Location.Diner)) {
                newCity = Driver.City.Philadelphia;
            }

            // if went to OutsideCity past Library
            if ((currentLocation == Driver.Location.Library)) {
                newCity = Driver.City.Cleveland;
            }

            this.Drivers[index].UpdateCity(newCity);
            System.out.printf("Driver %d has gone to %s!\n", driverId, newCity);
        }

    }

    //  checks if new location is valid
    public boolean IsLocationValid(Driver.Location currentLocation, Driver.Location newLocation) throws Exception {
        if ((currentLocation == Driver.Location.Hotel)) {
            return ((newLocation == Driver.Location.Diner) || (newLocation == Driver.Location.Library));
        }

        if ((currentLocation == Driver.Location.Diner)) {
            return ((newLocation == Driver.Location.OutsideCity) || (newLocation == Driver.Location.Coffee));
        }

        if ((currentLocation == Driver.Location.Library)) {
            return ((newLocation == Driver.Location.OutsideCity) || (newLocation == Driver.Location.Hotel));
        }

        if ((currentLocation == Driver.Location.Coffee)) {
            return ((newLocation == Driver.Location.Library) || (newLocation == Driver.Location.Diner));
        }

        if ((currentLocation == Driver.Location.OutsideCity)) {
            return false;
        }

        throw new Exception(String.format("currentLocation %s not supported", currentLocation));
    }

    //  get a random location that's not the current location
    public Driver.Location GetRandomLocationElsewhere(Driver.Location currentLocation) throws Exception {
        if ((currentLocation == Driver.Location.OutsideCity)) {
            throw new Exception("current location OutsideCity not supported");
        }

        while (true) {
            Driver.Location newLocation = this.GetRandomLocation();
            if (this.IsLocationValid(currentLocation, newLocation)) {
                return newLocation;
            }

        }

    }

    //  get a random location in the city
    public Driver.Location GetRandomLocationInCity() {
        while (true) {
            Driver.Location location = this.GetRandomLocation();
            if ((location != Driver.Location.OutsideCity)) {
                return location;
            }

        }

    }

    //  get a random location
    private Driver.Location GetRandomLocation() {
        int rndLoc = random.nextInt(Driver.Location.values().length);
        return Driver.Location.values()[rndLoc];
    }

    //  returns name of street traveled between current and new locations
    private  String GetStreetTraveled(Driver.Location currentLocation, Driver.Location newLocation) throws Exception {
        if (((currentLocation == Driver.Location.Hotel) && (newLocation == Driver.Location.Diner))) {
            return "Fourth Ave.";
        }

        if (((currentLocation == Driver.Location.Hotel) && (newLocation == Driver.Location.Library))) {
            return "Bill St.";
        }

        if (((currentLocation == Driver.Location.Diner) && (newLocation == Driver.Location.Coffee))) {
            return "Phil St.";
        }

        if (((currentLocation == Driver.Location.Diner) && (newLocation == Driver.Location.OutsideCity))) {
            return "Fourth Ave.";
        }

        if (((currentLocation == Driver.Location.Library) && (newLocation == Driver.Location.Hotel))) {
            return "Bill St.";
        }

        if (((currentLocation == Driver.Location.Library) && (newLocation == Driver.Location.OutsideCity))) {
            return "Fifth Ave.";
        }

        if (((currentLocation == Driver.Location.Coffee) && (newLocation == Driver.Location.Diner))) {
            return "Phil St.";
        }

        if (((currentLocation == Driver.Location.Coffee) && (newLocation == Driver.Location.Library))) {
            return "Fifth Ave.";
        }

        throw new Exception("invalid location change");
    }
}


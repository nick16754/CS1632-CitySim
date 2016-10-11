/**
 * CS1635 Deliverable 2
 *
 * @author Nick Taglianetti
 */

public class Driver {

    //  Enum to identify all valid locations
    //  Enum is 0-based so that random logic works
    //  Length of this enum is 5

    public enum Location 
    {
        Hotel,
        Diner,
        Library,
        Coffee,
        OutsideCity;
    }

    //  Enum to identify all external cities
    public enum City {

        Cleveland,
        Philadelphia,
    }
    
    public int Id;
    public int CupsCoffee;
    public Location CurrentLocation;
    public City CurrentCity;

    //  no default constructor
    private Driver() {

    }

    //  constructor must include ID and location
    public Driver(int id, Location location) {
        this.Id = id;
        this.CurrentLocation = location;
        this.CupsCoffee = 0;
        this.CurrentCity = null;
    }

    public int getID() {
        return this.Id;
    }

    public int getCupsCoffee() {
        return this.CupsCoffee;
    }

    public Location getCurrentLocation() {
        return this.CurrentLocation;
    }

    public City getCurrentCity() {
        return this.CurrentCity;
    }
    
    //  method for drinking coffee
    public final void DrinkCoffee() {
        this.CupsCoffee++;
    }

    //  returns true if current location is not OutsideCity
    public final boolean IsInsideCity() {
        return (this.CurrentLocation != Location.OutsideCity);
    }

    //  updates location, checking to make sure that it has changed
    public final void UpdateLocation(Location newLocation) throws Exception {
        if ((newLocation == this.CurrentLocation)) {
            throw new Exception("newLocation must be different from current location");
        }

        this.CurrentLocation = newLocation;
        //  Make sure we have a cup of coffee
        if ((newLocation == Location.Coffee)) {
            this.DrinkCoffee();
        }

    }

    //  update city if location is outside city
    public final void UpdateCity(City newCity) throws Exception {
        if ((this.CurrentLocation != Location.OutsideCity)) {
            throw new Exception("location must be OutsideCity to update city");
        }

        this.CurrentCity = newCity;
    }

}


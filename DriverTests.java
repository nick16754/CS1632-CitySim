
/**
 * CS1635 Deliverable 2
 *
 * @author Nick Taglianetti
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class DriverTests {

    // A valid Driver should be created based on its driverId and locationId.
    // Instantiate new Driver and set its attributes.
    // Driver's attributes' values should be equal to those of the variables.
    @Test()
    public void DriverIsValidAfterConstruction() {
        int driverId = 1;
        Driver.Location location = Driver.Location.Diner;
        int cupsCoffee = 0;
        Driver driver = new Driver(driverId, location);
        assertEquals(driverId, driver.Id);
        assertEquals(location, driver.CurrentLocation);
        assertEquals(cupsCoffee, driver.CupsCoffee);
    }
    
    // getCurrentLocation should return a valid Driver's location attribute.
    // Instantiate new Driver and set its attributes, including location.
    // getCurrentLocation should return the same location with which the driver was instantiated.
    @Test()
    public void GetCurrentLocationReturnsCurrentLocation() {
        int driverId = 1;
        Driver.Location location = Driver.Location.Diner;
        Driver driver = new Driver(driverId, location);
        assertEquals(driver.getCurrentLocation(), driver.CurrentLocation);
    }


    // DrinkCoffee should increase the CupsCoffee of the Driver.
    // Instantiate new Driver with location Coffee and call DrinkCoffee twice.
    // CupsCoffee of Driver should increase by one each time DrinkCoffee is called.
    @Test()
    public void DriverCupsCoffeeIncrementsOnDrink() {
        //  Assign
        int driverId = 1;
        Driver.Location location = Driver.Location.Coffee;
        Driver driver = new Driver(driverId, location);
        driver.DrinkCoffee();
        assertEquals(1, driver.CupsCoffee);
        //  Action
        driver.DrinkCoffee();
        //  Assert
        assertEquals(2, driver.CupsCoffee);
    }

    // UpdateLocation should change the location of the Driver.
    // Instantiate new Driver with intial location and update to new location.
    // Driver's location should change to newLocation.
    @Test()
    public void DriverLocationCanBeChanged() {
        //  assign
        int driverId = 1;
        Driver.Location initialLocation = Driver.Location.Hotel;
        Driver.Location newLocation = Driver.Location.Diner;
        Driver driver = new Driver(driverId, initialLocation);
        //  action
        driver.UpdateLocation(newLocation);
    }

    // UpdateLocation should change the location of the driver to a different location.
    // Instantiate new Driver with intial location and update to same initial location.
    // Not updating to a different location should throw exception.
    @Test(expected = IllegalArgumentException.class)
    public void DriverLocationChangeMustBeDifferent() {
        //  assign
        int driverId = 1;
        Driver.Location initialLocation = Driver.Location.Hotel;
        Driver driver = new Driver(driverId, initialLocation);
        //  action
        driver.UpdateLocation(initialLocation);
    }

    // UpdateLocation to Coffee should result in incrementation of CupsCoffee
    // Instantiate new Driver with intial location and update to Coffee.
    // Driver's CupsCoffee should update to 1.
    @Test()
    public void DrinkCoffeeIfLocationUpdatedToCoffee() {
        //  assign
        int driverId = 1;
        Driver.Location initialLocation = Driver.Location.Diner;
        Driver.Location newLocation = Driver.Location.Coffee;
        Driver driver = new Driver(driverId, initialLocation);
        //  action
        driver.UpdateLocation(newLocation);
        //  assert
        assertEquals(1, driver.CupsCoffee);
    }

    // IsInsideCity should only return true if Driver's location is not OutsideCity.
    // Instantiate a new Driver and set its location to OutsideCity.
    // Call of IsInsideCity should return false. 
    @Test()
    public void IsNotInsideTheCityWhenLocationIsOutsideCity() {
        //  assign
        int driverId = 1;
        Driver.Location initialLocation = Driver.Location.OutsideCity;
        Driver driver = new Driver(driverId, initialLocation);
        //  assert
        assertFalse(driver.IsInsideCity());
    }

    // IsInsideCity should return true if Driver's location is any location but OutsideCity.
    // Instantiate a new Driver and set its location to Hotel.
    // Call of IsInsideCity should return true. 
    @Test()
    public void IsInsideCityWhenLocationIsHotel() {
        //  assign
        int driverId = 1;
        Driver.Location initialLocation = Driver.Location.Hotel;
        Driver driver = new Driver(driverId, initialLocation);
        //  assert
        assertTrue(driver.IsInsideCity());
    }

    // IsInsideCity should return true if Driver's location is any location but OutsideCity.
    // Instantiate a new Driver and set its location to Library.
    // Call of IsInsideCity should return true. 
    @Test()
    public void IsInsideCityWhenLocationIsLibrary() {
        //  assign
        int driverId = 1;
        Driver.Location initialLocation = Driver.Location.Library;
        Driver driver = new Driver(driverId, initialLocation);
        //  assert
        assertTrue(driver.IsInsideCity());
    }

    // IsInsideCity should return true if Driver's location is any location but OutsideCity.
    // Instantiate a new Driver and set its location to Coffee.
    // Call of IsInsideCity should return true. 
    @Test()
    public void IsInsideCityWhenLocationIsCoffee() {
        //  assign
        int driverId = 1;
        Driver.Location initialLocation = Driver.Location.Coffee;
        Driver driver = new Driver(driverId, initialLocation);
        //  assert
        assertTrue(driver.IsInsideCity());
    }

    // IsInsideCity should return true if Driver's location is any location but OutsideCity.
    // Instantiate a new Driver and set its location to Diner.
    // Call of IsInsideCity should return true. 
    @Test()
    public void IsInsideCityWhenLocationIsDiner() {
        //  assign
        int driverId = 1;
        Driver.Location initialLocation = Driver.Location.Diner;
        Driver driver = new Driver(driverId, initialLocation);
        //  assert
        assertTrue(driver.IsInsideCity());
    }

    // UpdateCity should be able to update a Driver's city iff location is OutsideCity.
    // Instantiate a new Driver and set its location to OutsideCity.
    // Call UpdateCity on the Driver to change its city to Cleveland.
    // Driver's CurrentLocation should be OutsideCity.
    // Driver's CurrentCity should be Cleveland. 
    @Test()
    public void CanUpdateCityWhenLocationIsOutsideCity() {
        //  assign
        int driverId = 1;
        Driver.Location location = Driver.Location.OutsideCity;
        Driver.City newCity = Driver.City.Cleveland;
        Driver driver = new Driver(driverId, location);
        //  action
        driver.UpdateCity(newCity);
        assertEquals(location, driver.CurrentLocation);
        assertEquals(newCity, driver.CurrentCity);
    }

    // UpdateCity should be able to update a Driver's city iff location is OutsideCity.
    // Instantiate a new Driver and set its location to Coffee.
    // Call UpdateCity on the Driver to change its city to Cleveland.
    // Driver's CurrentLocation is not OutsideCity so arguement should be thrown.
    @Test(expected = IllegalArgumentException.class)
    public void CanNotUpdateCityWhenLocationIsInsideCity() {
        //  assign
        int driverId = 1;
        Driver.Location location = Driver.Location.Coffee;
        Driver.City newCity = Driver.City.Cleveland;
        Driver driver = new Driver(driverId, location);
        //  action
        driver.UpdateCity(newCity);
    }
}

/**
 * CS1635 Deliverable 2
 *
 * @author Nick Taglianetti
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class SimulatorTests {
        // Simulator should create five Drivers when instanciated.
        // Create new instance of Simulator with some seed.
        // Instance of Simulator should have a Drivers array of length 5.
        @Test()
        public final void SimulatorCreatesFiveDrivers() {
            // Assign
            Simulator simulator = new Simulator(3);
            // Assert
            assertTrue((simulator.Drivers.length == 5));
        }
        
        // A Driver's ID in the simulator should be its index (+1) in the Drivers array.
        // Create new instance of Simulator with some seed.
        // Each Driver in Drivers should have the correct ID cooresponding to its index.
        @Test()
        public final void SimulatorDriverIdIsArrayIndex() {
            // Assign
            Simulator simulator = new Simulator(3);
            // Assert
            assertEquals(1, simulator.Drivers[0].Id);
            assertEquals(2, simulator.Drivers[1].Id);
            assertEquals(3, simulator.Drivers[2].Id);
            assertEquals(4, simulator.Drivers[3].Id);
            assertEquals(5, simulator.Drivers[4].Id);
        }
        
        // Simulator must have a positive seed.
        // Create instance of Simulator with negative seed.
        // Instaciating Simulator with negative seed should throw exception.
        @Test(expected = IllegalArgumentException.class)
        public final void SimulatorMustHavePositiveSeed() {
            Simulator simulator = new Simulator(-5);
        }
        
        // Simulator can move a Driver that has been created.
        // Create instance of Simulator with some seed. Call SimulateMove on Driver 4.
        // Simulating a move of a DriverId <= 5 should result in the movement of that Driver.
        @Test()
        public final void SimulateMoveValidDriveId() {
            //  assign
            Simulator simulator = new Simulator(5);
            //  action
            simulator.SimulateMove(4);
        }
        
        // Simulator cannot move a Driver that doesn't exit.
        // Create instance of Simulator. Call SimulateMove on Driver 6.
        // Simulating a move of a DriverId > 5 should throw exception.
        @Test(expected = IllegalArgumentException.class)
        public final void SimulateMoveMustTakeValidDriverId() {
            //  assign
            Simulator simulator = new Simulator(5);
            //  action
            simulator.SimulateMove(6);
        }
        
        // GetRandomLocation cannot generate a location equal to its locationToExclude parameter.
        // Create instance of Simulator and call GetRandomLocationElsewhere on each possible Location.
        // Parameter should be excluded from random locations generated. 
        @Test()
        public final void GetRandomLocationElsewhereReturnsDifferentLocation() {
            Simulator simulator = new Simulator(5);
            Driver.Location location1 = simulator.GetRandomLocationElsewhere(Driver.Location.Coffee);
            assertNotEquals(location1, Driver.Location.Coffee);
            Driver.Location location2 = simulator.GetRandomLocationElsewhere(Driver.Location.Diner);
            assertNotEquals(location2, Driver.Location.Diner);
            Driver.Location location3 = simulator.GetRandomLocationElsewhere(Driver.Location.Hotel);
            assertNotEquals(location3, Driver.Location.Hotel);
            Driver.Location location4 = simulator.GetRandomLocationElsewhere(Driver.Location.Library);
            assertNotEquals(location4, Driver.Location.Library);
        }
        
        // GetRandomLocation cannot be called on a Driver whose currentLocation is OutsideCity.
        // Instanciate Simulator and call GetRandomLocationElsewhere with a parameter of OutsideCity.
        // Getting a random location elsewhere if already OutsideCity should throw exception.
        @Test(expected = IllegalArgumentException.class)
        public final void GetRandomLocationElsewhereFailsFromOutsideCity() {
            Simulator simulator = new Simulator(5);
            simulator.GetRandomLocationElsewhere(Driver.Location.OutsideCity);
        }
        
        // IsLocationValid should return true if newLocation is accessible from currentLocation.
        // Create instance of Simulator and run IsLocationValid with Hotel as currentLocation
        // and every other location in the Location enum as newLocation.
        // IsLocationValid should return true for newLocation of Library and of Diner but
        // it should return false for all other newLocation values.
        @Test()
        public final void ValidateNewLocationFromHotel() {
            Simulator simulator = new Simulator(5);
            assertTrue(simulator.IsLocationValid(Driver.Location.Hotel, Driver.Location.Library));
            assertTrue(simulator.IsLocationValid(Driver.Location.Hotel, Driver.Location.Diner));
            assertFalse(simulator.IsLocationValid(Driver.Location.Hotel, Driver.Location.Coffee));
            assertFalse(simulator.IsLocationValid(Driver.Location.Hotel, Driver.Location.OutsideCity));
            assertFalse(simulator.IsLocationValid(Driver.Location.Hotel, Driver.Location.Hotel));
        }
        
        // IsLocationValid should return true if newLocation is accessible from currentLocation.
        // Create instance of Simulator and run IsLocationValid with Library as currentLocation
        // and every other location in the Location enum as newLocation.
        // IsLocationValid should return true for newLocation of Hotel and of OutsideCity but
        // it should return false for all other newLocation values.
        @Test()
        public final void ValidateNewLocationFromLibrary() {
            Simulator simulator = new Simulator(5);
            assertTrue(simulator.IsLocationValid(Driver.Location.Library, Driver.Location.Hotel));
            assertTrue(simulator.IsLocationValid(Driver.Location.Library, Driver.Location.OutsideCity));
            assertFalse(simulator.IsLocationValid(Driver.Location.Library, Driver.Location.Coffee));
            assertFalse(simulator.IsLocationValid(Driver.Location.Library, Driver.Location.Diner));
            assertFalse(simulator.IsLocationValid(Driver.Location.Library, Driver.Location.Library));
        }
        
        // IsLocationValid should return true if newLocation is accessible from currentLocation.
        // Create instance of Simulator and run IsLocationValid with Coffee as currentLocation
        // and every other location in the Location enum as newLocation.
        // IsLocationValid should return true for newLocation of Diner and of Library but
        // it should return false for all other newLocation values.
        @Test()
        public final void ValidateNewLocationFromCoffee() {
            Simulator simulator = new Simulator(5);
            assertTrue(simulator.IsLocationValid(Driver.Location.Coffee, Driver.Location.Diner));
            assertTrue(simulator.IsLocationValid(Driver.Location.Coffee, Driver.Location.Library));
            assertFalse(simulator.IsLocationValid(Driver.Location.Coffee, Driver.Location.OutsideCity));
            assertFalse(simulator.IsLocationValid(Driver.Location.Coffee, Driver.Location.Hotel));
            assertFalse(simulator.IsLocationValid(Driver.Location.Coffee, Driver.Location.Coffee));
        }
        
        // IsLocationValid should return true if newLocation is accessible from currentLocation.
        // Create instance of Simulator and run IsLocationValid with Diner as currentLocation
        // and every other location in the Location enum as newLocation.
        // IsLocationValid should return true for newLocation of Coffee and of OutsideCity but
        // it should return false for all other newLocation values.
        @Test()
        public final void ValidateNewLocationFromDiner() {
            Simulator simulator = new Simulator(5);
            assertTrue(simulator.IsLocationValid(Driver.Location.Diner, Driver.Location.Coffee));
            assertTrue(simulator.IsLocationValid(Driver.Location.Diner, Driver.Location.OutsideCity));
            assertFalse(simulator.IsLocationValid(Driver.Location.Diner, Driver.Location.Library));
            assertFalse(simulator.IsLocationValid(Driver.Location.Diner, Driver.Location.Hotel));
            assertFalse(simulator.IsLocationValid(Driver.Location.Diner, Driver.Location.Diner));
        }
        
        // IsLocationValid should return true if newLocation is accessible from currentLocation.
        // Create instance of Simulator and run IsLocationValid with OutsideCity as currentLocation
        // and every other location in the Location enum as newLocation.
        // IsLocationValid should return false for all other values of newLocation.
        @Test()
        public final void ValidateNewLocationFromOutsideCity() {
            Simulator simulator = new Simulator(5);
            assertFalse(simulator.IsLocationValid(Driver.Location.OutsideCity, Driver.Location.Coffee));
            assertFalse(simulator.IsLocationValid(Driver.Location.OutsideCity, Driver.Location.OutsideCity));
            assertFalse(simulator.IsLocationValid(Driver.Location.OutsideCity, Driver.Location.Library));
            assertFalse(simulator.IsLocationValid(Driver.Location.OutsideCity, Driver.Location.Hotel));
            assertFalse(simulator.IsLocationValid(Driver.Location.OutsideCity, Driver.Location.Diner));
        }
    }
}

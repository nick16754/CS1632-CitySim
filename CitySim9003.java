
import java.util.ArrayList;
import java.util.Random;


/**
 * CS1632 Deliverable 2
 *
 * @author Nick Taglianetti
 */
public class CitySim9003 {
    private static final String[] locations = {"Hotel", "Diner", "Library", "Coffee"};
    private static final String[] outside_cities = {"Philadelphia", "Cleveland"};
    public static boolean exited_city;
    public static void main(String args[]) {
        
        Driver d1 = new Driver(1, null, 0);
        Driver d2 = new Driver(2, null, 0);
        Driver d3 = new Driver(3, null, 0);
        Driver d4 = new Driver(4, null, 0);
        Driver d5 = new Driver(5, null, 0);
        Driver[] drivers = {d1,d2,d3,d4,d5};
        
        int seed = 0;
        
        if (args.length > 0 && args.length <=1) {

            try {
                seed = Integer.parseInt(args[0]);
                System.out.println("args length: "+args.length+"\targ[0]: "+seed);
            } catch (NumberFormatException e) {
                System.err.println("Argument '" + args[0] + "' must be an integer.");
                System.exit(1);
            }
            //run program(seed)
            for(Driver driver : drivers)
            {
                while(!exited_city)
                {
                    simulateMove(driver, seed);
                }
                System.out.printf("Driver %d got %d cup(s) of coffee.\n-----\n", driver.getID(), driver.getNumCups());
                exited_city = false;
            }
            
        }
        else
        {
            System.err.println("Invalid argument(s) given");
            System.exit(1);
        }
    }
    
    
    static public void simulateMove(Driver driver, int seed)
    {
        Random rnd = new Random(seed);
        int rnd_loc;
        String[] loc_choices = new String[2];
        if (driver.getLocation() == null)
        {
            rnd_loc = rnd.nextInt(locations.length);
            driver.updateLocation(locations[rnd_loc]);
        }
        //from Hotel
        if (driver.getLocation() == locations[0])
        {
            loc_choices[0] = locations[1];
            loc_choices[1] = locations[2];
            rnd_loc = rnd.nextInt(loc_choices.length);
            driver.updateLocation(loc_choices[rnd_loc]);
            //to Diner
            if(driver.getLocation() == locations[1])
            {
                System.out.printf("Driver %d heading from %s to %s via Fourth Ave.\n", driver.getID(), locations[0], locations[1]);
            }
            //to Library
            else
            {
                System.out.printf("Driver %d heading from %s to %s via Bill St.\n", driver.getID(), locations[0], locations[2]);
            }
        }
        //from Diner
        else if (driver.getLocation() == locations[1])
        {
            loc_choices[0] = outside_cities[0];
            loc_choices[1] = locations[3];
            rnd_loc = rnd.nextInt(loc_choices.length);
            driver.updateLocation(loc_choices[rnd_loc]);
            //to Philadelphia
            if(driver.getLocation() == outside_cities[0])
            {
                System.out.printf("Driver %d heading from %s to %s via Fourth Ave.\n", driver.getID(), locations[1], outside_cities[0]);
                //we've gone to an outside city so return
                exited_city = true;
                return;
            }
            //to Coffee
            else
            {
                System.out.printf("Driver %d heading from %s to %s via Phil St.\n", driver.getID(), locations[1], locations[3]);
                driver.drinkCoffee();
            }
        }
        //from Library
        else if (driver.getLocation() == locations[2])
        {
            loc_choices[0] = outside_cities[1];
            loc_choices[1] = locations[0];
            rnd_loc = rnd.nextInt(loc_choices.length);
            driver.updateLocation(loc_choices[rnd_loc]);
            //to Cleveland
            if(driver.getLocation() == outside_cities[1])
            {
                System.out.printf("Driver %d heading from %s to %s via Fifth Ave.\n", driver.getID(), locations[2], outside_cities[1]);
                //we've gone to an outside city so return
                exited_city = true;
                return;
            }
            //to Hotel
            else
            {
                System.out.printf("Driver %d heading from %s to %s via Bill St.\n", driver.getID(), locations[2], locations[0]);
            }
        }
        //from Coffee
        else if (driver.getLocation() == locations[3])
        {
            loc_choices[0] = locations[1];
            loc_choices[1] = locations[2];
            rnd_loc = rnd.nextInt(loc_choices.length);
            driver.updateLocation(loc_choices[rnd_loc]);
            //to Library
            if(driver.getLocation() == locations[2])
            {
                System.out.printf("Driver %d heading from %s to %s via Fifth Ave.\n", driver.getID(), locations[3], locations[2]);
            }
            //to Diner
            else
            {
                System.out.printf("Driver %d heading from %s to %s via Phil St.\n", driver.getID(), locations[3], locations[1]);
            }
        }
    }
}


import java.util.ArrayList;
import java.util.Random;


/**
 * CS1632 Deliverable 2
 *
 * @author Nick Taglianetti
 */
public class CitySim9003 {
    private final String[] locations = {"Hotel", "Diner", "Library", "Coffee"};
    private final String[] outside_cities = {"Philadelphia", "Cleveland"};
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
                simulateMove(driver, seed);
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
        if (driver.getLocation() == null)
        {
            
        }
    }
}

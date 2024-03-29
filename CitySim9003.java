/**
 * CS1632 Deliverable 2
 *
 * @author Nick Taglianetti
 */

public class CitySim9003 {

    public static void main(String args[]) {
        int seed = 0;
        
        if (args.length > 0 && args.length <=1) {

            try {
                seed = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument '" + args[0] + "' must be an integer.");
                System.exit(1);
            }

            // instantiate INumberGenerator with the 
            INumberGenerator numberGenerator = new RandomGenerator(seed);
            
            // inject the random generator into Simulator
            // so that we can mock the random generator 
            // in our tests.
            Simulator simulator = new Simulator(numberGenerator); 
            //  run simulation
            simulator.RunSimulation();
            
        }
        else
        {
            System.err.println("Invalid argument(s) given");
            System.exit(1);
        }
    }
}

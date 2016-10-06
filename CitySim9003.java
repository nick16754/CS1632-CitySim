
/**
 * CS1632 Deliverable 2
 *
 * @author Nick Taglianetti
 */
public class CitySim9003 {

    public static void main(String args[]) {
        int seed;
        if (args.length > 0 && args.length <=1) {

            try {
                seed = Integer.parseInt(args[0]);
                System.out.println("args length: "+args.length+"\targ[0]: "+seed);
            } catch (NumberFormatException e) {
                System.err.println("Argument '" + args[0] + "' must be an integer.");
                System.exit(1);
            }
            //run program(seed)
        }
        else
        {
            System.err.println("Invalid argument(s) given");
            System.exit(1);
        }
    }
}


/**
 * CS1635 Deliverable 2
 *
 * @author Nick Taglianetti
 */

//Used to Mock the built-in Random class
public class StubGenerator implements INumberGenerator {

    // make desired output value a public field
    public int DesiredValue;

    // stubs the nextInt method of Random
    public int nextInt(int maxValue) {
        return DesiredValue;
    }
}

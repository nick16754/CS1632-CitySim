
import java.util.Random;

/**
 * CS1635 Deliverable 2
 *
 * @author Nick Taglianetti
 */
//Mock class of built-in Random class
public class RandomGenerator implements INumberGenerator {

    private Random random;

    public RandomGenerator(int seed) {
        if (seed < 0) {
            throw new IllegalArgumentException("seed much be positive");
        }
        this.random = new Random(seed);
    }

    public int nextInt(int maxValue) {
        return random.nextInt(maxValue);
    }
}

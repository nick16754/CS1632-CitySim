import java.util.Random;

/**
 *
 * @author nick_
 */
public class RandomGenerator implements INumberGenerator
    {
        private Random random;

        public RandomGenerator(int seed)
        {
            if (seed < 0)
            {
                throw new IllegalArgumentException("seed much be positive");
            }
            this.random = new Random(seed);
        }

        public int nextInt(int maxValue)
        {
            return random.nextInt(maxValue);
        }
    }

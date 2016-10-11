
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author nick_
 */
public class RandomGeneratorTests {
    //RandomGenerator should produce the same int as the random class
    //when nextInt is implemented with the same max parameter value
    @Test
    public void RandomGeneratorNextMatchesRandomNext()
    {
        int seed = 123;
        int max = 11;
        RandomGenerator randomGenerator = new RandomGenerator(seed);
        Random random = new Random(seed);

        assertEquals(randomGenerator.nextInt(max), random.nextInt(max));

    }
}

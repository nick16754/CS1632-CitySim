/**
 *
 * @author nick_
 */

//To be used in SimulatorTests to Mock the built-in Random class
public class MockGenerator implements INumberGenerator
{
    // make desired output value a public field
    public int DesiredValue;

    public int nextInt(int maxValue)
    {
        return DesiredValue;
    }
}

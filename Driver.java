/**
 *
 * @author nick_
 */
public class Driver {
    private int id;
    private String currentLocation;
    private int cupsCoffee;
    
    public Driver (int id, String loc, int coffee)
    {
        this.id = id;
        this.currentLocation = loc;
        this.cupsCoffee = coffee;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getLocation()
    {
        return currentLocation;
    }
    
    public int getNumCups()
    {
        return cupsCoffee;
    }
}

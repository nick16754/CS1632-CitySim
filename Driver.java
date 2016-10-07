/**
 * CS1635 Deliverable 2
 * @author Nick Taglianetti
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
        return this.id;
    }
    
    public String getLocation()
    {
        return this.currentLocation;
    }
    
    public int getNumCups()
    {
        return this.cupsCoffee;
    }
    
    public void drinkCoffee()
    {
        this.cupsCoffee++;
    }
    
    public void updateLocation(String new_location)
    {
        this.currentLocation = new_location;
    }
}

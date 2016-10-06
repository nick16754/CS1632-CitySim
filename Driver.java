/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CitySim9003;

/**
 *
 * @author nick_
 */
public class Driver {
    int id;
    String location;
    int cupsCoffee;
    
    public Driver (int id, String loc, int coffee)
    {
        this.id = id;
        this.location = loc;
        this.cupsCoffee = coffee;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public int getNumCups()
    {
        return cupsCoffee;
    }
}

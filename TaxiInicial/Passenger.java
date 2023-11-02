package TaxiInicial;

/**
 * Model a passenger wishing to get from one
 * location to another.
 * 
 * @author Los chavales
 * @version 2023.10.02  
 */
public class Passenger
{
    private String name;
    private Location pickup;
    private Location destination;
    private String nameTaxi;
  
    /**
     * Constructor for objects of class Passenger
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param name The passenger's name
     * @param nameTaxi The taxi´s name
     * @throws NullPointerException If either location is null.
     */
    public Passenger(Location pickup, Location destination,String name, String nameTaxi)
    {
    
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;
        this.name = name;
        this.nameTaxi = nameTaxi;
    }
    
    /**
     * 
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param name The passenger's name
     * @throws NullPointerException If either location is null. 
     */

    public Passenger(Location pickup, Location destination, String name) {
         if(pickup == null) {
             throw new NullPointerException("Pickup location");
         }
         if(destination == null) {
             throw new NullPointerException("Destination location");
         }
         this.pickup = pickup;
         this.destination = destination;
         this.name = name;
    }

    /**
     * @return The name of the passenger.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The destination location.
     */
    public Location getDestination()
    {
        return destination;
    }
    
    /**
     * Return details of the passenger, such as where it is.
     * @return A string representation of the passenger.
     */
    public String toString()
    {
        return name;
    }
    
    /**
     * @return The current location.
     */
    
    public Location getPosition(){
        return pickup;
    }
    
    /**
     * Show the final information about the passenger, including the name of the taxi that used.
     */
    public void showFinalInfo()
    {
        System.out.println("Passenger "+ name +" in location " + pickup + " moving to " + destination + " transported by " + nameTaxi);
    }

    /**
     * @return The taxi name.
     */
    
    public String getNameTaxi() {
        return nameTaxi;
    }
    
    /**
     * 
     * @return The pickup location
     */
    public Location getPickup() {
        return pickup;
    }
    
    /**
     * 
     * @param pickup The pickup location
     * Change the pickup location
     */
    public void setPickup(Location pickup) {
        this.pickup = pickup;
    }
    
    /**
     * 
     * @param name The passenger name
     * Change the passenger name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @param destination The destination location
     * Change the destination location
     */
    public void setDestination(Location destination) {
        this.destination = destination;
    }
    
    /**
     * 
     * @param nameTaxi The taxi name
     * Change the taxi name
     */
    public void setNameTaxi(String nameTaxi) {
        this.nameTaxi = nameTaxi;
    }
    
    /**
     * Change the taxi to null, offload the taxi
     */
    public void arrives(){
        nameTaxi = null;
    }
}

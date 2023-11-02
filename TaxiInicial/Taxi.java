package TaxiInicial;

/**
 * Model the common elements of taxis and shuttles.
 * 
 * @author Los chavales
 * @version 2023.11.02
 */
public class Taxi
{
    private TransportCompany company; 
    private Location location; 
    private  Location targetLocation;
    private int idleCount;
    private String name;
    private Passenger passenger;
    private int passengersTransported;

    /**
     * Constructor of class Vehicle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public Taxi(TransportCompany company, Location location, String name, Passenger passenger, int passengersTransported )
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
          if(passenger == null) {
            throw new NullPointerException("passenger");
        }
        
        this.company = company;
        this.location = location;
        targetLocation = null;
        idleCount = 0;
        this.name = name;
        this.passenger = passenger;
        this.passengersTransported = passengersTransported;
    }

    public Taxi(TransportCompany company, Location location, String name) {
        super();
        this.company = company;
        this.location = location;
        this.name = name;
    }
    
    /**
     * @return the TransportCompany of the taxi
     */
    public TransportCompany getCompany()
    {
        return company;
    }
    
    /**
    * Sets the current company
    * @param company Where it is.
    */
    public void setCompany(TransportCompany company)
    {
        this.company = company;
    }
    
    /**
     * @return the passengersTransported by the taxi
     */
    public int getPassengersTransported()
    {
        return passengersTransported;
    }
    
    /**
    * Sets the passengersTransported
    * @param passengersTransported Where it is.
    */
    public void setPassengersTransported(int passengersTransported)
    {
        this.passengersTransported = passengersTransported;
    }

    /**
     * @return the name of the taxi
     */
    public String getName()
    {
        return name;
    }
    
    /**
    * Sets the current Name
    * @param name The new name.
    */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the location.
     * @return Where this taxi is currently located.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Get the target location.
     * @return Where this vehicle is currently headed, or null
     *         if it is idle.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }

    /**
     * Set the required target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    
    /**
     * Has the vehicle a target Location?
     * @return Whether or not this vehicle has a target Location.
     */
    public boolean hasTargetLocation(){
        return getTargetLocation() != null;
    }
    
    /**
     * Clear the target location.
     */
    public void clearTargetLocation()
    {
        targetLocation = null;
    }

    /**
     * @return on how many steps this vehicle has been idle.
     */
    public int getIdleCount()
    {
        return idleCount;
    }
    
    /**
    * Set the IdleCount.
    * @param idleCount, a counter of passangers.
    */
    public void setIdleCount(int idleCount)
    {
        this.idleCount = idleCount;
    }

    /**
     * Increment the number of steps on which this vehicle
     * has been idle.
     */
    public void incrementIdleCount()
    {
        idleCount++;
    }

    /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    @Override
    public String toString(){
        return name;
    }

    /**
     * Is the taxi free?
     * @return Whether or not this taxi is free.
     */
    public boolean isFree()
    {
        return targetLocation == null && passenger == null;
    }

    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        company.arrivedAtPickup(this);
    }

    /**
     * Notify the company of our arrival at a passenger's destination.
     */
    public void notifyPassengerArrival(Passenger passenger)
    {
        company.arrivedAtDestination(this, passenger);
    }

    /**
     * Receive a passenger.
     * Set passenger's destination as its target location.
     * @param passenger The passenger.
     */
    public void pickup(Passenger passenger)
    {
        this.passenger = passenger;
        passengersTransported++;
    }

    /**
     * Offload the passenger.
     */
    public void offloadPassenger(){
        passenger = null;
    }

    /**
     * @return how many passengers this vehicle has transported.
     */
    public int passengersTransported()
    {
        return passengersTransported;
    }
    
    /**
     * Increment the number of passengers this vehicle has transported.
     */
    protected void incrementPassengersTransported()
    {
        passengersTransported ++;
    }

    /**
     * Get the distance to the target location from the current location.
     * @return distance to target location.
     */
    public int distanceToTheTargetLocation()
    {
        return location.distance(this.targetLocation);

    }

    /**
     * Carry out a taxi's actions.
     */
    public void act()
    {
        Location target = getTargetLocation();
        if(target != null) {
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            System.out.println("@@@ Taxi: " + name + " moving to " + location);
            if(next.equals(target)) {
                if(passenger != null) {
                    notifyPassengerArrival(passenger);
                }
                else {
                    notifyPickupArrival();
                }
            } 
        }
        else {
            incrementIdleCount();
        }
    }
    
    /**
     * Get the passanger
     * @return passanger
     */
     public Passenger getPassenger() {
        return passenger;
    }

    /**
    * Set the current passangeers
    * @return passanger
    */
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    

    /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    public void showFinalInfo()
    {
        System.out.println("Taxi " + name + " at location " + location + " - passengers transported: " + passengersTransported + " - non active for: " + idleCount);
    }
}
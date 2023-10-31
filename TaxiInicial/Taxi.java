package TaxiInicial;

/**
 * Model the common elements of taxis and shuttles.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class Taxi 
{
    // The Taxi Company of this Taxi.
    private TransportCompany company;   //TODO cambiar a private
    // Where the vehicle is.
    private Location location;     //TODO cambiar a private
    // Where the vehicle is headed.
    private  Location targetLocation;   //TODO cambiar a private
    // Record how often the vehicle has nothing to do.
    private int idleCount;       //TODO cambiar a private
    //name of the taxi
    private String name; //TODO cambiar a private
    //TODO añadir campos necesarios
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
        //TODO resto de inicializaciones pendientes
    }

    /**
     * @return the name of the taxi
     */
    public String getName()
    {
        return name;
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
     * Receive a pickup location. This becomes the
     * target location.
     * @param location The pickup location.
     */
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
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
    public String toString()
    {
        return getClass().getName() + " " +getName()+" at " + getLocation();
    }

    /**
     * Is the taxi free?
     * @return Whether or not this taxi is free.
     */
    public boolean isFree()
    {
        //TODO  implementar este método
        return getTargetLocation() == null && passenger == null;
    }

    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        //TODO  implementar este método
        company.arrivedAtPickup(this);
    }

    /**
     * Notify the company of our arrival at a passenger's destination.
     */
    public void notifyPassengerArrival(Passenger passenger)
    {
        //TODO  implementar este método
        company.arrivedAtDestination(this, passenger);
    }

    /**
     * Receive a passenger.
     * Set passenger's destination as its target location.
     * @param passenger The passenger.
     */
    public void pickup(Passenger passenger)
    {
        //TODO  implementar este método
        this.passenger = passenger;
        setTargetLocation(passenger.getDestination());
    }

    /**
     * Offload the passenger.
     */
    public void offloadPassenger()
    {
        //TODO  implementar este método
        passenger = null;
        clearTargetLocation();
    }
    
    

    /**
     * @return how many passengers this vehicle has transported.
     */
    public int passengersTransported()
    {
        //TODO  implementar este método
        return passengersTransported;
    }
    
    /**
     * Increment the number of passengers this vehicle has transported.
     */
    protected void incrementPassengersTransported()
    {
        //TODO  implementar este método
        passengersTransported ++;
    }

    /**
     * Get the distance to the target location from the current location.
     * @return distance to target location.
     */
    public int distanceToTheTargetLocation()
    {
        //TODO  implementar este método
        return location.distance(targetLocation);

    }

    /**
     * Carry out a taxi's actions.
     */
    public void act()
    {
        //TODO  implementar este método
         Location target = getTargetLocation();
        if(target != null) {
            // Find where to move to next.
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            if(next.equals(target)) {
                if(passenger != null) {
                    notifyPassengerArrival(passenger);
                    offloadPassenger();
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
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    public String showFinalInfo()
    {
        //TODO  implementar este método
        return  name + " Posicion: " + location + " Nº de pasajeros: " + passengersTransported + " Nº de pasos: " + idleCount;

    }

}

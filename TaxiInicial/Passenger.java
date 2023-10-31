package TaxiInicial;

/**
 * Model a passenger wishing to get from one
 * location to another.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class Passenger
{
    private String name;
    private Location pickup;
    private Location destination;
    private Taxi nombreTaxi;
    //incluir campo para el nombre del taxi que lo ha transportado

    /**
     * Constructor for objects of class Passenger
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param name The passenger's name
     * @throws NullPointerException If either location is null.
     */
    public Passenger(Location pickup, Location destination, String name)
    {
        //TODO modificar el constructor o crear otro constructor si necesario
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;
        this.name = name;
        //incluir inicialización del campo para el nombre del taxi que lo ha transportado
        this.nombreTaxi = nombreTaxi;
    }

    /**
     * @return The name of the passenger.
     */
    public String getName()
    {
        return name;
    }

    //TODO Debe poder devolver la localización donde hay que llevar al Passenger.
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
        return getName()+" con destino a " + destination + " en el taxi " + nombreTaxi;
    }
    
    //TODO Debe poder devolver la posición donde hay que recoger al Passenger.
    public Location posicion(){
        return pickup;
    }

    //TODO Debe poder modificarse el nombre del taxi usado.
    public void setNombreTaxi(Taxi taxiUsado) {
    this.nombreTaxi = taxiUsado;
    }
    
    //TODO Debe poder devolver el nombre del taxi usado..
    /**
     * @return The name of taxi.
     */
    public Taxi getNombreTaxi()
    {
        return nombreTaxi;
    }
    
    
    /**
     * Show the final information about the passenger, including the name of the taxi that used.
     */
    public String showFinalInfo()
    {
        // TO DO
        return "Pasajero "+ name +" viaja de " +
               pickup + " hacia " + destination + " en el taxi " + nombreTaxi;
    }

}

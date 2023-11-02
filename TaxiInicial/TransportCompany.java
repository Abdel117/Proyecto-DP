package TaxiInicial;
import java.util.*;

/**
 * Model the operation of a transport company, operating different
 * types of vehicle. This version just operates with normal taxis.
 * 
 * @author Los chavales
 * @version 2023.11.02
 */
public class TransportCompany  
{
    private String name;  //nombre de la compañia
    private List<Taxi> vehicles; //coleccion de taxis de la compañia
    private List<Passenger> passengers;  //coleccion de pasajeros 
    private Assignments assignments; //coleccion de asignaciones
    

    /**
     * Constructor for objects of class TransportCompany.
     * @param name The name of the company.
     */
    public TransportCompany(String name)
    {
        this.name = name;
        this.vehicles = new LinkedList<>(); 
        this.passengers =  new LinkedList<>(); 
        this.assignments = new Assignments(); 

    }

    /**
     * @return The name of the company.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets a new name for the company.
     * @param name New name for the company.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return The list of vehicles.
     */
    public List<Taxi> getVehicles()
    {       
        return vehicles;
    }
    
    /**
     * Sets new vehicles to the company.
     */
    public void setVehicles(List<Taxi> vehicles){
        this.vehicles = vehicles;
    }
    
    /**
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers()
    {
        return passengers;
    }
    
    /**
     * Sets new passengers to the company.
     */
    public void setPassengers(List<Passenger> passengers){
        this.passengers = passengers;
    }
    
    /**
     * @return The assignments of the company.
    */
    public Assignments getAssignments(){
        return assignments;
    }
    
    /**
    * Sets new assignments to the company.
    */
    public void setAssignments(Assignments assignments){
        this.assignments = assignments;
    }
    
    /**
     * Add the a new vehicle to the company.
     * @param vehicle The new vehicle; 
     */
    public void addVehicle(Taxi vehicle)
    {
        vehicles.add(vehicle);
    }

    /**
     * Add a new passenger in the company.
     * @param passenger The new passenger.
     */
    public void addPassenger(Passenger passenger)
    {
        passengers.add(passenger);
    }

    /**
     * Find the most closed free vehicle to a location, if any.
     * @param location location to go
     * @return A free vehicle, or null if there is none.
     */

    public Taxi scheduleVehicle(Location destination) {   
        List<Taxi> sortedVehicles = new LinkedList<>();
        sortedVehicles.addAll(vehicles);
        Taxi closestTaxi = null;
        Collections.sort(sortedVehicles, Comparator.comparing(taxi -> taxi.getLocation().distance(destination)));

        boolean foundPosition = false;
        for (int j = 0; j < sortedVehicles.size() && !foundPosition; j++) {
            if (sortedVehicles.get(j).isFree()){
                closestTaxi = sortedVehicles.get(j);
                foundPosition = true;
            }
        }
        return closestTaxi;
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
    */
    public boolean requestPickup(Passenger passenger)
    {
        boolean found = false; 
        Taxi taxi = scheduleVehicle(passenger.getPosition()); 

        if(taxi != null){
            taxi.setTargetLocation(passenger.getPosition());
            assignments.addAssignment(taxi, passenger); 
            passenger.setNameTaxi(taxi.getName());
            found = true; 
        }
        return found;
    }
    
    /**
     * A taxi has arrived at a pickup point.
     * @param taxi The taxi at the pickup point.
    */
    public void arrivedAtPickup(Taxi taxi)
    {
        if(assignments.contains(taxi)){
            Passenger passenger = assignments.getPassenger(taxi); 
            taxi.pickup(passenger);
            assignments.deleteAssingment(taxi);
            System.out.println("<<<< Taxi "+ taxi + " at location " + taxi.getLocation() + " picks up " + passenger.getName());
            taxi.setTargetLocation(passenger.getDestination());
        }
    }
    
    /**
     * A taxi has arrived at a destination point and offloads the passenger.
     * @param taxi The taxi at the destination point.
     * @param passenger The passenger offloaded.
     */
    public void arrivedAtDestination(Taxi taxi, Passenger passenger){

        System.out.println(">>>> Taxi " +  taxi +" at location " + taxi.getLocation() + " offloads Passenger " + passenger + " travelling from " + passenger.getPosition() + " to " + passenger.getDestination());
        taxi.offloadPassenger();
        //passenger.arrives();
        taxi.clearTargetLocation();
    }
    
    /**
     * @return The name of the company as a string.
     */
    @Override
    public String toString(){
        return name;
    }  
}

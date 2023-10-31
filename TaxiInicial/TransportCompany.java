package TaxiInicial;

import java.util.*;
import java.util.HashMap;

/**
 * Model the operation of a taxi company, operating different
 * types of vehicle. This version operates a single taxi.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TransportCompany  
{
    private String name;  //nombre de la compañía
    private List<Taxi> vehicles; //coleccion de taxis de la compañia
    private List<Passenger> passengers;  //coleccion de pasajeros 
    private Assignments assignments; //coleccion de asignaciones
    

    /**
     * Constructor for objects of class TransportCompany
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
     * A taxi has arrived at a destination point and offloads the passenger.
     * @param taxi The taxi at the destination point.
     * @param passenger The passenger offloaded.
     */
    public void arrivedAtDestination(Taxi taxi, Passenger passenger){
        System.out.println("Taxi " +  taxi +" at " + taxi.getLocation() + " offloads Passenger " + passenger + " travelling from " + passenger.getPickup() + " to " + passenger.getDestination());
    }

    /**
     * @return The list of vehicles.
     */
    public List<Taxi> getVehicles()
    {       
        return vehicles;
    }

    /**
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers()
    {
        return passengers;
    }

    /**
     * Add the new Vehicle.
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
     * Find a the most closed free vehicle to a location, if any.
     * @param location location to go
     * @return A free vehicle, or null if there is none.
     */
    private Taxi scheduleVehicle(Location location)
    {
        List <Taxi> auxVehicles = new LinkedList<>(); 
        boolean found; 
        for(int i = 0; i < vehicles.size(); i++){ //Recorre la lista de vehiculos
            if(vehicles.get(i).isFree()){ //Si el vehiculo esta libre
                found = false;
                vehicles.get(i).setTargetLocation(location); //Añadimos la localizacion a su destino
                for(int j = 0; j < auxVehicles.size() && !found ; j++){ //Recorremos la lista auxiliar
                    if(auxVehicles == null || 
                        auxVehicles.get(j).distanceToTheTargetLocation() >
                        vehicles.get(i).distanceToTheTargetLocation()){
                        found = true; 
                        auxVehicles.add(j,vehicles.get(i)); //Añade el vehiculo a la lista en la posicion correspondiente
                    }
                }
            }
        }
        return auxVehicles.get(0); //Devolvemos el primer elemento de la lista
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(Passenger passenger)
    {
        boolean found = false; 
        Taxi taxi = shceduleVehicle(passenger.getLocation()); //Llamamos a la funcion que devuelve el taxi mas cercano
        if(taxi != null){
            taxi.setPickupLocation(passenger.getLocation()); //Establecemos el punto de recogida
            assignments.addAssignment(taxi, passenger); //Añadimos el taxi al HashMap de assignments
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
        Passenger passenger = assignments.getPassenger(taxi); 
        assignments.deleteAssingment(taxi);
        System.out.println("<<<< Taxi "+ taxi + " at location " + taxi.getLocation() + " picks up " + passenger.getName());
        passenger.setTaxiName(taxi.getName());
        taxi.pickup(passenger);
    }
    
    
    public boolean areThereAssignments(){
        return assignments.isEmpty();
    }
    
    @Override
    public String toString(){
        return name;
    }  
}

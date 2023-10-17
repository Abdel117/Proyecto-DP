package TaxiInicial;

import java.util.*;

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
    //TODO implementar assignments
    private List<Passenger> assignments; //coleccion de asignaciones
    

    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name)
    {
        this.name = name;
        this.vehicles = null; 
        this.passengers = null; 
        this.assignments = null; 

    }

    /**
     * @return The name of the company.
     */
    public String getName()
    {
        return name;
    }

    /**
     * A vehicle has arrived at a passenger's destination.
     * @param vehicle The vehicle at the destination.
     * @param passenger The passenger being dropped off.
     */
    public void arrivedAtDestination(Taxi vehicle,
    Passenger passenger)
    {
        System.out.println(vehicle + " offloads " + passenger);
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
        int position = 0; 
        while(passenger.getName().compareTo(passengers.get(position).getName()) < 0)
            position++;
        passengers.add(position, passenger);
    }

    /**
     * Find a the most closed free vehicle to a location, if any.
     * @param location location to go
     * @return A free vehicle, or null if there is none.
     */
    private Taxi scheduleVehicle(Location location)
    {
        List <Taxi> auxVehicles = null; 
        boolean found; 
        for(int i = 0; i < vehicles.size(); i++){
            if(vehicles.get(i).isFree()){
                for(int j = 0; j < auxVehicles.size() ; j++){
                    if(auxVehicles.get(j).distanceToTheTargetLocation() < vehicles.get(i).distanceToTheTargetLocation()){
                        found = true; 
                    }
                    
                }
            }
        }
        return auxVehicles.get(1);
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(Passenger passenger)
    {
        boolean found = false; 
        for(int i = 0; i < vehicles.size() && !found; i++){
            if(vehicles.get(i).isFree())
                found = true;
        }
        return found;
    }

    /**
     * A vehicle has arrived at a pickup point.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtPickup(Taxi taxi)
    {
        //TODO Obtener el pasajero asignado al taxi y eliminar la asignación correspondiente taxi/pasajero
        //TODO Descomentar siguiente línea cuando esté el método completamente implementado
        //System.out.println("<<<< "+taxi + " picks up " + passenger.getName());
        //TODO el pasajero debe guardar el nombre del taxi que le ha recogido
        //TODO el taxi debe recoger al pasajero
    }

}

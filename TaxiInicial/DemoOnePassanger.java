package TaxiInicial;

import java.util.*;

/**
 * Provide a simple demonstration of running a stage-one
 * scenario. A single passenger and taxi are created, and a pickup
 * requested. As the simulation is run, the passenger
 * should be picked up and then taken to their destination.
 * 
 * @author Los chavales
 * @version 2023.11.02
 */
public class DemoOnePassanger
{
    TransportCompany company;
    private List<Taxi> actors;

    /**
     * Constructor for objects of class DemoOnePassanger
     */
    public DemoOnePassanger()
    {
        company = new TransportCompany("Compañía Taxis Cáceres");
        actors = new ArrayList<>();
        reset();
    }

    /**
     * Run the demo for a fixed number of steps.
     */
    public void run()
    {        
        //Ejecutamos un número de pasos la simulación.
        //En cada paso, cada taxi realiza su acción
        for(int step = 0; step < 100; step++) {
            step();
        }
        showFinalInfo();
    }

    /**
     * Run the demo for one step by requesting
     * all actors to act.
     */
    public void step()
    {
        for(Taxi actor : actors) {
            actor.act();
        }
    }

    /**
     * Reset the demo to a starting point.
     * A single taxi and passenger are created, and a pickup is
     * requested for a single passenger.
     * @throws IllegalStateException If a pickup cannot be found
     */
    public void reset()
    {
        actors.clear();

        createTaxis();
        createPassengers(); 
        showInicialInfo();
        runSimulation();
    }

    /**
     * Taxis are created and added to the company
     */
    private void createTaxis() {
        Taxi taxi = new Taxi(company, new Location(10, 10),"T1");
        company.addVehicle(taxi);
        actors.addAll(company.getVehicles());
    }

    /**
     * Passengers are created and added to the company
     */
    private void createPassengers() {
        Passenger passenger = new Passenger(new Location(6, 6),
                new Location(5,2),"Lucy");
        company.addPassenger(passenger);
    }

    /**
     * A pickup is requested for a single passenger.
     * @throws IllegalStateException If a pickup cannot be found
     */
    private void runSimulation() {
        List<Passenger> passengers = company.getPassengers();
        for(Passenger passenger : passengers) {
            if(!company.requestPickup(passenger)) {
                throw new IllegalStateException("Failed to find a pickup.");        
            }
        }

    }

    private void showInicialInfo() {

        System.out.println("--->> Simulation of the company: "+company+" <<---");
        System.out.println("-->> Taxis of the company <<--");

        //ordenar y mostrar los taxis
        Collections.sort(actors, new ComparatorNameTaxi());
        Iterator<Taxi> iterator = actors.iterator();
        while (iterator.hasNext()) {
            Taxi actor = iterator.next();
            System.out.println("Taxi " + actor + " at location " + actor.getLocation());
        }   
            
        //ordenar y mostrar los pasajero/as
        Collections.sort(company.getPassengers(),new ComparatorNamePassenger());
       
        System.out.println("-->> Passengers requesting taxi <<--");
        System.out.println("-->> ---------------- <<--");
        
        for (Passenger passenger : company.getPassengers()){
            System.out.println("Passenger " + passenger + " travelling from location " + passenger.getPosition() + " to location " + passenger.getDestination() );
        }

        System.out.println("-->> Simulation start <<--");
        System.out.println("-->> ---------------- <<--");
            
    }
    
    /**
     * Final info is showed with the information about taxis and passengers
     */

    private void showFinalInfo() {

        System.out.println("");
        System.out.println("-->> ----------------- <<--");
        System.out.println("-->> End of simulation <<--");        
        System.out.println("-->> ----------------- <<--");
        System.out.println("");

        System.out.println("-->> Taxis final information <<--");
        // ordenar y mostrar los taxis
        Collections.sort(actors,new ComparatorNameTaxi());
        
        for(Taxi actor: actors){
             actor.showFinalInfo();
        }

        System.out.println("-->> Passengers final information <<--");
        //ordenar y mostrar los pasajero/as
        Iterator<Passenger> iterator = company.getPassengers().iterator();
        while (iterator.hasNext()) {
            Passenger passenger = iterator.next();
            passenger.showFinalInfo();
        }
    }
}

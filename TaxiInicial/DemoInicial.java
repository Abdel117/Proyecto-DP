package TaxiInicial;

import java.util.*;

/**
 * Provide a simple demonstration of running a stage-one
 * scenario. Two passengers and three taxis are created. Two pickups
 * requested. As the simulation is run, the passengers
 * should be picked up and then taken to their destination.
 * 
 * @author Los chavales
 * @version 2023.11.02
 */

public class DemoInicial
{
    TransportCompany company;
    private List<Taxi> actors;

    /**
     * Constructor for objects of class DemoOnePassanger
     */
    public DemoInicial()
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
        
        Taxi taxi1 = new Taxi(company, new Location(3, 3),"T2");
        Taxi taxi2 = new Taxi(company, new Location(10, 10),"T1");
        Taxi taxi3 = new Taxi(company, new Location(12, 14),"T3");
       
        company.addVehicle(taxi1);
        company.addVehicle(taxi2);
        company.addVehicle(taxi3);
 
        actors.addAll(company.getVehicles());
    }

    /**
     * Passengers are created and added to the company
     */
    private void createPassengers() {
        Passenger passenger1 = new Passenger(new Location(0, 0),
                new Location(2, 6),"Lucy");
        Passenger passenger2 = new Passenger(new Location(6, 6),
                new Location(5,2),"Gru");
        company.addPassenger(passenger1);
        company.addPassenger(passenger2);
    }

    /**
     * A pickup is requested for a single passenger.
     * @throws IllegalStateException If a pickup cannot be found
     */
    private void runSimulation() {
        List<Passenger> passengers = company.getPassengers();
        for(Passenger passenger : passengers) {
            if(!company.requestPickup(passenger)) {
                throw new IllegalStateException("Failed to find a pickup for: "+ passenger.getName());        
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



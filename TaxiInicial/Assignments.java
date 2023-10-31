package TaxiInicial;
import java.util.HashMap;
/**
 * Interface to handle the assignments of pairs Taxi-Passenger. 
 * 
 * @author Abdel Wahed Mahfuod Mouhandizi
 * @version 0.0.1
 */
public class Assignments
{
    private HashMap<Taxi, Passenger> assignments; 

    /**
     * Constructor for objects of class Assignments
     */
    public Assignments()
    {
        this.assignments = new HashMap<Taxi, Passenger>();
    }

    /**
     * Adds a pair taxi - passenger to the object.
     * @param  taxi The key for the pair Taxi-Passenger
     */
    public void addAssignment(Taxi taxi, Passenger passenger)
    {
        assignments.put(taxi, passenger); 
    }
    
    /**
     * Deletes a pair taxi - passenger from the object data structure. 
     * @param  taxi The key for the pair Taxi-Passenger
     */
    public void deleteAssingment(Taxi taxi){
        assignments.remove(taxi);
    }
    /**
     * Finds and returns a passenger.
     * @param  taxi The key for the pair Taxi-Passenger.
     * @return      The passenger from the data structure of the object. 
     */
    public Passenger getPassenger(Taxi taxi){
        return assignments.get(taxi); 
    }
    
    
}

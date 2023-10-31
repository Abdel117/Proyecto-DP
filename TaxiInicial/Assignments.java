package TaxiInicial;
import java.util.HashMap;
/**
 * Write a description of class Assignments here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assignments
{
    // instance variables - replace the example below with your own
    private HashMap<Taxi, Passenger> assignments; 

    /**
     * Constructor for objects of class Assignments
     */
    public Assignments()
    {
        this.assignments = new HashMap<Taxi, Passenger>();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  taxi The key for the pair Taxi-Passenger
     * @return     the sum of x and y 
     */
    public void addAssignment(Taxi taxi, Passenger passenger)
    {
        assignments.put(taxi, passenger); 
    }
    
    public void deleteAssingment(Taxi taxi){
        assignments.remove(taxi);
    }
    
    public Passenger getPassenger(Taxi taxi){
        return assignments.get(taxi); 
    }
    
    
}

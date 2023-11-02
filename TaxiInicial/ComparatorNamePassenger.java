package TaxiInicial;

import java.util.*; 

/**
 * Compare passengers by name in ascending order.
 * 
 * @author DP Clasess
 * @version 2023
 */
public class ComparatorNamePassenger implements Comparator<Passenger>
{
	@Override
	public int compare(Passenger p1, Passenger p2) {
		// TODO Auto-generated method stub
		 return (p1.getName().compareTo(p2.getName()));
	}


}

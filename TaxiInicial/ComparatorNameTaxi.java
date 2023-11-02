package TaxiInicial;
import java.util.Comparator;

public class ComparatorNameTaxi implements Comparator<Taxi> {
    @Override
    public int compare(Taxi t1, Taxi t2) {
        return (t1.getName().compareTo(t2.getName()));
    }
}

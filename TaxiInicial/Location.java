package TaxiInicial;

import java.util.Comparator;

/**
 * Model a location in a city.
 * 
 * @author Los chavales
 * @version 2023.11.02 
 */
public class Location
{
    public int x; 
    public int y;  

    /**
     * Model a location in the city.
     * @param x The x coordinate. Must be positive.
     * @param y The y coordinate. Must be positive.
     * @throws IllegalArgumentException If a coordinate is negative.
     */
    public Location(int x, int y)
    {
        if(x < 0) {
            throw new IllegalArgumentException(
                "Negative x-coordinate: " + x);
        }
        if(y < 0) {
            throw new IllegalArgumentException(
                "Negative y-coordinate: " + y);
        }        
        this.x = x;
        this.y = y;
    }

    /**
     * @return The x coordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * @return The y coordinate.
     */
    public int getY()
    {    
        return y;
    }

    /**
     * Generate the next location to visit in order to
     * reach the destination.
     * @param destination Where we want to get to.
     * @return A location in a direct line from this to
     *         destination.
     */
    public Location nextLocation(Location destination)
    {
      
        int destinoX = destination.getX(); //Obtenemos el destino de x e y
        int destinoY = destination.getY();
        int offsetX = 0;
        int offsetY = 0;
        
        if(x < destinoX) {
            offsetX = 1;
        } else if (x > destinoX) {
            offsetX = -1;
        }
        
        if(y < destinoY) {
            offsetY = 1;
        } else if (y > destinoY) {
            offsetY = -1;
        }
        
        if(offsetX != 0 || offsetY != 0) {
            return new Location(x + offsetX, y + offsetY); //Retorna posicion por posicion hasta que llega al destino
        }
        else {
            return destination;
        }
    }

    /**
     * Determine the number of movements required to get
     * from here to the destination.
     * @param destination The required destination.
     * @return the number of movement steps.
     */
    public int distance(Location destination)
    {
   
        int xDistancia = Math.abs(destination.getX() - x);
        int yDistancia = Math.abs(destination.getY() - y);
        return xDistancia + yDistancia; //Devuelve la suma de los dos valores
    }
    
    /**
     * Change the x cordinate location
     * @param x The coordinate x location
     * 
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Change the Y cordinate location
     * @param y The coordinate Y location
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Implement content equality for locations.
     * @return true if this location matches the other, false otherwise.
     */
    public boolean equals(Object other)
    {
        if(other instanceof Location) {
            Location otherLocation = (Location) other;
            return x == otherLocation.getX() &&
            y == otherLocation.getY();
        }
        else {
            return false;
        }
    }

    /**
     * @return A representation of the location.
     */
    public String toString()
    {
        return x + "," + y;
    }

    /**
     * Use the top 16 bits for the y value and the bottom for the x.
     * Except for very big grids, this should give a unique hash code
     * for each (x, y) pair.
     * @return A hashcode for the location.
     */
    public int hashCode()
    {
        return (y << 16) + x;
    }
}

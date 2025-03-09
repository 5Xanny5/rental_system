/**
 * Rozhranie FuelVehicle definuje metódy súvisiace s úrovňou paliva pre vozidlo poháňané palivom.
 */
public interface FuelVehicle {

    /**
     * Získa aktuálnu úroveň paliva vozidla.
     *
     * @return Aktuálna úroveň paliva v litroch.
     */
    public double getFuelLevel();

    /**
     * Zatankuje palivo vozidla na určenú úroveň.
     *
     * @param fuelLevel Cieľová úroveň paliva na natankovanie.
     */
    public void refuel(double fuelLevel);
}

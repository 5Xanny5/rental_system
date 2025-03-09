/**
 * Rozhranie ElectricVehicle definuje metódy súvisiace s úrovňou batérie pre elektrické vozidlo.
 */

public interface ElectricVehicle {
    /**
     * Získa aktuálny percentuálny stav batérie elektrického vozidla.
     *
     * @return Aktuálny percentuálny stav batérie.
     */
    public int getBatteryPercentage();

    /**
     * Nabije elektrické vozidlo na určený percentuálny stav batérie.
     *
     * @param batteryPercentage Cieľový percentuálny stav batérie na nabíjanie.
     */
    public void charge(int batteryPercentage);
}

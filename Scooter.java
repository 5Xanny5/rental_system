/**
 * Konkrétna trieda predstavujúca Scooter.
 */
public class Scooter extends Vehicle  implements ElectricVehicle 
    {   /** % batarie scootera */
        private int batteryCapacity;
        /***
        Konštruktor pre triedu Scooter.
         *
         * @param brand Značka vozidla.
         * @param model Model vozidla.
         * @param year Rok výroby vozidla.
         * @param hourlyRentalRate Cena prenájmu za hodinu.
         * @param dailyRentalRate Cena prenájmu za deň.
         * @param baterie Na kolko % je scooter nabity.
         */
    public Scooter(String brand, String model, int year, double hourlyRentalRate,
               int batteryCapacity) {
        super(brand, model, year, hourlyRentalRate);
        this.batteryCapacity = batteryCapacity;
    }
       /**
     * Výpočet ceny prenájmu na krátku dobu pre scooter.
     *
     * @param hours Počet hodín prenájmu.
     * @return Cena prenájmu na krátku dobu.
     */
    @Override
    public double calculateShortRentalCost(int hours) {
        
        return hours*getHourlyRentalRate();
    }

    /**
     * Výpočet ceny prenájmu na dlhú dobu pre scooter.
     *
     * @param days Počet dní prenájmu.
     * @return Cena prenájmu na dlhú dobu.
     */
    @Override
    public double calculateRentalCost(int days) {
        return days*getDailyRentalRate();
    }
    

    /**
     * Nastaví kapacitu batérie elektrického scootera.
     *
     * @param batteryCapacity Kapacita batérie.
     */
    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
      public int getBatteryPercentage() {
        return batteryCapacity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void charge(int batteryPercentage) {
        batteryCapacity=batteryPercentage;
    }
    @Override
    public double calculateRepairCost() {
        // Scooter repair cost logic
        double baseRepairCost = 60.0;
        double partsCost = 30.0;
        int hoursOfWork = 1;
        return baseRepairCost + partsCost + (hoursOfWork );
    }

}

/**
 * Trieda reprezentujúca príbeh prenájmu vozidla.
 * Obsahuje informácie o vozidle, zákazníkovi a stave prenájmu.
 * 
 * @author (Your Name)
 * @version (Version number or date)
 */
public class RentStory
{    /** Vozidlo v príbehu prenájmu. */
    private Vehicle vehicle;
    /** Zákazník v príbehu prenájmu. */
    private Customer customer;
    /** Stav prenájmu. */
    private RentStatus status;
   /**
     * Konštruktor pre objekty triedy RentStory.
     *
     * @param vehicle Vozidlo v príbehu prenájmu.
     * @param customer Zákazník v príbehu prenájmu.
     * @param status Stav prenájmu.
     */
    public RentStory(Vehicle vehicle,Customer customer,RentStatus status)
    {
       this.vehicle =  vehicle;
       this.customer = customer;
       this.status = status;
    }
    /**
     * Získaj stav prenájmu.
     *
     * @return Stav prenájmu.
     */
    public RentStatus getStatus(){
        return status;
    }
    /**
     * Získaj vozidlo v príbehu prenájmu.
     *
     * @return Vozidlo v príbehu prenájmu.
     */
    public Vehicle getVehicle(){
        return vehicle;
    }
    /**
     * Získaj zákazníka v príbehu prenájmu.
     *
     * @return Zákazník v príbehu prenájmu.
     */
    public Customer getCustomer(){
        return customer;
    }
    /**
     * Nastaví stav prenájmu.
     *
     * @param status Nový stav prenájmu.
     */
    public void setStatus(RentStatus status){
        this.status = status;
    }
}

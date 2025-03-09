import java.util.ArrayList;
import java.util.List;
/**
 * Trieda Customer reprezentuje zákazníka s atribútmi ako meno a prenajaté vozidlá.
 */
public class Customer
{
    /**Meno zákazníka*/
    private String meno;
    /**Prenajate vozidla*/
    private List<Vehicle>rentedVehicles;
     /**
     * Konštruktor pre triedu Customer.
     *
     * @param name Meno zákazníka.
     */
    public Customer(String name) {
        this.meno = name;
        this.rentedVehicles = new ArrayList<>();
    }
    /**
     * Vráti meno zákazníka.
     *
     * @return Meno zákazníka.
     */
    public String getName() {
        return meno;
    }

    /**
     * Nastaví meno zákazníka.
     *
     * @param name Meno zákazníka.
     */
    public void setName(String meno) {
        this.meno = meno;
    }

    /**
     * Vráti zoznam prenajatých vozidiel.
     *
     * @return Zoznam prenajatých vozidiel.
     */
    public List<Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }
}

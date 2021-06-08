package se.kth.iv1350.seminar4.Integration;

/**
 *
 * <code>StoreDTO</code> is a DTO representing a store.
 */
public class StoreDTO {
    private final AddressDTO address;
    private final String name;

    /**
     * Creates an instance of a store.
     * In this application the address and name of the store are hardcoded.
     */
    public StoreDTO(){
        this.address = new AddressDTO("Store street", 10, 91210, "Store city");
        this.name = "The Store";
    }

    /**
     * Gets the name of the store.
     * @return The name of the store.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the address of the store.
     * @return The address of the store.
     */
    public AddressDTO getAddress() {
        return address;
    }

    /**
     * Creates a string representation of the <code>StoreDTO</code> used on the receipt.
     * The address part resembles how an address is usually written.
     *
     * @return The string representation.
     */
    public String toString(){
        return "Store name: " + name + "\n"
                + "Store address: " + address.getStreetNumber() + " " + address.getStreetName() +
                ", " + address.getCity() + ", " + address.getPostalCode();
    }
}
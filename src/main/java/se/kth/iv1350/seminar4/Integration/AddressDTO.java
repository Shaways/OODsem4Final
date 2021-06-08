package se.kth.iv1350.seminar4.Integration;

/**
 *
 * <code>AddressDTO</code> is a DTO representing an address and n this case is the retail store. 
 */
public class AddressDTO {
    private final String streetName;
    private final int streetNumber;
    private final int postalCode;
    private final String city;

    /**
     * Creates an instance of an address.
     *
     * @param streetName The name of the street.
     * @param streetNumber The number on the street.
     * @param postalCode The postal code of the address.
     * @param city The city.
     */
    AddressDTO(String streetName, int streetNumber, int postalCode, String city){
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    /**
     * Getter to get the postal code of the address.
     * @return The postal code of the address.
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Getter to get the street number of the address.
     * @return The street number of the address.
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * Getter to get the city of the address.
     * @return The city of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter to get the street name of the address.
     * @return The street name of the address.
     */
    public String getStreetName() {
        return streetName;
    }

}
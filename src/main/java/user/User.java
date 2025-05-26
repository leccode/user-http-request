package user;

/**
 * A User model for the User properties
 * to be mapped byt the JSON response.
 * @param id Integer
 * @param name String
 * @param username String
 * @param email String
 * @param address Address object
 * @param phone String
 * @param website String
 * @param company Company object
 */
public record User(Integer id, String name, String username, String email, Address address, String phone, String website, Address.Geo.Company company) {
    /**
     * Address inner object of the root model.
     * @param street String
     * @param suite String
     * @param city String
     * @param zipcode String
     * @param geo Geo object
     */
    public record Address(String street, String suite, String city, String zipcode, Geo geo) {
        /**
         * Geo inner object of the Address object.
         * @param lat
         * @param lng
         */
        public record Geo(String lat, String lng) {
            /**
             * Company inner object of the root model.
             * @param name String
             * @param catchPhrase String
             * @param bs String
             */
            public record Company(String name, String catchPhrase, String bs) {
            }
        }
    }
}

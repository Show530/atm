public class MailingAddress {
    private String primaryStreet;
    private String secondaryStreet;
    private String city;
    private String state;
    private String postalCode;

    public MailingAddress(String primaryStreet,
                           String secondaryStreet,
                           String city,
                           String state,
                           String postalCode) {
        this.primaryStreet = primaryStreet;
        this.secondaryStreet = secondaryStreet;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getFormattedAddress() {
        if (getSecondaryStreet() != null) {
            return primaryStreet +  "\n" + secondaryStreet + "\n" + city + ", " + state + " " + postalCode;
        }
        else if (getPrimaryStreet() != null && getCity() != null && getState() != null && getPostalCode() != null) {
            return primaryStreet + "\n" + city + ", " + state + " " + postalCode;
        }
        else {
            return "N/A";
        }
    }

    public String validateStreet(String street) {
        if (street == null || street.length() == 0) {
            return null;
        }
        else {
            return street;
        }
    }

    public String validateCity(String city) {
        if (city == null || city.length() == 0) {
            return null;
        }
        else {
            return city;
        }
    }

    public String validateState(String state) {
        switch (state) {
            case "AL" :
            case "AK" :
            case "AZ" :
            case "AR" :
            case "CA" :
            case "CO" :
            case "CT" :
            case "DE" :
            case "DC" :
            case "FL" :
            case "GA" :
            case "HI" :
            case "ID" :
            case "IL" :
            case "IN" :
            case "IA" :
            case "KS" :
            case "KY" :
            case "LA" :
            case "ME" :
            case "MD" :
            case "MA" :
            case "MI" :
            case "MN" :
            case "MS" :
            case "MO" :
            case "MT" :
            case "NE" :
            case "NV" :
            case "NH" :
            case "NJ" :
            case "NM" :
            case "NY" :
            case "NC" :
            case "ND" :
            case "OH" :
            case "OK" :
            case "OR" :
            case "PA" :
            case "RI" :
            case "SC" :
            case "SD" :
            case "TN" :
            case "TX" :
            case "UT" :
            case "VT" :
            case "VA" :
            case "WA" :
            case "WV" :
            case "WI" :
            case "WY" :
                return state;
            default:
                return null;
        }
    }


    public String validatePostalCode(String postalCode) {
        if (postalCode.length() != 5) {
            return null;
        }
        else {
            return postalCode;
        }
    }

    public String getPrimaryStreet() {
        return primaryStreet;
    }

    public void setPrimaryStreet(String primaryStreet) {
        this.primaryStreet = validateCity(primaryStreet);
    }

    public String getSecondaryStreet() {
        return secondaryStreet;
    }

    public void setSecondaryStreet(String secondaryStreet) {
        this.secondaryStreet = validateCity(secondaryStreet);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = validateCity(city);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = validateCity(state);
    }

    public String getPostalCode() {
        return  postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = validateCity(postalCode);
    }
}

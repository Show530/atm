public class AccountOwner {
    private String salutation;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private long phoneNumber;
    private MailingAddress mailingAddress;

    public AccountOwner(String salutation,
                        String firstName,
                        String lastName,
                        String emailAddress,
                        long phoneNumber,
                        MailingAddress mailingAddress) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;
    }

    public String getName(int format) {
        if (format == 2) {
            return getSalutation() + ". " + getLastName();
        }
        else if (format == 3) {
            return getLastName() + ", " + getFirstName();
        }
        else {
            return getFirstName() + " " + getLastName();
        }
    }


    public String getFormattedPhoneNumber() {
        if(getPhoneNumber() < 0) {
            return "N/A";
        }
        else {
            String phoneString = String.valueOf(getPhoneNumber());
            return "(" + phoneString.substring(0,3) + ") " + phoneString.substring(3,6) + "-" + phoneString.substring(6);
        }
    }

    public String validateSalutation(String salutation) {
        if (salutation == null  || salutation.length() == 0 ) {
            return "null";
        }
        else {
            return salutation;
        }
    }

    public String validateEmailAddress(String emailAddress) {
        if (emailAddress.length() < 7 || emailAddress.length() > 254 || !emailAddress.contains("@") || !emailAddress.contains(".")) {
            return null;
        }
        else {
            return emailAddress;
        }
    }

    public long validatePhoneNumber(long phoneNumber) {
        String phoneString = String.valueOf(phoneNumber);
        if (phoneString.length() == 10) {
            return phoneNumber;
        }
        else {
            return 0L;
        }
    }

    public java.lang.String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = validateSalutation(salutation);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = validateEmailAddress(emailAddress);
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = validatePhoneNumber(phoneNumber);
    }

    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(MailingAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}

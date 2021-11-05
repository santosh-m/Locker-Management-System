package model;

import lombok.Getter;

@Getter
public abstract class LockerOperator {

    private final ContactDetails contactDetails;

    public LockerOperator(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }


    @Override
    public String toString() {
        return "LockerOperator{" +
                "contactDetails=" + contactDetails +
                '}';
    }

}

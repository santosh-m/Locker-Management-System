package service;

import model.Buyer;
import model.LockerOperator;
import model.Slot;

public class NotificationService {

    public void notifyUser(LockerOperator lockerOperator, String otp, Slot slot) {
        //TODO
        System.out.println("Notifying "+lockerOperator.getContactDetails() +" otp : "+otp) ;
    }
}

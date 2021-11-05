package controller;

import model.Buyer;
import model.Locker;
import model.LockerItem;
import model.Slot;
import service.LockerService;
import service.NotificationService;
import service.OtpService;


public class OrderController {

    LockerService lockerService;
    OtpService otpService;
    NotificationService notificationService;

    public OrderController(LockerService lockerService, OtpService otpService, NotificationService notificationService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.notificationService = notificationService;
    }

    public Slot allocateSlot(Buyer buyer, LockerItem lockerItem){
        Slot slot = lockerService.allocateSlotFromLocker(lockerItem);
        String otp = otpService.generateOtp();
        //Notify buyer that package places in slot/locker along with otp
        notificationService.notifyUser(buyer, otp, slot);
        return slot;
    }
}

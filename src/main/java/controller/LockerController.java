package controller;

import lombok.NonNull;
import model.Locker;
import model.Size;
import model.Slot;
import service.LockerService;
import service.OtpService;

public class LockerController {

    private final LockerService lockerService;
    private final OtpService otpService;

    public LockerController(@NonNull LockerService lockerService, @NonNull OtpService otpService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
    }

    public Locker createLocker(@NonNull String lockerId){
        return lockerService.createLocker(lockerId);
    }

    public Slot createSlotInLocker(Locker locker, Size slotSize){
        return lockerService.createSlotInLocker(locker, slotSize);
    }

    public void openAndUnAssignSlot(@NonNull Slot slot, @NonNull String otp){
        otpService.validateOtp(slot, otp);
        lockerService.unAssignSlot(slot);
    }


}

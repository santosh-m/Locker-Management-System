package service;

import model.Slot;
import repository.SlotOtpMappingRepository;

public class OtpService {

    private final SlotOtpMappingRepository slotOtpMappingRepository;

    public OtpService(SlotOtpMappingRepository slotOtpRepository) {
        this.slotOtpMappingRepository = slotOtpRepository;
    }

    public boolean validateOtp(Slot slot, String otp) {
         String savedOtp = slotOtpMappingRepository.getOtp(slot.getSlotId());
        return savedOtp != null && savedOtp.equals(otp);
    }

    public String generateOtp() {
        //TODO
        return "ABC";
    }
}

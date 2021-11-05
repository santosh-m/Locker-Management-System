package repository;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class SlotOtpMappingRepository implements ISlotOtpMappingRepository{

    private final Map<String, String> slotOtpMap;

    public SlotOtpMappingRepository() {
        this.slotOtpMap = new HashMap<>();
    }

    @Override
    public void addOtp(@NonNull String slotId, @NonNull String otp) {
        slotOtpMap.put(slotId, otp);
    }

    @Override
    public String getOtp(@NonNull String slotId) {
        return slotOtpMap.get(slotId);
    }
}

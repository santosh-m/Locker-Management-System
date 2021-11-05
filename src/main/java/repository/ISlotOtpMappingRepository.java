package repository;

import lombok.NonNull;

public interface ISlotOtpMappingRepository {

    void addOtp(@NonNull String slotId, @NonNull String otp);

    String getOtp(@NonNull String slotId);

}

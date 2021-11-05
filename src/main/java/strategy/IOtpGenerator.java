package strategy;

import lombok.NonNull;

public interface IOtpGenerator {

    @NonNull
    String generateOtp();
}

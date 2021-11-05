package repository;

import lombok.NonNull;
import model.Locker;
import model.Slot;

import java.util.List;

public interface ILockerRepository {

    @NonNull
    public Locker createLocker(@NonNull String lockerId);

    @NonNull
    public List<Slot> getAvailableSlots();
}

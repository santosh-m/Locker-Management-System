package repository;

import exception.LockerAlreadyExistsException;
import lombok.NonNull;
import model.Locker;
import model.Slot;

import java.util.ArrayList;
import java.util.List;

public class LockerRepository implements ILockerRepository{

    private final List<Locker> lockers;

    public LockerRepository() {
        this.lockers = new ArrayList<>();
    }

    @Override
    public @NonNull Locker createLocker(@NonNull String lockerId) {
        if(findByLockerId(lockerId) != null){
            throw new LockerAlreadyExistsException();
        }

        final Locker newLocker = new Locker(lockerId);
        lockers.add(newLocker);
        return newLocker;
    }


    @Override
    public @NonNull List<Slot> getAvailableSlots() {
        List<Slot> availableSlots = new ArrayList<>();
        for(Locker locker : lockers){
            availableSlots.addAll(locker.getAvailableSlotsInLocker());
        }
        return availableSlots;
    }


    private Locker findByLockerId(String lockerId) {
        for(Locker locker : this.lockers){
            if(locker.getId().equals(lockerId)){
                return locker;
            }
        }
        return null;
    }
}

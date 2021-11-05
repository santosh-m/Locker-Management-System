package strategy;

import lombok.NonNull;
import model.LockerItem;
import model.Slot;

import java.util.List;

public interface ISlotFilteringStrategy {

    @NonNull
    List<Slot> filterSlots(List<Slot> slots, LockerItem lockerItem);
}

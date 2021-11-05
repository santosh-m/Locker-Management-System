package strategy;

import lombok.NonNull;
import model.LockerItem;
import model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class SlotFilteringStrategySizeBased implements ISlotFilteringStrategy{

    @Override
    public @NonNull List<Slot> filterSlots(List<Slot> slots, LockerItem lockerItem) {

        return slots.stream().filter(slot -> slot.getSize().canAccomodate(lockerItem.getSize()))
                .collect(Collectors.toList());
    }
}

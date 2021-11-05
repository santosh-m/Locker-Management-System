package strategy;

import model.Slot;

import java.util.List;

public interface ISlotAssignmentStrategy<I> {

    Slot selectSlot(List<Slot> slots, I genericStrategy);
}

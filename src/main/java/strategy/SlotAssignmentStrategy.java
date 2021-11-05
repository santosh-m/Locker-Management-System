package strategy;

import model.GenericAssignmentStrategy;
import model.Slot;

import java.util.List;

public class SlotAssignmentStrategy implements ISlotAssignmentStrategy<GenericAssignmentStrategy>{

    @Override
    public Slot selectSlot(List<Slot> slots, GenericAssignmentStrategy genericAssignmentStrategy) {
        if(genericAssignmentStrategy.isPriorityCustomer()){
            //TODO select specific slot based on genericAssignmentStrategy/priority customers
        }

        //TODO returns random slot
        return slots.get(0);
    }
}

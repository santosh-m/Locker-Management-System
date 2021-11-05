package model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Locker {

    private final String id;
    private final List<Slot> slots;

    public Locker(String id) {
        this.id = id;
        this.slots = new ArrayList<>();
    }

    //Add slot into a locker
    public void addSlot(@NonNull final Slot newSlot){
        slots.add(newSlot);
    }

    //Get available slots in a locker
    @NonNull
    public List<Slot> getAvailableSlotsInLocker(){
        List<Slot> freeSlots = new ArrayList<>();
        for (Slot slot : this.slots){
            if(slot.isSlotAvailable()){
                freeSlots.add(slot);
            }
        }
        return freeSlots;
    }


}

package model;

import exception.SlotIsNotEmptyException;
import lombok.Getter;
import lombok.NonNull;

import java.util.Date;

@Getter
public class Slot {

    private final String slotId;
    private final Size size;

    private final Locker locker;

    private LockerItem currentLockerItem;
    private Date assignmentDate;

    public Slot(String slotId, Size size, Locker locker) {
        this.slotId = slotId;
        this.size = size;
        this.locker = locker;
        this.currentLockerItem = null;
        this.assignmentDate = null;
    }

    //Assign Package
    public void assignPackageToSlot(@NonNull final LockerItem lockerItem){
        if(this.currentLockerItem != null){
            throw new SlotIsNotEmptyException("Slot already has a package");
        }
        this.assignmentDate = new Date();
        this.currentLockerItem = lockerItem;
    }

    //De-Assign Package
    public void deAssignPackageFromSlot(){
        this.currentLockerItem = null;
    }

    public boolean isSlotAvailable(){
        return this.currentLockerItem == null;
    }

}


/*

** Locker **
[  s1   s2  ]
[  s3   s4  ]
[           ]
[           ]

 */
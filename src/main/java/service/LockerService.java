package service;

import lombok.NonNull;
import model.*;
import repository.ILockerRepository;
import repository.ITransactionRepository;
import strategy.ISlotAssignmentStrategy;
import strategy.ISlotFilteringStrategy;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class LockerService {

    private final ILockerRepository iLockerRepository;
    private final ISlotAssignmentStrategy slotAssignmentStrategy;
    private final ISlotFilteringStrategy slotFilteringStrategy;
    private final ITransactionRepository transactionRepository;
    private final CustomerService customerService;

    public LockerService(ILockerRepository iLockerRepository, ISlotAssignmentStrategy iSlotAssignmentStrategy,
                         ISlotFilteringStrategy iSlotFilteringStrategy,
                         ITransactionRepository iTransactionRepository,
                         CustomerService customerService) {
        this.iLockerRepository = iLockerRepository;
        this.slotAssignmentStrategy = iSlotAssignmentStrategy;
        this.slotFilteringStrategy = iSlotFilteringStrategy;
        this.transactionRepository = iTransactionRepository;
        this.customerService = customerService;
    }

    public Locker createLocker(String lockerId) {
        return iLockerRepository.createLocker(lockerId);
    }

    public Slot createSlotInLocker(Locker locker, Size slotSize) {
        String slotId = UUID.randomUUID().toString();
        Slot slot = new Slot(slotId, slotSize, locker);
        locker.addSlot(slot);
        return slot;
    }

    public Slot allocateSlotFromLocker(@NonNull LockerItem lockerItem){
        List<Slot> availableSlots = iLockerRepository.getAvailableSlots();
        List<Slot> filteredSlots = slotFilteringStrategy.filterSlots(availableSlots, lockerItem);

        GenericAssignmentStrategy assignmentStrategy = new GenericAssignmentStrategy();
        assignmentStrategy.setPriorityCustomer(customerService.isPriorityCustomer());

        Slot selectedSlot = slotAssignmentStrategy.selectSlot(filteredSlots, assignmentStrategy);
        selectedSlot.assignPackageToSlot(lockerItem);

        //Log transaction into Trx Repo
        Transaction transaction = new Transaction();
        transaction.setEventType(EventType.INSERT_INTO_LOCKER_SLOT);
        transaction.setSlotId(selectedSlot.getSlotId());
        transaction.setStatus(TransactionStatus.IN_PROGRESS);
        transaction.setTransactionDate(new Date());
        transactionRepository.saveTransaction(transaction);

        return selectedSlot;
    }

    public void unAssignSlot(Slot slot) {
        slot.deAssignPackageFromSlot();

        //Log transaction into Trx Repo
        Transaction transaction = new Transaction();
        transaction.setEventType(EventType.REMOVE_FROM_LOCKER_SLOT);
        transaction.setSlotId(slot.getSlotId());
        transaction.setStatus(TransactionStatus.COMPLETE);
        transaction.setTransactionDate(new Date());
        transactionRepository.saveTransaction(transaction);

    }

    public List<Slot> getAvailableSlots(){
        return iLockerRepository.getAvailableSlots();
    }


}

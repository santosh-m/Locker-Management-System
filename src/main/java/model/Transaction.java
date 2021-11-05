package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Transaction {

    private String slotId;
    private EventType eventType;
    private TransactionStatus status;
    private Date transactionDate;

}


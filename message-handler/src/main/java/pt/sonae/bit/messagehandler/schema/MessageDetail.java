package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
public class MessageDetail {

    @JsonProperty("MessageSequenceNumber")
    private String messageSequenceNumber;
    @JsonProperty("BusinessObjectID")
    private String businessObjectID;
    @JsonProperty("MessageType")
    private String messageType;
    @JsonProperty("TransactionTime")
    private String transactionTime;

}
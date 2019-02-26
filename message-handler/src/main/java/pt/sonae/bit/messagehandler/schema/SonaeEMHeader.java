package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "MessageSequenceNumber",
    "BusinessObjectID",
    "MessageType"
})
public class SonaeEMHeader {

    @JsonProperty("MessageSequenceNumber")
    private String messageSequenceNumber;
    @JsonProperty("BusinessObjectID")
    private String businessObjectID;
    @JsonProperty("MessageType")
    private String messageType;

   }
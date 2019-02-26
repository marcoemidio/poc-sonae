package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
public class DocLifeCycle {

    @JsonProperty("InternalData")
    InternalData internalData;
    @JsonProperty("EInvoice")
    EInvoice eInvoice;
    @JsonProperty("Status")
    Status status;
}
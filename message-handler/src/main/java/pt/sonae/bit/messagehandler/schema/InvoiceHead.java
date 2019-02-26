package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "InvoiceInternalID",
    "RevisionDocNumber",
    "InvoiceType"
})
public class InvoiceHead {
    
    @JsonProperty("InvoiceInternalID")
    private String invoiceInternalID;
    @JsonProperty("RevisionDocNumber")
    private String revisionDocNumber;
    @JsonProperty("InvoiceType")
    private String invoiceType;
}
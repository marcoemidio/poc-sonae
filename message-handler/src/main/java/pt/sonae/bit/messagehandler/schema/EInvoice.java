package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "InvoiceHead",
    "InvoiceReferences",
    "InvoiceDate",
    "Supplier",
    "InvoiceTo",
    "InvoiceTotal"
})
public class EInvoice {

    @JsonProperty("InvoiceHead")
    InvoiceHead invoiceHead;
    @JsonProperty("InvoiceReferences")
    InvoiceReferences invoiceReferences;
    @JsonProperty("InvoiceDate")
    private String invoiceDate;
    @JsonProperty("Supplier")
    Supplier supplier;
    @JsonProperty("InvoiceTo")
    InvoiceTo invoiceTo;
    @JsonProperty("InvoiceTotal")
    InvoiceTotal invoiceTotal;
}
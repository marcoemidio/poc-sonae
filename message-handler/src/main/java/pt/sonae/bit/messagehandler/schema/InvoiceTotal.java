package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "NetPaymentTotal"
})
public class InvoiceTotal {

    @JsonProperty("NetPaymentTotal")
    private String netPaymentTotal;
}
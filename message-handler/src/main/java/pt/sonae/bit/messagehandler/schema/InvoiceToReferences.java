package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "BuyersVATNumber"
})
public class InvoiceToReferences {
    
    @JsonProperty("BuyersVATNumber")
    private String buyersVATNumber;

}
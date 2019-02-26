package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "SupplierReferences"
})
public class Supplier {

    @JsonProperty("SupplierReferences")
    SupplierReferences supplierReferences;

}
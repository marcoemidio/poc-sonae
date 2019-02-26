package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "aid",
    "docid"
})
public class ID {

    @JsonProperty("aid")
    private String aid;
    @JsonProperty("docid")
    private String docid;
}
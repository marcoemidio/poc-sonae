package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "Document",
    "Origin",
    "UniqueMsgKey",
    "ReceptionDate"
})
public class General {

    @JsonProperty("Document")
    Document documentObject;
    @JsonProperty("Origin")
    private String origin;
    @JsonProperty("UniqueMsgKey")
    private String uniqueMsgKey;
    @JsonProperty("ReceptionDate")
    private String receptionDate;
}
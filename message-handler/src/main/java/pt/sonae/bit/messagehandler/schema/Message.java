package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "Identification",
    "Type",
    "Text",
    "CreationDate"
})
public class Message {

    @JsonProperty("Identification")
    private String identification;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Text")
    private String text;
    @JsonProperty("CreationDate")
    private String creationDate;

}
package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
public class RoutingInfo {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Value")
    private String value;
}
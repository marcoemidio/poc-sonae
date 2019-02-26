package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
public class TrackingInfo {

    @JsonProperty("Step")
    private String step;
    @JsonProperty("MessageDetails")
    MessageDetails messageDetails;

}
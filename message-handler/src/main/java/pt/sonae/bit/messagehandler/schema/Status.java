package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
@JsonPropertyOrder({
    "DocumentStatus",
    "MsgExchange"
})
public class Status {

    @JsonProperty("DocumentStatus")
    private String documentStatus;
    @JsonProperty("MsgExchange")
    MsgExchange msgExchange;

}
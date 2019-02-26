package pt.sonae.bit.messagehandler.schema;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
public class MessageDetails {

    @JsonProperty("MessageDetail")
    private List<MessageDetail> messageDetail;

}


package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
public class SonaeEnterpriseMessage {

    @JsonProperty("SonaeEMHeader")
    SonaeEMHeader sonaeEMHeader;
    @JsonProperty("MessageData")
    MessageData messageData;

}
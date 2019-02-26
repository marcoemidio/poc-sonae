package pt.sonae.bit.messagehandler.schema;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
public class SonaeEnterpriseMessageBundle {
    
    @JsonProperty("SonaeEMBundleHeader")
    SonaeEMBundleHeader sonaeEMBundleHeader;
    @JsonProperty("SonaeEnterpriseMessage")
    List<SonaeEnterpriseMessage> sonaeEnterpriseMessage;

}
package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
public class SonaeEMBundleHeader {

    @JsonProperty("ExecutionContextID")
    String executionContextID;
    @JsonProperty("SequencingTrackingFlag")
    String sequencingTrackingFlag; 
    @JsonProperty("DataFlow")
    String dataFlow;
    @JsonProperty("PublishTime")
    String publishTime;   
    @JsonProperty("Source")
    Source source;   
    @JsonProperty("RoutingInfo")
    RoutingInfo routingInfo;  
    @JsonProperty("TrackingInfo")
    TrackingInfo trackingInfo;
}
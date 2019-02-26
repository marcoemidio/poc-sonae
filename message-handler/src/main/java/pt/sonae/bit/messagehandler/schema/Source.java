package pt.sonae.bit.messagehandler.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Marco Emidio
 */
@Data
public class Source {

    @JsonProperty("Name")
    private String name;

}
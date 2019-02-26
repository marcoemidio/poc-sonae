package pt.sonae.bit.messagehandler.schema;

import java.util.List;

import lombok.Data;

@Data
public class ResponseObject {

    private String status;
    private String message;
	private List<SonaeEnterpriseMessage> data;

	public ResponseObject(String status,  List<SonaeEnterpriseMessage> data) {
		this.status = status;
		this.data = data;
    }
    
    public ResponseObject(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
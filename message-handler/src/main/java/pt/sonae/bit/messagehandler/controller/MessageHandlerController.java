package pt.sonae.bit.messagehandler.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.opentracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import pt.sonae.bit.messagehandler.schema.ResponseObject;
import pt.sonae.bit.messagehandler.schema.SonaeEnterpriseMessage;
import pt.sonae.bit.messagehandler.schema.SonaeEnterpriseMessageBundle;
import pt.sonae.bit.messagehandler.producer.KafkaProducer;

/**
 * @author Marco Emidio
 */
@RestController
@Slf4j
public class MessageHandlerController {
	
	@Autowired
    private Tracer tracer;

    @Autowired
    private KafkaProducer producer;
    
    /**
     * Receive a SonaeEnterpriseMessageBundle request
     *
     * @param SonaeEnterpriseMessageBundle 
     * @return the EmailDeployment 
     */
    @RequestMapping(value="/receiveSonaeMessage", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> receiveSonaeMessageRequest(@RequestBody SonaeEnterpriseMessageBundle request) {
        
        log.info("received request from '{}'", request.getSonaeEMBundleHeader().getExecutionContextID());

        String uuid = UUID.randomUUID().toString();

        //add rangeType uuid to headers (create a method for this task with parameters to setbaggaitems and tags)
        tracer.activeSpan().setOperationName("HTTP POST /receiveSonaeMessage");
        tracer.activeSpan().setBaggageItem("uuid", uuid);
        tracer.activeSpan().setTag("uuid", uuid);
        tracer.activeSpan().setBaggageItem("context-id", request.getSonaeEMBundleHeader().getExecutionContextID());
        tracer.activeSpan().setTag("context-id", request.getSonaeEMBundleHeader().getExecutionContextID());
        tracer.activeSpan().setBaggageItem("source-name", request.getSonaeEMBundleHeader().getSource().getName());
        tracer.activeSpan().setTag("source-name", request.getSonaeEMBundleHeader().getSource().getName());

        try {
            
            for (SonaeEnterpriseMessage msg : request.getSonaeEnterpriseMessage()) {
                tracer.activeSpan().setBaggageItem("unique-msg-key", msg.getMessageData().getDocLifeCycle().getInternalData().getGeneral().getUniqueMsgKey());
                producer.sendJsonRequest(msg.getMessageData().getDocLifeCycle());
            }
            
            return new ResponseEntity<>(new ResponseObject("sucess", request.getSonaeEnterpriseMessage()), HttpStatus.CREATED);

        } catch (Exception ex) {
            
            log.error("Error sending message to kafka with contextId = '{}'", request.getSonaeEMBundleHeader().getExecutionContextID());
            
            return new ResponseEntity<>(new ResponseObject("error", "Error sending message to kafka with contextId = " 
                + request.getSonaeEMBundleHeader().getExecutionContextID()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
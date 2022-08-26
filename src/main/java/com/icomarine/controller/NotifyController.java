package com.icomarine.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.icomarine.request.NotifyRequest;
import com.sendgrid.*;


@RestController  
public class NotifyController {



	  @PostMapping("/notify")  
	  public ResponseEntity<Void> createNote(@RequestBody NotifyRequest notifyReq) {

		    String SK="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";
		    
		    
		    Email from = new Email(notifyReq.getFrom());
		    String subject = notifyReq.getSubject();
		    Email to = new Email(notifyReq.getTo());
		    Content content = new Content(notifyReq.getContentType(), notifyReq.getContent());
		    
		    Mail mail = new Mail(from, subject, to, content);

//		    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		    
		    SendGrid sg = new SendGrid(SK);
		    		
		    Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      ex.printStackTrace();
		    }
		
	  

	    return ResponseEntity.ok().build();
	  }

	

}

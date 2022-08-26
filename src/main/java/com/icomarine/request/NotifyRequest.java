package com.icomarine.request;

import java.sql.Timestamp;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;

import lombok.Data;

@Data
public class NotifyRequest {

	private String from ; 
	private String subject;
	private String to;   
	private String content ;
	private String contentType ; //"text/plain"
	private String key ;  //temp

}

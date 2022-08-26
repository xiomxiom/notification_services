package com.icomarine.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Table;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationQueue implements Serializable  {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
	   private String to;
	   private String from;
	   private String title;
	   private String content;
	   private String contentType;
	   long createdDate;
	   int createdBy;
	   String status; //new/sent
	   long sendDate;
	  
	
}

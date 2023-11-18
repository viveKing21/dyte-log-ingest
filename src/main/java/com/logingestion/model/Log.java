package com.logingestion.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Log {
	public static enum Level{
		ERROR,
		INFO,
		WARN
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Enumerated(EnumType.STRING)
	Level level;
	
	String message;
	
	@Column(unique = true)
	String resourceId;
	
	LocalDateTime timestamp = LocalDateTime.now();
	
	String traceId;
	String spanId;
	String commit;
	
	@Embedded
	MetaData metaData;
}

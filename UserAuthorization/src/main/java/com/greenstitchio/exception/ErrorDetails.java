package com.greenstitchio.exception;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String ErrDetails;
}

package me.anvarisy.kodegiri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private boolean status;
	// private LocalDateTime timeStamp;
	private String error;
	private int code;
}

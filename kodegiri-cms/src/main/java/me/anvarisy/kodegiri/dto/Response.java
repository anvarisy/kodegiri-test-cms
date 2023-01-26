package me.anvarisy.kodegiri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// @NoArgsConstructor
public class Response<T> {
    @JsonProperty( value = "status", access = JsonProperty.Access.READ_ONLY)
	private boolean status;
	
	@JsonProperty( value = "code", access = JsonProperty.Access.READ_ONLY)
	private int code;
	
	@JsonProperty( value = "message", access = JsonProperty.Access.READ_ONLY)
	private String message;
	
	@JsonProperty( value = "data", access = JsonProperty.Access.READ_ONLY)
	private T data;
    
}

package me.anvarisy.kodegiri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @JsonProperty( value = "username", access = JsonProperty.Access.WRITE_ONLY)
    private String username;
    
    @JsonProperty( value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}

package me.anvarisy.kodegiri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    @JsonProperty( value = "company_id", access = JsonProperty.Access.WRITE_ONLY)
    private String companyId;
    
    @JsonProperty( value = "company_name", access = JsonProperty.Access.WRITE_ONLY)
    private String companyName;
}

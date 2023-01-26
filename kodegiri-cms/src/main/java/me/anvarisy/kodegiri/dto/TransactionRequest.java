package me.anvarisy.kodegiri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    @JsonProperty( value = "company_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer companyId;
    
    @JsonProperty( value = "product_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer productId;

    @JsonProperty( value = "qty", access = JsonProperty.Access.WRITE_ONLY)
    private Integer qty;
}

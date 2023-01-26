package me.anvarisy.kodegiri.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="companies")
public class Company {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
    @JsonProperty( value = "id", access = JsonProperty.Access.READ_ONLY)
    @Id
    private int id;

    @Column(unique=true)
    @JsonProperty( value = "company_id", access = JsonProperty.Access.READ_ONLY)
    private String companyId;

    @JsonProperty( value = "company_name", access = JsonProperty.Access.READ_ONLY)
    private String companyName;
}

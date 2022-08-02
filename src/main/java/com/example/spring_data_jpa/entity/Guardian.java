package com.example.spring_data_jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@AttributeOverrides(
        {
                @AttributeOverride(
                        name = "name",
                        column = @Column(name = "guardian_name")
                ),
                @AttributeOverride(
                        name = "number",
                        column = @Column(name = "guardian_number")
                ),
                @AttributeOverride(
                        name = "email",
                        column = @Column(name = "guardian_email")
                )
        }
)
public class Guardian {
    private String name;
    private String number;
    private String email;
}

package com.yeab.springdatajpa.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides(
        {@AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name ="phone",
                column = @Column(name = "guardian_phone")
        ),
         @AttributeOverride(
                 name = "name",
                 column = @Column(name = "guardian_name")
         )
        }

)
public class Guardian {
    private String email;
    private String name;
    private String phone;
}

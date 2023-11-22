package com.eskcti.mscompra.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Order {
    private String name;
    private Long product;
    private BigDecimal value;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date purchaseDate;
    private String cpfCustomer;
    private String zipCode;
}

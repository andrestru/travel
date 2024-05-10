package com.ias.testTecnico.domain.model.editreserve;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReserveEntity {

    private EditReserveResponse data;
    private String Status;
    private String Message;

}

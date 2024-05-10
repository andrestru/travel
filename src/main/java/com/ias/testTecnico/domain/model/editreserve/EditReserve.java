package com.ias.testTecnico.domain.model.editreserve;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditReserve {

    private String id_travel;
    private String date;

}

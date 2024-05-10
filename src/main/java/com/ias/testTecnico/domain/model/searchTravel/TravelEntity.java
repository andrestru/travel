package com.ias.testTecnico.domain.model.searchTravel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelEntity {

    private TravelResponse data;
    private String Status;
    private String Message;

}

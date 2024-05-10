package com.ias.testTecnico.domain.model.searchTravel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelResponse {

    private String id;
    private String date;
    private String origin;
    private String destination;

}

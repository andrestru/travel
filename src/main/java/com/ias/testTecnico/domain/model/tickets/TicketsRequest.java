package com.ias.testTecnico.domain.model.tickets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketsRequest {

    private String cc;
    private String name;
    private String id_travel;

}

package com.ias.testTecnico.domain.model.tickets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketsResponse {

    private String id_ticket;
    private String id_reserve;
    private String name;
    private String date;
    private String origin;
    private String destination;


}

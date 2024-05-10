package com.ias.testTecnico.domain.model.tickets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketEntity {

    private TicketsResponse data;
    private String Status;
    private String Message;

}

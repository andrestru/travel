package com.ias.testTecnico.domain.model.repository;

import com.ias.testTecnico.domain.model.tickets.TicketsResponse;
import com.ias.testTecnico.domain.model.tickets.util.Ticket;
import com.ias.testTecnico.infrastructure.drivenadapters.ticketAdapters.mapper.TicketData;

import java.util.List;

public interface TicketRepository {

    TicketData searchTicket(String id);
    TicketsResponse createTicket(TicketData ticket);

}

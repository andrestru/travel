package com.ias.testTecnico.domain.model.repository;

import com.ias.testTecnico.domain.model.editreserve.EditReserveResponse;
import com.ias.testTecnico.infrastructure.drivenadapters.ticketAdapters.mapper.TicketData;

public interface ReserveRepository {

    TicketData searchReserve(String id);
    EditReserveResponse EditReserve(TicketData ticket);

}

package com.ias.testTecnico.domain.usecase.ticketUseCase;

import com.ias.testTecnico.domain.model.repository.TicketRepository;
import com.ias.testTecnico.domain.model.tickets.TicketEntity;
import com.ias.testTecnico.domain.model.tickets.TicketsRequest;
import com.ias.testTecnico.domain.model.tickets.TicketsResponse;
import com.ias.testTecnico.infrastructure.drivenadapters.ticketAdapters.mapper.TicketData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class TicketUseCaseTest {

    @Mock
    private TicketUseCase ticketUseCase;

    @Mock
    private TicketRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ticketUseCase = new TicketUseCase(repository);
    }

    @Test
    void createTicket() {
        //AAA
        TicketData data = new TicketData();
        TicketEntity entity = new TicketEntity(new TicketsResponse(), "SUCCESS",
                "Reserve created successfully");
        TicketsResponse response = new TicketsResponse();
        TicketsRequest request = new TicketsRequest();

        request.setCc("123456789");
        request.setId_travel("1");
        request.setName("Juan");
        //Arrange
        //Act
        when(repository.searchTicket(anyString())).thenReturn(data);
        when(repository.createTicket(data)).thenReturn(response);
        //Assert

        assertEquals(entity, ticketUseCase.createTicket(request));
    }

}
package com.ias.testTecnico.domain.usecase.reserveUseCase;

import com.ias.testTecnico.domain.model.editreserve.EditReserve;
import com.ias.testTecnico.domain.model.editreserve.EditReserveResponse;
import com.ias.testTecnico.domain.model.editreserve.ReserveEntity;
import com.ias.testTecnico.domain.model.repository.ReserveRepository;
import com.ias.testTecnico.infrastructure.drivenadapters.ticketAdapters.mapper.TicketData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ReserveUseCaseTest {

    @Mock
    private ReserveUseCase reserveUseCase;

    @Mock
    private ReserveRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reserveUseCase = new ReserveUseCase(repository);
    }

    @Test
    void editReserve() {

        TicketData data = new TicketData();
        EditReserve request = new EditReserve();
        request.setId_travel("1");
        request.setDate("2021-10-10");

        EditReserveResponse response = new EditReserveResponse();

        ReserveEntity entity = new ReserveEntity(response, "SUCCESS",
                "Reserve edited successfully");

        when(repository.searchReserve(anyString())).thenReturn(data);
        when(repository.EditReserve(data)).thenReturn(response);

        assertEquals(entity, reserveUseCase.editReserve(request));

    }

}
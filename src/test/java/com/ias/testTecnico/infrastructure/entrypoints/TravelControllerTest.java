package com.ias.testTecnico.infrastructure.entrypoints;

import com.ias.testTecnico.domain.usecase.TravelUseCase.SearchTravelUseCase;
import com.ias.testTecnico.domain.usecase.reserveUseCase.ReserveUseCase;
import com.ias.testTecnico.domain.usecase.ticketUseCase.TicketUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TravelController.class)
@AutoConfigureMockMvc
@AutoConfigureWebMvc
class TravelControllerTest {

    @MockBean
    private TravelController travelController;

    @MockBean
    private TicketUseCase ticketUseCase;

    @MockBean
    private ReserveUseCase reserveUseCase;

    @MockBean
    private SearchTravelUseCase travelUseCase;

    MockMvc mockMvc;

    @Test
    void health() {
        assertNotNull(travelController.health());
    }

    @Test
    void search(){

        RequestBuilder requestBuilder = RequestBui.get("/airline/travel");

        mockMvc.perform()
        .andExpect(status().isOk())
        .andExpect(content().string("Service is running"));
    }

}
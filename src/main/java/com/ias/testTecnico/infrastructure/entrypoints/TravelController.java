package com.ias.testTecnico.infrastructure.entrypoints;

import com.ias.testTecnico.domain.model.editreserve.EditReserve;
import com.ias.testTecnico.domain.model.editreserve.ReserveEntity;
import com.ias.testTecnico.domain.model.searchTravel.TravelEntity;
import com.ias.testTecnico.domain.model.tickets.TicketEntity;
import com.ias.testTecnico.domain.model.tickets.TicketsRequest;
import com.ias.testTecnico.domain.usecase.TravelUseCase.SearchTravelUseCase;
import com.ias.testTecnico.domain.usecase.reserveUseCase.ReserveUseCase;
import com.ias.testTecnico.domain.usecase.ticketUseCase.TicketUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class TravelController {

    private final SearchTravelUseCase travelUseCase;
    private final TicketUseCase ticketUseCase;
    private final ReserveUseCase reserveUseCase;

    public TravelController(SearchTravelUseCase travelUseCase, TicketUseCase ticketUseCase, ReserveUseCase reserveUseCase) {
        this.travelUseCase = travelUseCase;
        this.ticketUseCase = ticketUseCase;
        this.reserveUseCase = reserveUseCase;
    }

    @GetMapping("/airline/health")
    public ResponseEntity<TravelEntity> health() {
        return ResponseEntity.ok(new TravelEntity(null, "SUCCESS", "Service is running"));
    }


    @GetMapping("/airline/travel")
    public ResponseEntity<TravelEntity> search(@RequestParam String id){
        TravelEntity entity = travelUseCase.search(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping("/airline/reserve")
    public ResponseEntity<TicketEntity> reserve(@RequestBody TicketsRequest request){
        TicketEntity entity = ticketUseCase.createTicket(request);
        return ResponseEntity.created(URI.create("/reserve")).body(entity);
    }

    @PutMapping("/airline/editReserve")
    public ResponseEntity<ReserveEntity> editReserve(@RequestBody EditReserve request){
        ReserveEntity entity = reserveUseCase.editReserve(request);
        return ResponseEntity.ok().body(entity);
    }
}

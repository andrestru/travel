package com.ias.testTecnico.config.usecaseconfig;

import com.ias.testTecnico.domain.model.repository.TicketRepository;
import com.ias.testTecnico.domain.model.repository.TravelRepository;
import com.ias.testTecnico.domain.usecase.TravelUseCase.SearchTravelUseCase;
import com.ias.testTecnico.domain.usecase.ticketUseCase.TicketUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public SearchTravelUseCase searchTravelUseCase(TravelRepository repository){
        return new SearchTravelUseCase(repository);
    }


    @Bean
    public TicketUseCase ticketUseCase(TicketRepository repository){
        return new TicketUseCase(repository);
    }

}

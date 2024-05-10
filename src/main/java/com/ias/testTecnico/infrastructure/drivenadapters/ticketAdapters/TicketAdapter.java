package com.ias.testTecnico.infrastructure.drivenadapters.ticketAdapters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.ias.testTecnico.domain.model.repository.TicketRepository;
import com.ias.testTecnico.domain.model.tickets.TicketsResponse;
import com.ias.testTecnico.domain.model.tickets.util.Ticket;
import com.ias.testTecnico.infrastructure.drivenadapters.ticketAdapters.mapper.TicketData;
import com.ias.testTecnico.infrastructure.drivenadapters.travelAdapters.mapper.Databaseconfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Log4j2
public class TicketAdapter implements TicketRepository {

    private final DynamoDBMapper dynamoDBMapper;
    private final DynamoDBMapperConfig dynamoDBMapperConfig;

    public TicketAdapter(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.dynamoDBMapperConfig = DynamoDBMapperConfig.builder()
                .withTableNameOverride(new DynamoDBMapperConfig.TableNameOverride("travel")).build();
    }

    @Override
    public TicketData searchTicket(String id) {

        log.info("Searching ticket with id: {}", id);

        TicketData ticket = dynamoDBMapper.load(TicketData.class, "TRAVEL#123", id, dynamoDBMapperConfig);

        if (ticket != null) {
            return TicketData.builder()
                    .pk(ticket.getPk())
                    .id(ticket.getId())
                    .date(ticket.getDate())
                    .destination(ticket.getDestination())
                    .origin(ticket.getOrigin())
                    .build();
        }

        return null;

    }

    @Override
    public TicketsResponse createTicket(TicketData ticket) {

        log.info("Creating ticket");

        dynamoDBMapper.save(ticket, dynamoDBMapperConfig);

        TicketsResponse response = TicketsResponse.builder()
                .id_ticket(ticket.getId_ticket())
                .id_reserve(ticket.getId_reserve())
                .name(ticket.getName())
                .date(ticket.getDate())
                .origin(ticket.getOrigin())
                .destination(ticket.getDestination())
                .build();

        return response;
    }
}

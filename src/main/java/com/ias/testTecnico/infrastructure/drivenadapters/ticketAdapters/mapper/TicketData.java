package com.ias.testTecnico.infrastructure.drivenadapters.ticketAdapters.mapper;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketData {

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "PK")
    private String pk;

    @DynamoDBRangeKey
    @DynamoDBAttribute(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "date")
    private String date;

    @DynamoDBAttribute(attributeName = "origin")
    private String origin;

    @DynamoDBAttribute(attributeName = "destination")
    private String destination;

    @DynamoDBAttribute(attributeName = "id_reserve")
    private String id_reserve;

    @DynamoDBAttribute(attributeName = "id_ticket")
    private String id_ticket;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "document")
    private String document;



}

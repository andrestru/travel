package com.ias.testTecnico.infrastructure.drivenadapters.travelAdapters.mapper;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Databaseconfig {

    public static void dynamo(DynamoDBMapper dynamoDBMapper, DynamoDBMapperConfig config){

        TravelData travelData = dynamoDBMapper.load(TravelData.class, "TRAVEL#123", "1", config);
        if(travelData == null){
            TravelData data = new TravelData();
            data.setPk("TRAVEL#123");
            data.setId("1");
            data.setDate("12/12/2021 12:00:00");
            data.setOrigin("Bogota");
            data.setDestination("Medellin");

            dynamoDBMapper.save(data, config);
            log.info("Data saved");
        }else {
            log.info("Data already exists");
        }


    }

}

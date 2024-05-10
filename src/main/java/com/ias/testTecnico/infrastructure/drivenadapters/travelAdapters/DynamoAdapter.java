package com.ias.testTecnico.infrastructure.drivenadapters.travelAdapters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.ias.testTecnico.domain.model.searchTravel.TravelResponse;
import com.ias.testTecnico.domain.model.repository.TravelRepository;
import com.ias.testTecnico.infrastructure.drivenadapters.travelAdapters.mapper.Databaseconfig;
import com.ias.testTecnico.infrastructure.drivenadapters.travelAdapters.mapper.TravelData;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
public class DynamoAdapter implements TravelRepository {

    private final DynamoDBMapper dynamoDBMapper;
    private final DynamoDBMapperConfig dynamoDBMapperConfig;

    public DynamoAdapter(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.dynamoDBMapperConfig = DynamoDBMapperConfig.builder()
                .withTableNameOverride(new DynamoDBMapperConfig.TableNameOverride("travel")).build();
        Databaseconfig.dynamo(this.dynamoDBMapper, this.dynamoDBMapperConfig);
    }

    @Override
    public TravelResponse searchTravel(String id) {
        log.info("Searching travel with id: {}", id);
        TravelData travelData = dynamoDBMapper.load(TravelData.class, "TRAVEL#123", id, dynamoDBMapperConfig);

        if (travelData != null) {
            return TravelResponse.builder()
                    .id(travelData.getId())
                    .date(travelData.getDate())
                    .origin(travelData.getOrigin())
                    .destination(travelData.getDestination())
                    .build();
        }
        return null;
    }
}

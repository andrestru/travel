package com.ias.testTecnico.domain.usecase.TravelUseCase;

import com.ias.testTecnico.domain.model.searchTravel.TravelEntity;
import com.ias.testTecnico.domain.model.searchTravel.TravelResponse;
import com.ias.testTecnico.domain.model.exceptions.BusinessExceptions;
import com.ias.testTecnico.domain.model.repository.TravelRepository;

public class SearchTravelUseCase {

    private final TravelRepository travelRepository;

    public SearchTravelUseCase(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public TravelEntity search(String id) {
        TravelResponse response = travelRepository.searchTravel(id);
        if (response == null){
            throw new BusinessExceptions("Travel not found");
        }
        return new TravelEntity(response, "SUCCESS", "Travel found successfully");
    }

}

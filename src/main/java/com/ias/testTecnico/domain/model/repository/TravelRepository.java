package com.ias.testTecnico.domain.model.repository;

import com.ias.testTecnico.domain.model.searchTravel.TravelResponse;

public interface TravelRepository {

    TravelResponse searchTravel(String id);

}

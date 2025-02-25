package com.buildingblocks.trajectory.infra.mongo.repositories;

import com.buildingblocks.trajectory.infra.mongo.entities.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IEventsRepository extends ReactiveMongoRepository<Event, String> {



}

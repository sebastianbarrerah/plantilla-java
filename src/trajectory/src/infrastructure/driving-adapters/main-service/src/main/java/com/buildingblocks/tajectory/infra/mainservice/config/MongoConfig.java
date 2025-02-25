package com.buildingblocks.tajectory.infra.mainservice.config;

import com.buildingblocks.trajectory.infra.mongo.adapters.MongoAdapter;
import com.buildingblocks.trajectory.infra.mongo.repositories.IEventsRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EntityScan(basePackages = "com.buildingblocks.trajectory.infra.mongo.entities")
@EnableReactiveMongoRepositories(basePackages = "com.buildingblocks.trajectory.infra.mongo.repositories")
public class MongoConfig {

@Bean
    public MongoAdapter mongoAdapter(IEventsRepository repository) {
        return new MongoAdapter(repository);
    }



}

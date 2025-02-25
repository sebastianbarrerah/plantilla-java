package com.buildingblocks.trajectory.infra.mongo.adapters;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingblocks.trajectory.infra.mongo.entities.Event;
import com.buildingblocks.trajectory.infra.mongo.repositories.IEventsRepository;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public class MongoAdapter implements IEventsRepositoryPort {

    private final IEventsRepository repository;

    public MongoAdapter(IEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> findAllAggregates() {
        return repository.findAll().map(Event::getDomainEvent);
    }

    @Override
    public Flux<DomainEvent> findEventsByAggregateId(String aggregateId) {
        return findAllAggregates().filter(event -> event.getAggregateRootId().equals(aggregateId));
    }

    @Override
    public void save(DomainEvent domainEvent) {
        repository.save(new Event(domainEvent)).subscribe();
    }
}

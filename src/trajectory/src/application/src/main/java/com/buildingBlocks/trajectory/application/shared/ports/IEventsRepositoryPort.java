package com.buildingBlocks.trajectory.application.shared.ports;

import com.buildingblocks.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventsRepositoryPort {
    Flux<DomainEvent> findEventsByAggregateId(String aggregateId);
    Flux<DomainEvent> findAllAggregates();
    void save(DomainEvent domainEvent);
}

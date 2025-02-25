package com.buildingBlocks.trajectory.application.getCards;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingblock.shared.application.IQueryUseCase;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.stream.Collectors;

public class GetCardsUseCase implements IQueryUseCase<Flux<GetCardsResponse>> {
    private final IEventsRepositoryPort repository;

    public GetCardsUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }


    @Override
    public Flux<GetCardsResponse> execute() {
        return repository
                .findAllAggregates()
                .collectList()
                .map(events -> events.stream().collect(Collectors.groupingBy(DomainEvent::getAggregateRootId)))
                .map(aggregates -> aggregates.entrySet().stream().map(entry -> {
                    entry.getValue().sort(Comparator.comparing(DomainEvent::getWhen));
                    return Cards.from(entry.getKey(), entry.getValue());
                }).toList())
                .map(tables -> tables.stream().map(cards -> new GetCardsResponse()).toList())
                .flatMapMany(Flux::fromIterable);
    };

}

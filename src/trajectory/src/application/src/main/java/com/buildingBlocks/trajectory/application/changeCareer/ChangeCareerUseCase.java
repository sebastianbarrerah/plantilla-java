package com.buildingBlocks.trajectory.application.changeCareer;

import com.buildingBlocks.trajectory.application.shared.ports.IEventsRepositoryPort;
import com.buildingBlocks.trajectory.domain.cards.Cards;
import com.buildingBlocks.trajectory.domain.cards.values.TypeEventEffectEnum;
import com.buildingBlocks.trajectory.domain.player.Player;
import com.buildingblock.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class ChangeCareerUseCase implements ICommandUseCase<ChangeCareerRequest, Mono<ChangeCareerResponse>> {

    private final IEventsRepositoryPort repository;

    public ChangeCareerUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<ChangeCareerResponse> execute(ChangeCareerRequest request) {
        Player player = new Player();
        Cards cards = new Cards();
        player.updateProfession(request.getNameProfession(), request.getEducationalLevel());
//        cards.cardApplied(request.getCardType(), request.getCardEffect());
//        cards.isRewarded(request.getCardType(), "Recompensa por cambiar de carrera", "PLAYER", 100);

        player.getUncommittedEvents().forEach(repository::save);
        player.markEventsAsCommitted();
//        cards.getUncommittedEvents().forEach(repository::save);
//        cards.markEventsAsCommitted();
        return Mono.just(new ChangeCareerResponse(player.getCareer().getName().getName(), player.getCareer().getEducationalLevel().getLevel()));
    }
}

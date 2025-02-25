package com.buildingblocks.tajectory.infra.mainservice.config;

import com.buildingBlocks.trajectory.application.assignCardToPlayer.AssignCardToPlayerUseCase;
import com.buildingBlocks.trajectory.application.buyProperty.BuyPropertyUseCase;
import com.buildingBlocks.trajectory.application.changeCareer.ChangeCareerUseCase;
import com.buildingBlocks.trajectory.application.discardCard.DiscardCardUseCase;
import com.buildingBlocks.trajectory.application.getCards.GetCardsUseCase;
import com.buildingBlocks.trajectory.application.getMarried.GetMarriedUseCase;
import com.buildingBlocks.trajectory.application.joinGame.JoinGameUseCase;
import com.buildingblocks.trajectory.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public AssignCardToPlayerUseCase assignCardtoPlayerUseCase(MongoAdapter adapter) {
        return new AssignCardToPlayerUseCase(adapter);
    }

    @Bean
    public BuyPropertyUseCase buyPropertyUseCase(MongoAdapter adapter) {
        return new BuyPropertyUseCase(adapter);
    }

    @Bean
    public ChangeCareerUseCase changeCareerUseCase(MongoAdapter adapter) {
        return new ChangeCareerUseCase(adapter);
    }

    @Bean
    public DiscardCardUseCase discardCardUseCase(MongoAdapter adapter) {
        return new DiscardCardUseCase(adapter);
    }

    @Bean
    public GetMarriedUseCase getMarriedUseCase(MongoAdapter adapter) {
        return new GetMarriedUseCase(adapter);
    }

    @Bean
    public JoinGameUseCase joinGameUseCase(MongoAdapter adapter) {
        return new JoinGameUseCase(adapter);
    }

    @Bean
    public GetCardsUseCase getCardsUseCase(MongoAdapter adapter) {
        return new GetCardsUseCase(adapter);
    }






}

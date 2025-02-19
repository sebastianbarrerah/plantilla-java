package com.buildingBlocks.trajectory.domain.cards;

import com.buildingBlocks.trajectory.domain.cards.entities.Decision;
import com.buildingBlocks.trajectory.domain.cards.entities.Reward;
import com.buildingBlocks.trajectory.domain.cards.events.CancelledEvent;
import com.buildingBlocks.trajectory.domain.cards.events.GroupImpact;
import com.buildingBlocks.trajectory.domain.cards.events.IsRewarded;
import com.buildingBlocks.trajectory.domain.cards.events.TakenDecision;
import com.buildingBlocks.trajectory.domain.player.values.StatePlayerEnum;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class CardsHandler extends DomainActionsContainer {

    public CardsHandler(Cards card) {
        add(handleCancelledEvent(card));
        add(handleGroupImpact(card));
        add(handleIsRewarded(card));
        add(handleTakenDecision(card));
    }

    private Consumer<DomainEvent> handleCancelledEvent(Cards card) {
        return event -> {
            if (event instanceof CancelledEvent cancelledEvent) {
                Object StateEvent = null;
                if (card.getState().equals(StateEvent.ACTIVE)) {
                    card.setState(StateEvent.CANCELLED);
                } else {
                    System.out.println("La tarjeta ya no está activa, no se puede cancelar.");
                }
            }
        };
    }

    private Consumer<DomainEvent> handleGroupImpact(Cards card) {
        return event -> {
            if (event instanceof GroupImpact groupImpact) {
                if (groupImpact.getState() == StatePlayerEnum.ACTIVE) {
                    card.setState(StatePlayerEnum.COMPLETED);
                }
            }
        };
    }

    private Consumer<DomainEvent> handleIsRewarded(Cards card) {
        return event -> {
            if (event instanceof IsRewarded isRewarded) {
                card.validateStateOfCard(isRewarded.getId());
                if (card.getState() == StateEvent.ACTIVE) {
                    Reward reward = new Reward(
                            isRewarded.getNameReward(),
                            isRewarded.getDescriptionReward(),
                            isRewarded.getValue()
                    );
                    card.setReward(reward);
                    card.setState(StateEvent.COMPLETED);
                } else {
                    throw new IllegalArgumentException("La tarjeta no está activa, no se puede asignar recompensa.");
                }
            }
        };
    }

    private Consumer<DomainEvent> handleTakenDecision(Cards card) {
        return event -> {
            if (event instanceof TakenDecision takenDecision) {
                if (card.getState() == StateEvent.ACTIVE) {
                    Decision decision = new Decision(
                            takenDecision.getNameDecision(),
                            takenDecision.getDescriptionDecision(),
                            takenDecision.getValue()
                    );
                    card.setDecision(decision);
                    card.setState(StateEvent.COMPLETED);
                    card.setType(TypeEvent.DECISION);
                }
            }
        };
    }
}

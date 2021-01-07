package com.oliver.adv.Helpers;

import com.oliver.adv.Game.AttackEntities.AttackEntity;

public class FightResult {
    private final AttackEntity winner;
    private final AttackEntity loser;

    public FightResult(AttackEntity winner, AttackEntity loser) {
        this.winner = winner;
        this.loser = loser;
    }

    public AttackEntity getWinner() {
        return winner;
    }

    public AttackEntity getLoser() {
        return loser;
    }
}

package vk.kirisaki.conjonction;

import vk.kirisaki.affirmation.StatutAffirmation;

import static vk.kirisaki.affirmation.StatutAffirmation.MENSONGE;
import static vk.kirisaki.affirmation.StatutAffirmation.AFFIRMATION;
import static vk.kirisaki.affirmation.StatutAffirmation.VERITE;

public final class Ou extends Conjonction {
     public Ou() {
        super(" ou ");
    }

    @Override
    public StatutAffirmation evaluer(StatutAffirmation statutAffirmation1, StatutAffirmation statutAffirmation2) {
        if (statutAffirmation1.equals(VERITE) || statutAffirmation2.equals(VERITE)) {
            return VERITE;
        } else if (statutAffirmation1.equals(AFFIRMATION) && statutAffirmation2.equals(AFFIRMATION)) {
            return AFFIRMATION;
        }
        return MENSONGE;
    }
}

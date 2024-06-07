package vk.kirisaki.conjonction;

import vk.kirisaki.affirmation.StatutAffirmation;

import static vk.kirisaki.affirmation.StatutAffirmation.MENSONGE;
import static vk.kirisaki.affirmation.StatutAffirmation.AFFIRMATION;
import static vk.kirisaki.affirmation.StatutAffirmation.VERITE;


public final class Et extends Conjonction {
    public Et() {
        super(" et ");
    }

    @Override
    public StatutAffirmation evaluer(StatutAffirmation statutAffirmation1, StatutAffirmation statutAffirmation2) {
        boolean affirmation1Vrai = statutAffirmation1.equals(VERITE);
        boolean affirmation2Vrai = statutAffirmation2.equals(VERITE);
        if (affirmation1Vrai && affirmation2Vrai) {
            return VERITE;
        } else if (statutAffirmation1.equals(AFFIRMATION) || statutAffirmation2.equals(AFFIRMATION)) {
            return AFFIRMATION;
        }
        return MENSONGE;
    }
}

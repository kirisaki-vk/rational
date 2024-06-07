package vk.kirisaki.affirmation;

import vk.kirisaki.conjonction.Conjonction;

public record Affirmation(String valeur, StatutAffirmation statutAffirmation) {
    public Affirmation joindre(Conjonction conjonction, Affirmation suiteAffirmation) {
        String nouvelleValeur = valeur + conjonction.valeur + suiteAffirmation.valeur();
        StatutAffirmation nouvelleSatusAffirmation = conjonction.evaluer(this.statutAffirmation(), suiteAffirmation.statutAffirmation());

        return new Affirmation(nouvelleValeur, nouvelleSatusAffirmation);
    }
}

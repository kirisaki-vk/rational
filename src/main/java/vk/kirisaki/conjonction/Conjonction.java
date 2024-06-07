package vk.kirisaki.conjonction;

import vk.kirisaki.affirmation.Affirmation;
import vk.kirisaki.affirmation.StatutAffirmation;

public sealed abstract class Conjonction permits Et, Ou, Donc {
    public final String valeur;

    protected Conjonction(String valeur) {
        this.valeur = valeur;
    }

    public abstract StatutAffirmation evaluer(StatutAffirmation statutAffirmation1, StatutAffirmation statutAffirmation2);
}
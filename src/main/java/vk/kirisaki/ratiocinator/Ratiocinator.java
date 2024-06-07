package vk.kirisaki.ratiocinator;

import vk.kirisaki.affirmation.Affirmation;

public class Ratiocinator {
    public static Resultat calculer(Affirmation affirmation) {
        switch (affirmation.statutAffirmation()) {
            case MENSONGE -> {
                return Resultat.FAUX;
            }
            case VERITE -> {
                return Resultat.VRAI;
            }
            default -> {
                return Resultat.JENESAISPAS;
            }
        }
    }
}

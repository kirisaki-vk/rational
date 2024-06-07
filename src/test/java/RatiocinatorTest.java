import org.junit.jupiter.api.Test;
import vk.kirisaki.affirmation.Affirmation;
import vk.kirisaki.conjonction.Donc;
import vk.kirisaki.conjonction.Et;
import vk.kirisaki.conjonction.Ou;
import vk.kirisaki.ratiocinator.Ratiocinator;
import static vk.kirisaki.ratiocinator.Resultat.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static vk.kirisaki.affirmation.StatutAffirmation.*;

public class RatiocinatorTest {
    @Test
    public void calculus_ratiocinator_autour_de_lou() {
        var louEstBeau = new Affirmation("Lou est beau", VERITE);
        var louEstGenereux = new Affirmation("Lou est généreux", AFFIRMATION);
        var louEstPauvre = new Affirmation("Lou est pauvre", MENSONGE);

        var louEstPauvreEtLouEstGenereux = louEstPauvre.joindre(new Et(), louEstGenereux);
        assertEquals(Ratiocinator.calculer(louEstPauvreEtLouEstGenereux), FAUX);

        var louEstBeauDoncLouEstPauvre = louEstBeau.joindre(new Donc(), louEstPauvre);
        assertEquals(Ratiocinator.calculer(louEstBeauDoncLouEstPauvre), FAUX);

        var louEstPauvreDoncLouEstGenereux = louEstPauvre.joindre(new Donc(), louEstGenereux);
        assertEquals(Ratiocinator.calculer(louEstPauvreDoncLouEstGenereux), VRAI);

        var louEstBeauOuLouEstGenereuxDoncLouEstPauvre = louEstBeau.joindre(new Ou(), louEstGenereux).joindre(new Donc(), louEstPauvre);
        assertEquals(Ratiocinator.calculer(louEstBeauOuLouEstGenereuxDoncLouEstPauvre), FAUX);

        var louEstPauvreOuLouEstGenereux = louEstPauvre.joindre(new Ou(), louEstGenereux);
        var louEstBeauOuLouEstGenereuxDoncLouEstPauvreEtLouEstPauvreOuLouEstGenereux = louEstBeauOuLouEstGenereuxDoncLouEstPauvre.joindre(new Et(), louEstPauvreOuLouEstGenereux);
        assertEquals(Ratiocinator.calculer(louEstBeauOuLouEstGenereuxDoncLouEstPauvreEtLouEstPauvreOuLouEstGenereux), FAUX);
    }
}

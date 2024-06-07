import org.junit.jupiter.api.Test;
import vk.kirisaki.affirmation.Affirmation;
import vk.kirisaki.conjonction.Et;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static vk.kirisaki.affirmation.StatutAffirmation.AFFIRMATION;
import static vk.kirisaki.affirmation.StatutAffirmation.VERITE;
import static vk.kirisaki.affirmation.StatutAffirmation.MENSONGE;

class AffirmationTest {
    @Test
    public void peut_declarer_affirmation() {
        var louEstBeau = new Affirmation("Lou est beau", VERITE);
        var louEstGenereux = new Affirmation("Lou est généreux", AFFIRMATION);
        var louEstPauvre = new Affirmation("Lou est pauvre", MENSONGE);
    }

    @Test
    public void peut_joindre_des_affirmations() {
        var louEstBeau = new Affirmation("Lou est beau", VERITE);
        var louEstGenereux = new Affirmation("Lou est généreux", AFFIRMATION);
        var louEstPauvre = new Affirmation("Lou est pauvre", MENSONGE);

        var louEstPauvreEtLouEstGenereux = louEstPauvre.joindre(new Et(), louEstGenereux);

        assertEquals(louEstPauvreEtLouEstGenereux.statutAffirmation(), AFFIRMATION);
    }

}

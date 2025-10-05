package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubstitutionCipherTest {

    public SubstitutionCipherTest() {
    }

    /**
     * Test of encode method, of class SubstitutionCipher. Test the codification
     * of the word "simple"
     *
     */
    @Test
    public void testEncodeBasic() {
        assertEquals("tjnqmf", SubstitutionCipher.encode(1, "simple"));
    }

    /**
     * Test of encode method, of class SubstitutionCipher. Includes a
     * complicated case, codification of "¡¡Cañonazo al Balón!!" The characters
     * !, ¡, ñ and ó are not included in the alphabet and so they must remain
     * equal. Besides the 'z' character is located at the end of the alphabet,
     * so it must be modifying for a letter at the beginning of the alphabet
     * (circular way)
     */
    @Test
    public void testEncode() {
        assertEquals("¡¡Mkñyxkjy kv Lkvóx!!", SubstitutionCipher.encode(10, "¡¡Cañonazo al Balón!!"));
    }

    /**
     * Test of decode method, of class SubstitutionCipher.
     */
    @Test
    public void testDecode() {
        assertEquals("simple", SubstitutionCipher.decode(1, "tjnqmf"));
        assertEquals("¡¡Cañonazo al Balón!!", SubstitutionCipher.decode(10, "¡¡Mkñyxkjy kv Lkvóx!!"));
    }

}

package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.PokemonEstaMuertoException;
import fiuba.algo3.modelo.pokemones.Jigglypuff;
import fiuba.algo3.modelo.pokemones.Pikachu;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AtaquesSimplesEntrePokemonesTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void PikachuHaceImpacTruenoAJigglypuffYLeQuita20PuntosDeVida() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        pikachu.impacTrueno(jigglypuff); // quita 20 puntos

        assertEquals(60, jigglypuff.getPuntos());
    }

    @Test
    public void PikachuHaceImpacTruenoAOtroPikachuYLeQuita20PuntosDeVida() {

        Pikachu pikachu1 = new Pikachu(); // Crea un Pikachu con 100 puntos de vida
        Pikachu pikachu2 = new Pikachu(); // Crea otro Pikachu con 100 puntos de vida

        pikachu1.impacTrueno(pikachu2); // quita 20 puntos

        assertEquals(80, pikachu2.getPuntos());
    }

    @Test
    public void JigglypuffHaceCachetazoAPikachuYLeQuita10PuntosDeVida() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        jigglypuff.cachetazo(pikachu); // quita 10 puntos

        assertEquals(90, pikachu.getPuntos());
    }

    @Test
    public void JigglypuffHaceCachetazoAOtroJigglypuffYLeQuita10PuntosDeVida() {

        Jigglypuff jigglypuff1 = new Jigglypuff(); // Crea un Jigglypuff con 80 puntos de vida
        Jigglypuff jigglypuff2 = new Jigglypuff(); // Crea otro Jigglypuff con 80 puntos de vida

        jigglypuff1.cachetazo(jigglypuff2); // quita 10 puntos

        assertEquals(70, jigglypuff2.getPuntos());
    }

    @Test
    public void PikachuMataAJigglypuffYJigglypuffYaNoPuedeRecibirDanio() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        for (int i = 0; i < 4; i++) {
            pikachu.impacTrueno(jigglypuff); // quita 20 puntos
        }

        thrown.expect(PokemonEstaMuertoException.class);
        pikachu.impacTrueno(jigglypuff);
    }

    @Test
    public void JigglypuffMataAPikachuYPikachuYaNoPuedeRecibirDanio() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        for (int i = 0; i < 10; i++) {
            jigglypuff.cachetazo(pikachu); // quita 10 puntos
        }

        thrown.expect(PokemonEstaMuertoException.class);
        jigglypuff.cachetazo(pikachu);
    }

}

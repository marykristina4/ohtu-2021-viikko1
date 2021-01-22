package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto toinen_varasto;
    Varasto nega_varasto;
    Varasto toinen_nega_varasto;
    Varasto kolmas_vika_varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        toinen_varasto = new Varasto(9, 1);
        nega_varasto = new Varasto(-10);
        toinen_nega_varasto = new Varasto(-10, -1);
        kolmas_vika_varasto = new Varasto(10, 20);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void toisenvarastonsaldooikein() {
        assertEquals(1, toinen_varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastonsaldoeinegatiiviseksi() {
        assertEquals(0.0, nega_varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastonsaldoeinegatiiviseksikunalkusaldo() {
        assertEquals(0.0, toinen_nega_varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void varastonalkusaldoeinegatiiviseksi() {
        assertEquals(0.0, toinen_nega_varasto.getSaldo(), vertailuTarkkuus);
    }
        @Test
    public void varastonalkusaldoeiisompikuintilavuus() {
        assertEquals(10, kolmas_vika_varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void toisellaVarastollaOikeaTilavuus() {
        assertEquals(9, toinen_varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void eiVoiLisataJosEiTilaa() {
        varasto.lisaaVarastoon(12);

        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void eiVoiLisataNegaa() {
        varasto.lisaaVarastoon(-12);

        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void eiVoiOttaaNegaa() {
        double talteen = varasto.otaVarastosta(-12);

        assertEquals(0.0, talteen, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenEiOnnistuJosEiOle() {

        varasto.otaVarastosta(100);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
          @Test
    public void saldoStringina() {
        

                System.out.println(varasto.toString());
               System.out.println("saldo = " + varasto.getSaldo() + ", viel� tilaa " + varasto.paljonkoMahtuu());
      assertEquals("saldo = " + varasto.getSaldo() + ", vielä tilaa " + varasto.paljonkoMahtuu(), varasto.toString());
    }

}

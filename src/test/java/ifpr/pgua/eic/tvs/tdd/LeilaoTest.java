package ifpr.pgua.eic.tvs.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ifpr.pgua.eic.tvs.tdd.controles.Leilao;
import ifpr.pgua.eic.tvs.tdd.models.Lance;

public class LeilaoTest {
    


    @Test
    public void umLeilaoAceitaUmLance(){

        //cenario
        Lance lance = new Lance("Zé", 5.0);

        Leilao leilao = new Leilao("Fusca");

        //ação
        leilao.propoe(lance);

        //verificação
        assertEquals(1,leilao.getLances().size());
        assertEquals(lance.getValor(),leilao.getLances().get(0).getValor());

    }


    @Test
    public void umLeilaoAceitaDiversosLances(){
        //cenário
        Lance lance1 = new Lance("Zé", 5.0);
        Lance lance2 = new Lance("Chico", 15.0);
        Lance lance3 = new Lance("Maria", 20.0);

        Leilao leilao = new Leilao("Fusca");

        //ação
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);

        //verificação
        assertEquals(3, leilao.getLances().size());
        assertEquals(lance1.getValor(),leilao.getLances().get(0).getValor());
        assertEquals(lance2.getValor(),leilao.getLances().get(1).getValor());
        assertEquals(lance3.getValor(),leilao.getLances().get(2).getValor());
           
    }

    @Test
    public void naoPodeLanceConsecutivoMesmoComprador(){

        //cenário
        Lance lance1 = new Lance("Zé", 5.0);
        Lance lance2 = new Lance("Zé", 10.0);

        Leilao leilao = new Leilao("Fusca");

        //ação
        boolean ret1 = leilao.propoe(lance1);
        boolean ret2 = leilao.propoe(lance2);

        //verificação
        assertEquals(1, leilao.getLances().size());
        assertTrue(ret1);
        assertFalse(ret2);
    }

    @Test
    public void naoPodeMaisde5LancesComprador(){
        //cenário
        ArrayList<Lance> lances = new ArrayList<>();
        
        lances.add(new Lance("Zé", 5.0));
        lances.add(new Lance("Maria", 10.0));
        lances.add(new Lance("Zé", 15.0));
        lances.add(new Lance("Maria", 20.0));
        lances.add(new Lance("Zé", 25.0));
        lances.add(new Lance("Maria", 30.0));        
        lances.add(new Lance("Zé", 35.0));
        lances.add(new Lance("Maria", 40.0));
        lances.add(new Lance("Zé", 45.0));
        lances.add(new Lance("Maria", 50.0));
        lances.add(new Lance("Zé", 60.0));
        
        Leilao leilao = new Leilao("Fusca");

        //ação
        ArrayList<Boolean> retornos = new ArrayList<>();

        for(Lance lance:lances){
            boolean ret = leilao.propoe(lance);
            retornos.add(ret);
        }

        assertEquals(10, leilao.getLances().size());
        assertFalse(retornos.get(10));

    }
}

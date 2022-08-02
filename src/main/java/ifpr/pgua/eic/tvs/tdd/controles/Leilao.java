package ifpr.pgua.eic.tvs.tdd.controles;

import java.util.ArrayList;
import java.util.List;

import ifpr.pgua.eic.tvs.tdd.models.Lance;

public class Leilao {

    private String item;
    private List<Lance> lances;
    

    public Leilao(String item){
        this.item = item;
        lances = new ArrayList<>();
    }


    public boolean propoe(Lance lance) {
        if(lances.size()==0 || podeDarLance(lance.getComparador())){
            
            lances.add(lance);
            return true;
            
        }
        return false;
        
    }

    private boolean podeDarLance(String nome){
        return (!mesmoComprador(nome) && quantidadeLancesAnteriores(nome) < 5);
    }

    private int quantidadeLancesAnteriores(String nome){
        
        /*for(Lance temp:lances){
            if(temp.getComparador().equals(nome)){
                cont += 1;
            }
        }*/

        return (int)lances.stream().filter((item)->item.getComparador().equals(nome)).count();

        
    }

    private boolean mesmoComprador(String nome){
        return lances.get(lances.size()-1).getComparador().equals(nome);
    }


    public List<Lance> getLances() {
        return lances;
    }


}

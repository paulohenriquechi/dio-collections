package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MetodosMap {
    public static void main(String[] args) {
        Map<String, Double> carrosPopulares = new HashMap<>();
            carrosPopulares.put("Gol", 14.4);
            carrosPopulares.put("Uno", 15.6);
            carrosPopulares.put("Mobi", 16.1);
            carrosPopulares.put("HB20", 16.1);
            carrosPopulares.put("Kwid", 15.5);
            System.out.println(carrosPopulares);

            //sobrescrevendo um valor
            carrosPopulares.put("Gol", 15.2);
            System.out.println(carrosPopulares);

            //verificando se um valor está na lista
            System.out.println(carrosPopulares.containsKey("Tucson"));

            //mostrando o valor de uma chave
            System.out.println(carrosPopulares.get("Uno"));

            //retorna as chaves
            System.out.println(carrosPopulares.keySet());

            //retorna os valores
            System.out.println(carrosPopulares.values());

            //verifica o maior valor
            Double carroMais = Collections.max(carrosPopulares.values());

            //retornando a key do valor
            Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
            String custoBeneficio = "";
            for (Map.Entry<String,Double> entry : entries) {
                if(entry.getValue().equals(carroMais)){
                    custoBeneficio = entry.getKey();
                    System.out.println(carroMais + " " + custoBeneficio);
                }
            }

            //verifica o menor valor
            Double carroMenos = Collections.min(carrosPopulares.values());
            String custoBeneficioMenos = "";
            for (Map.Entry<String,Double> entry : carrosPopulares.entrySet()) {
                if(entry.getValue().equals(carroMenos)){
                    custoBeneficioMenos = entry.getKey();
                    System.out.println(carroMenos + " " +  custoBeneficioMenos);
                }
            }

            //soma 
            Iterator<Double> iterator = carrosPopulares.values().iterator();
            double soma = 0d;
            while(iterator.hasNext()){
                soma += iterator.next();
            }
            System.out.println(soma);

            //media 
            double media = soma/carrosPopulares.size();
            System.out.println(media);

            //remover valores condições
            Iterator<Double> iterator1 = carrosPopulares.values().iterator();
            while(iterator1.hasNext()){
                if(iterator1.next().equals(15.6)){
                    iterator1.remove();
                }
            }
            System.out.println(carrosPopulares);

            //ordem informada
            Map<String, Double> carrosPopulares1 = new LinkedHashMap<>();
            carrosPopulares1.put("Gol", 14.4);
            carrosPopulares1.put("Uno", 15.6);
            carrosPopulares1.put("Mobi", 16.1);
            carrosPopulares1.put("HB20", 16.1);
            carrosPopulares1.put("Kwid", 15.5);
            System.out.println(carrosPopulares1);

            //ordem de key
            Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
            System.out.println(carrosPopulares2);

            //apagando conjunto 
            carrosPopulares.clear();

            //verificando se ta vazio
            System.out.println(carrosPopulares.isEmpty()); 
    }


}

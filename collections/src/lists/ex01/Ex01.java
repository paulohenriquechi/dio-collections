package lists.ex01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/
public class Ex01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();
        for(int i = 0;i<6;i++){
            System.out.println("Temperatura: ");
            Double temp = input.nextDouble();
            temperaturas.add(temp);
        }
        Iterator<Double> iterator = temperaturas.iterator();
        double count = 0;
        while(iterator.hasNext()){
            double next = iterator.next();
            count += next;
        }
        double media = count/temperaturas.size();

        System.out.println("Media: "+media);
        System.out.println("Meses que tiveram temperatura acima da media: ");

        Iterator<Double> iterator1 = temperaturas.iterator();
        int counter = 0;
        while(iterator1.hasNext()){
            double next = iterator1.next();
            if(next>media){
                // temperaturas.get(counter);
                switch(counter){
                    case 0:
                        System.out.println("1 - Janeiro");
                        break;
                    case 1:
                        System.out.println("2 - Fevereiro");
                        break;
                    case 2:
                        System.out.println("3 - Março");
                        break;
                    case 3: 
                        System.out.println("4 - Abril");
                        break;
                    case 4: 
                        System.out.println("5 - Maio");
                        break;
                    case 5: 
                        System.out.println("6 - Junho");
                        break;
                    default:
                        System.out.println("Sem temperaturas acima da média.");
                        
                }
            }
            counter++;
        }

    }


    
}

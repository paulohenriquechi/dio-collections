package lists.ex02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/

public class Ex02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> respostas = new ArrayList<>();
        System.out.println("Telefonou para a vítima?");
        respostas.add(input.nextLine());
        System.out.println("Esteve no local do crime?");
        respostas.add(input.nextLine());
        System.out.println("Mora perto da vítima?");
        respostas.add(input.nextLine());
        System.out.println("Devia para a vítima?");
        respostas.add(input.nextLine());
        System.out.println("Já trabalhou com a vítima?");
        respostas.add(input.nextLine());
        System.out.println(respostas);
        input.close();

        int count = 0;
        Iterator<String> iterator = respostas.iterator();
        while(iterator.hasNext()){
            String resposta = iterator.next();
            if(resposta.toString().equals("s")){
                count++;
            }
        }
        if(count<=1){
            System.out.println("Inocente.");
        }
        else if(count==2){
            System.out.println("Suspeita.");
        }
        else if(count>2&&count<5){
            System.out.println("Cumplice.");
        }
        else if(count==5){
            System.out.println("Assassino.");
        }
        else{
            System.out.println("Nada a declarar");
        }

    }
}

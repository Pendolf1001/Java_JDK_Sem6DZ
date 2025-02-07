package com.example;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, String> resultWhithoutChange=new HashMap<>();
        HashMap<Integer, String> resultWhithChange=new HashMap<>();

        for(int i=0; i<1000;i++){
            resultWhithoutChange.put(i,gameWhithoutChange());
            resultWhithChange.put(i,gameWhithChange());
        }
        System.out.println("Побед без замены выбора из 1000 раз: "+resultWhithoutChange.values().stream().filter(v -> v == "Win").count());
        System.out.println("Побед с заменой выбора из 1000 раз: "+resultWhithChange.values().stream().filter(v -> v == "Win").count());





    }

    public static String gameWhithoutChange(){
        Random random = new Random();
        int winNumber = random.nextInt(3) + 1;
        int openDoor=0;
        int chois=random.nextInt(3) + 1;

        for(int i=1; i<4; i++){
            if((i!=winNumber)&&(i!=chois)){
                openDoor=i;
            }
        }
        // System.out.println("Chois: "+chois);
        // System.out.println("Open door: "+openDoor);
        // System.out.println("winNumber: "+winNumber);
        if (chois==winNumber){
            return "Win";
        }else{
            return "Loose";
        }
    }


    public static String gameWhithChange(){
        Random random = new Random();
        int winNumber = random.nextInt(3) + 1;
        int openDoor=0;
        int secChois=0;
        int chois=random.nextInt(3) + 1;

        for(int i=1; i<4; i++){
            if((i!=winNumber)&&(i!=chois)){
                openDoor=i;
            }
        }
        // System.out.println("1th Chois: "+chois);
        // System.out.println("Open door: "+openDoor);
        for(int i=1; i<4; i++){
            if((i!=openDoor)&&(i!=chois)){
                secChois=i;
            }
        }

        // System.out.println("2th Chois: "+secChois);
        // System.out.println("winNumber: "+winNumber);
        if (secChois==winNumber){
            return "Win";
        }else{
            return "Loose";
        }
    }
}
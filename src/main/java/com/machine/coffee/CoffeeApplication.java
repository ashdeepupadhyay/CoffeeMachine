package com.machine.coffee;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeApplication {

    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a json path: ");
        String pathOfJson= sc.nextLine();              
        System.out.print("You have entered: "+pathOfJson);
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> inputParam=input.TakeInput(pathOfJson);
    }
}

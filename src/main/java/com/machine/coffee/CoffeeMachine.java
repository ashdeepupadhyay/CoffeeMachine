package com.machine.coffee;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoffeeMachine {

    ExecutorService pool;
    int no_of_outlet;
    public HashMap<String, Long> ingredients=new HashMap<String, Long>();

    public CoffeeMachine(int no_of_outlet, HashMap<String, Long> ingredients)
    {
        this.no_of_outlet=no_of_outlet;
        this.ingredients = ingredients;

        pool = Executors.newFixedThreadPool(no_of_outlet);
        Executors.newFixedThreadPool(no_of_outlet);
    }
}

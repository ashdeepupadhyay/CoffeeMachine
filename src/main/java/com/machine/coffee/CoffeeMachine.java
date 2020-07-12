package com.machine.coffee;

import com.machine.utils.MachineUtils;

import java.util.HashMap;
import java.util.Map;
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


    public void makeBeverage(String beverageName, Map<String, Long> ingredientsRequired)
    {
        Runnable r1 = new CoffeeTask(beverageName,ingredientsRequired,this);
        pool.execute(r1);
    }

    public void RefillOrAddingredient(String ingredientsName,long ingredientsValue)
    {
        if(MachineUtils.isNullOrEmpty(ingredientsName)||ingredientsValue<0)
        {
            System.out.println("Quantity of the ingredients cannot be -ve or ingredient is null or empty");
            return;
        }

        if(ingredients.containsKey(ingredientsName))
        {
            ingredients.put(ingredientsName,ingredients.get(ingredientsName)+ingredientsValue);
        }
        else
        {
            ingredients.put(ingredientsName,ingredientsValue);
        }
        System.out.println("ingredient added");
    }
    public void finalize() throws Throwable
    {
        pool.shutdown();
    }
}

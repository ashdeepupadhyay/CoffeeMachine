package com.machine.coffee;

import com.machine.utils.MachineUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoffeeMachine {

    ExecutorService pool;
    int noOfOutlet;
    public HashMap<String, Long> ingredients=new HashMap<String, Long>();

    public CoffeeMachine(int no_of_outlet, HashMap<String, Long> ingredients)
    {
        this.noOfOutlet=no_of_outlet;
        this.ingredients = ingredients;

        pool = Executors.newFixedThreadPool(noOfOutlet);
        Executors.newFixedThreadPool(noOfOutlet);
    }

    /*
    this function makes the beverage it reduces the ingredients from the total ingredients if and only if all ingredients
    required are available then only it reduces it otherwise it prints that it is not possible to make that Beverage
     */
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

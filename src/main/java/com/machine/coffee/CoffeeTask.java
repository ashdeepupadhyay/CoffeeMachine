package com.machine.coffee;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CoffeeTask implements Runnable {
    private String name;
    private Map<String,Long> ingredientsRequired=new HashMap<String, Long>();
    private CoffeeMachine cm;

    public CoffeeTask(String s,Map<String,Long> ingredientsRequired,CoffeeMachine cm)
    {
        this.name = s;
        this.ingredientsRequired=ingredientsRequired;
        this.cm=cm;
    }

    public void run()
    {
        try
        {

            for (int i = 0; i<=5; i++)
            {

                if (i==0)
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    //System.out.println("Initialization Time for" + " task name - "+ name +" = " +ft.format(d));

                    //prints the initialization time for every task
                }
                else
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    //System.out.println("Executing Time for task name - "+ name +" = " +ft.format(d));
                    // prints the execution time for every task
                }

                 
                Thread.sleep(10);
            }

            boolean canBePreapred=true;
            String missingIngredient="";

            for (Map.Entry<String, Long> ing : ingredientsRequired.entrySet()) {
                if(cm.ingredients.containsKey(ing.getKey()))
                {
                    if(cm.ingredients.get(ing.getKey())-ing.getValue()<0)
                    {
                        missingIngredient=ing.getKey();
                        canBePreapred=false;
                        break;
                    }
                }
                else
                {
                    missingIngredient=ing.getKey();
                    canBePreapred=false;
                    break;
                }
            }

            if(canBePreapred)
            {
                for (Map.Entry<String, Long> ing : ingredientsRequired.entrySet()) {

                    Long diff=cm.ingredients.get(ing.getKey())-ing.getValue().intValue();
                    cm.ingredients.put(ing.getKey(),diff);

                }
                System.out.println(name+" is prepared");
            }
            else
            {
                System.out.println(name+" cannot be prepared because "+ missingIngredient+" is not available");
            }
        }

        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

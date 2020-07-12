package com.machine.coffee;

import javafx.util.Pair;
import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoffeeMachineTest {

    @Test
    public void RefillOrAddingredientExistentKey() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+"/src/test/inputTestFiles/input.json");
        output.getKey().RefillOrAddingredient("sugar_syrup",100);

        Assert.assertEquals("Existent key value updated",200,(long)output.getKey().ingredients.get("sugar_syrup"));
    }

    @Test
    public void RefillOrAddingredientNonExistentKey() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");

        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+"/src/test/inputTestFiles/input.json");
        output.getKey().RefillOrAddingredient("cold_water",100);

        Assert.assertEquals("New Existent key value updated",100,(long)output.getKey().ingredients.get("cold_water"));        //don't know is this the best way
    }

    @Test
    public void RefillOrAddingredientWithInvalidIngredientName() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+"/src/test/inputTestFiles/input.json");
        output.getKey().RefillOrAddingredient("",100);

        Assert.assertEquals("Existent key value updated",5,(long)output.getKey().ingredients.size());
    }

    @Test
    public void RefillOrAddingredientWithInvalidIngredientValue() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+"/src/test/inputTestFiles/input.json");
        output.getKey().RefillOrAddingredient("cold_water",-1);

        Assert.assertEquals("Existent key value updated",5,(long)output.getKey().ingredients.size());        //don't know is this the best way
    }


}
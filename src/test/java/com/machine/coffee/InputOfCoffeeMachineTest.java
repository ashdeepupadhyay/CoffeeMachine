package com.machine.coffee;

import javafx.util.Pair;
import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class InputOfCoffeeMachineTest {

    @Test
    public void InputOfCoffeeMachineWithBlankInput() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput("");
        Assert.assertEquals(null,output);
    }

    @Test
    public void InputOfCoffeeMachineWithWrongPath() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+"/src/test/input.json");
        Assert.assertEquals(null,output);
    }

    @Test
    public void InputOfCoffeeMachineWithInvalidNInput() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+"/src/test/inputTestFiles/inputInvalidNInput.json");
        Assert.assertEquals(null,output);
    }

    @Test
    public void InputOfCoffeeMachineWithInvalidBlankTotalIngrident() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+"/src/test/inputTestFiles/InvalidBlankTotalIngrident.json");
        Assert.assertEquals(null,output);
    }

    @Test
    public void InputOfCoffeeMachineWithInvalidTotalIngridentQuantity() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+"/src/test/inputTestFiles/InvalidTotalIngridentQuantity.json");
        Assert.assertEquals(null,output);
    }

    @Test
    public void InputOfCoffeeMachineWithInvalidBlankInvalidBeverageName() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+ "src/test/inputTestFiles/InvalidBlankInvalidBeverageName.json");
        Assert.assertEquals(null,output);
    }

    @Test
    public void InputOfCoffeeMachineWithInvalidBlankInvalidBeverageIngrident() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+ "src/test/inputTestFiles/InvalidBlankInvalidBeverageIngrident.json");
        Assert.assertEquals(null,output);
    }

    @Test
    public void InputOfCoffeeMachineWithInvalidBlankInvalidBeverageIngridentValue() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+ "src/test/inputTestFiles/InvalidBlankInvalidBeverageIngridentValue.json");
        Assert.assertEquals(null,output);
    }

    @Test
    public void InputOfCoffeeMachineWithValidData() {
        InputOfCoffeeMachine input=new InputOfCoffeeMachine();
        String currentDirectory = System.getProperty("user.dir");
        Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> output=input.TakeInput(currentDirectory+"/src/test/inputTestFiles/input.json");
        Assert.assertNotNull(output);
    }
}
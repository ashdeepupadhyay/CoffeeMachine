package com.machine.coffee;

import com.machine.utils.MachineUtils;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InputOfCoffeeMachine {
    public Pair<CoffeeMachine, HashMap<String, Map<String, Long>>> TakeInput(String pathOfJson)
    {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader=new FileReader(pathOfJson))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject jsonObject = (JSONObject) obj;
            JSONObject machine = (JSONObject) jsonObject.get("machine");
            JSONObject outlets = (JSONObject) machine.get("outlets");
            long count=(long)outlets.get("count_n");
            System.out.println("******outlets*********");
            if(count<1)
            {
                System.out.println("number of outlet should be at least 1");
                return null;
            }

            System.out.println(count);
            //JSONObject total_items_quantity = (JSONObject) jsonObject.get("total_items_quantity");
            HashMap<String,Long> ingredients=new HashMap<String, Long>();

            if (machine.containsKey("total_items_quantity")) {
                Object value = machine.get("total_items_quantity");
                //System.out.println("Key : " + "total_items_quantity" +" value :"+ value);
                ingredients=(HashMap)value;
                System.out.println("*********ingridents********");
                for (Map.Entry<String, Long> team : ingredients.entrySet()) {
                    if(team.getValue()<0|| MachineUtils.isNullOrEmpty(team.getKey()))
                    {
                        System.out.println("Quantity of the ingridents cannot be -ve or ingrident is null or empty");
                        return null;
                    }
                    System.out.println(team.getKey()+" "+team.getValue());
                }
                /*
                Iterator<Map.Entry> itr2 = ingredients.entrySet().iterator();
                while (itr2.hasNext()) {
                    Map.Entry pair = itr2.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                }
                */

            }

            System.out.println("******beverages*********");

            HashMap<String, Map<String, Long>> mapBeverage = new HashMap<String, Map<String, Long>>();
            if (machine.containsKey("beverages")) {
                Object value = machine.get("beverages");
                //System.out.println("Key : " + "beverages" +" value :"+ value);

                JSONObject beverageList = (JSONObject) value;

                Map bevergaeMap=(Map)value;
                Iterator<Map.Entry> itr2 = bevergaeMap.entrySet().iterator();
                while (itr2.hasNext()) {
                    Map.Entry pair = itr2.next();
                    //System.out.println(pair.getKe        this.no_of_outlet=no_of_outlet;y() + " : " + pair.getValue());

                    String keyVal= (String) pair.getKey();
                    mapBeverage.put(keyVal,(Map)pair.getValue());

                }
            }

            for (Map.Entry<String, Map<String, Long>> team : mapBeverage.entrySet()) {
                if(MachineUtils.isNullOrEmpty(team.getKey()))
                {
                    System.out.println(" Beverage cannot be null or empty");
                    return null;
                }
                System.out.println();
                System.out.println("BEVERAGE NAME "+team.getKey());
                for (Map.Entry key : team.getValue().entrySet()) {
                    if((long)key.getValue()<0||MachineUtils.isNullOrEmpty((String) key.getKey()))
                    {
                        System.out.println("Quantity of the ingridents cannot be -ve or ingrident is null or empty");
                        return null;
                    }
                    System.out.println(key.getKey()+"  "+key.getValue());
                }
            }
            int outlet=(int)count;
            CoffeeMachine coffeeMachine=new CoffeeMachine(outlet,ingredients);
            return new Pair(coffeeMachine,mapBeverage);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

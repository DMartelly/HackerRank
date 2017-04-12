package datastructures.stacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by Dominick Martelly on 4/12/2017 at 6:01 PM.
 *
 * @author Dominick Martelly
 */

public class PoisonousPlants {

    public static void main(String[] args) {
        int count = 0;
        Scanner in = new Scanner(System.in);
        int numOfPlants = in.nextInt();
        List<Integer> garden = new LinkedList<>();
        for (int i = 0; i < numOfPlants; i++) {
            garden.add(in.nextInt());
        }
        List<Integer> newGarden = oneDay(garden);
        while (garden.size() != newGarden.size()) {
            garden = newGarden;
            newGarden = oneDay(garden);
            count++;
        }
        System.out.println(count);
    }

    private static List<Integer> oneDay(List<Integer> garden) {
        if(garden.size() == 1){
            return garden;
        }
        List<Integer> newGarden = new LinkedList<>();
        Iterator gardenItr = garden.iterator();
        newGarden.add((Integer) gardenItr.next());
        Integer curr = newGarden.get(0);
        while (gardenItr.hasNext()){
            Integer nextPlant = (Integer) gardenItr.next();
            if (curr >= nextPlant){
                newGarden.add(nextPlant);
            }
            curr = nextPlant;
        }
        return newGarden;
    }
}
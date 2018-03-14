package fr.isima.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManageLife {

    public static Life generation(Life a, long b) {
        long gen = a.getGeneration();
        while(gen < b)
        {
            a.nextGeneration();
            gen++;
        }
        return a;



    }

}



package fr.isima.business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Life {
    public int lignes;
    public int collonnes;
    public boolean[][] world;
    public long generation;

    public void Life(){
        lignes = 0;
        collonnes= 0;
        world=null;
        generation = 0;
    }

    public void createNewWorld(String FILENAME) throws IOException {
        FileReader fileReader = new FileReader(FILENAME);
        System.out.println(System.getProperty("user.dir"));
        BufferedReader br =  new BufferedReader(fileReader);
        String line;
        line=br.readLine();
        System.out.println("-----"+line+"-----");
        line=br.readLine();
        System.out.println("-----"+line+"-----");
        String[] a = line.split(" ");
        lignes=Integer.parseInt(a[0]);
        collonnes=Integer.parseInt(a[1]);
        System.out.println("-----"+a[1]+"-----");
        world = new boolean[lignes][collonnes];
        int i=0;

        while((line = br.readLine()) != null) {

            for (int j = 0; j < collonnes; j++) {
                if (line.charAt(j) == '.') {
                    world[i][j] = false;
                } else {
                    world[i][j] = true;
                }
            }
            i++;
        }
    }

    public void nextGeneration(){
        boolean[][] newWorld = new boolean[lignes][collonnes];
        for(int row = 0; row <lignes; row++ ){
            for(int col = 0; col < collonnes; col++ ){
                newWorld[row][col] = isAlive(row, col);
            }
        }
        world = newWorld;
        generation++;
    }


    private boolean isAlive(int row, int col){
        int liveCount = 0;
        boolean cellCurrentlyAlive = world[row][col];

        for(int r = -1; r <= 1; r++){
            int currentRow = row + r;
            currentRow = (currentRow < 0)? lignes - 1: currentRow;
            currentRow = (currentRow >= lignes)? 0 : currentRow;
            for(int c = -1; c <= 1; c++){
                int currentCol = col + c;
                currentCol = (currentCol < 0)? collonnes - 1: currentCol;
                currentCol = (currentCol >= collonnes)? 0 : currentCol;
                if(world[currentRow][currentCol]){
                    liveCount++;
                }
            }
        }

        // Since all cells are counted including the cell we are calculating.
        // We must subtract 1 from the liveCount if the cell we are calculating for is alive.
        if(cellCurrentlyAlive){
            liveCount--;
        }

        // The game of life rules in code form.
        if(liveCount == 2 && cellCurrentlyAlive){
            return true;
        } else if(liveCount == 3){
            return true;
        } else {
            return false;
        }
    }

    public int getLignes() {
        return lignes;
    }

    public int getCollonnes() {
        return collonnes;
    }

    public boolean[][] getWorld() {
        return world;
    }

    public long getGeneration() {
        return generation;
    }
}



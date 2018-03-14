package fr.isima.server;

import fr.isima.business.Life;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;

@SpringBootApplication
public class Server {
    public static void main(String[] args) throws IOException {
        new SpringApplicationBuilder()
                .sources(Application.class)
                .run(args);
        /*Life a = new Life();
        a.Life();
        boolean [][] monTab2 = a.world;
        for(int i=0;i<a.lignes;i++)
        {
            for(int j=0;j<a.collonnes;j++)
            {
                System.out.print(monTab2[i][j]+" ");
            }
            System.out.println("");
        }

        a.nextGeneration();
        System.out.println("");
        boolean [][] monTab3 = a.world;
        for(int i=0;i<a.lignes;i++)
        {
            for(int j=0;j<a.collonnes;j++)
            {
                System.out.print(monTab3[i][j]+" ");
            }
            System.out.println("");
        }*/


    }
}
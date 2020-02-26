package com.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MostRepeatedWord {

    public static void main(String[] args) {
        try {
            searchPalabraMasRepeticiones();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void searchPalabraMasRepeticiones() throws IOException {
        System.out.println("Search text file on path: C://files/file.txt");
        String texto = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C://files/file.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
            }
            texto = sb.toString();
            if(texto == null || texto.isEmpty()){
                System.out.println("Cannot read the text");
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

        errasePuntuationSigns(texto);
        String[] palabras = texto.split(" ");
        int mostRepeated = 0;
        int mostRepeatedIndex = -1;

        int[] repeticion = new int[palabras.length];
        for (int i = 0; i < repeticion.length; i++) {
            repeticion[i] = 1;
        }
        for (int i = 0; i < palabras.length; i++) {
            for (int j = i + 1; j < palabras.length; j++) {
                if (i == j) {
                    j++;
                }
                if (palabras[i].equalsIgnoreCase(palabras[j])) {
                    repeticion[i]++;
                    if (repeticion[i] > mostRepeated) {
                        mostRepeated = repeticion[i];
                        mostRepeatedIndex = i;

                    }
                }
            }
        }
        if(mostRepeatedIndex >= 0) {
            System.out.println("Most repeat word:" + palabras[mostRepeatedIndex]);
        }else {
            System.out.println("Cannot find most repeated word");
        }
    }

    private static String errasePuntuationSigns(String text){

        text.replace(",", "");
        text.replace(".", "");
        text.replace(";", "");
        text.replace("!", "");
        text.replace("?", "");
        return text;
    }
}

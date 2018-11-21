/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author DTI
 */
public class LeitorArquivo {
    private static final String CAMINHO_ARQUIVO = "src/Util/texto.txt";
    
    public static String lerArquivo(){
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Files.lines(Paths.get(CAMINHO_ARQUIVO)).forEach(stringBuilder::append);
            return stringBuilder.toString();
        } catch (IOException ex) {
            System.out.println("Erro ao ler: " + ex);
        }
        return "";
    }
}

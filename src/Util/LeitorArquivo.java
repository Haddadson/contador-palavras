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
 * @author Gabriel Haddad
 */
public class LeitorArquivo {
    private static final String CAMINHO_ARQUIVO = "src/Util/texto.txt";
    
    public static String lerArquivo(String caminhoArquivo){
        if(caminhoArquivo == null || caminhoArquivo.isEmpty())
            caminhoArquivo = CAMINHO_ARQUIVO;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Files.newBufferedReader(Paths.get(caminhoArquivo))
                    .lines()
                    .forEach(linha -> {
                        stringBuilder.append(linha);
                        stringBuilder.append(System.lineSeparator());
                    });
            System.out.println(stringBuilder.toString());
            return stringBuilder.toString();
        } catch (IOException ex) {
            System.out.println("Erro ao ler: " + ex);
        }
        return "";
    }
}

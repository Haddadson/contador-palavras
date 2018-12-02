package Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe para possibilitar a leitura do texto de um arquivo
 * 
 * @author Gabriel Haddad
 */
public class LeitorArquivo {
    private static final String CAMINHO_ARQUIVO = "src/Util/texto.txt";
    
    
    /**
     * Método para ler o texto de um texto no caminho informado, caso o caminho
     * não seja válido, lê o texto padrão
     *
     * @author Gabriel Haddad
     * @param caminhoArquivo String - Caminho do arquivo a ser lido 
     * @return String - Retorna o texto presente no arquivo em formato de String
     */
    public static String lerArquivo(String caminhoArquivo){
        if(caminhoArquivo == null || caminhoArquivo.isEmpty()){
            System.out.println("Caminho informado está nulo ou vazio, "+
                               "será utilizado o arquivo padrão localizado em: "+
                               CAMINHO_ARQUIVO);
            caminhoArquivo = CAMINHO_ARQUIVO;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Files.newBufferedReader(Paths.get(caminhoArquivo))
                    .lines()
                    .forEach(linha -> {
                        stringBuilder.append(linha);
                        stringBuilder.append(System.lineSeparator());
                    });
            return stringBuilder.toString();
        } catch (IOException ex) {
            System.out.println("Erro ao ler: " + ex);
        }
        return "";
    }
}

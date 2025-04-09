package SalvarRespostas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SalvarEmArquivo {
    public void salvarRespostasEmArquivo(Map<String, String> respostas) {

        String nomeCompleto = respostas.get("1 - Qual o nome e sobrenome do pet?");


        String nomeFormatado = nomeCompleto.replace(" ", "").toUpperCase();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm"));
        String nomeArquivo = timestamp + "-" + nomeFormatado + ".txt";


        File pasta = new File("petsCadastrados");
        if (!pasta.exists()) {
            if (!pasta.mkdir()) {
                System.err.println("Erro ao criar a pasta petsCadastrados.");
                return;
            }
        }


        File arquivo = new File(pasta, nomeArquivo);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (String resposta : respostas.values()) {
                writer.write(resposta);
                writer.newLine();
            }
            System.out.println("Arquivo salvo com sucesso: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}

import SalvarRespostas.SalvarEmArquivo;
import validacoes.ValidarEntradas;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintForm {

    ValidarEntradas validarEntradas = new ValidarEntradas();
    SalvarEmArquivo salvarEmArquivo = new SalvarEmArquivo();

    public Map<String, String> printForm() {
        File file = new File("formulario.txt");
        Map<String, String> respostas = new LinkedHashMap<>(); // Mantém a ordem de inserção
        try (BufferedReader br = new BufferedReader(new FileReader(file));
             Scanner scanner = new Scanner(System.in)) {

            String pergunta;
            while ((pergunta = br.readLine()) != null) {
                if (!pergunta.trim().isEmpty()) {
                    System.out.println(pergunta);

                    String resposta = " ";
                    switch (pergunta) {
                        case "1 - Qual o nome e sobrenome do pet?":
                            resposta = validarEntradas.validarNome(scanner);
                            break;
                        case "2 - Qual o tipo do pet (Cachorro/Gato)?":
                            resposta = validarEntradas.validarTipo(scanner);
                            break;
                        case "3 - Qual o sexo do animal? (Macho/Fêmea)?":
                            resposta = validarEntradas.validarSexo(scanner);
                            break;
                        case "4 - Qual endereço e bairro que ele foi encontrado?":
                            resposta = validarEntradas.capturarEndereco(scanner);
                            break;
                        case "5 - Qual a idade aproximada do pet?":
                            resposta = validarEntradas.validarIdade(scanner);
                            break;
                        case "6 - Qual o peso aproximado do pet?":
                            resposta = validarEntradas.validarPeso(scanner);
                            break;
                        case "7 - Qual a raça do pet?":
                            resposta = validarEntradas.validarRaca(scanner);
                            break;
                        default:
                            resposta = scanner.nextLine().trim();
                            if (resposta.isEmpty()) {
                                resposta = ValidarEntradas.NAOINFORMADO;
                            }
                    }
                    respostas.put(pergunta, resposta);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        salvarEmArquivo.salvarRespostasEmArquivo(respostas);
        return respostas;
    }

}
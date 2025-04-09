
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        while (true) {
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine();
                if (escolha >= 1 && escolha <= 6) {
                    break;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Opção inválida! Tente novamente.\n");
        }
        switch (escolha) {

            case 1:
                PrintForm printForm = new PrintForm();
                Map<String, String> respostas = printForm.printForm();
                System.out.println("\nRespostas cadastradas:");
                respostas.forEach((pergunta, resposta) ->
                        System.out.println(pergunta + ": " + resposta));
                break;
            case 6:
                System.out.println("Saindo...");
                return;
        }


//
        scanner.close();
    }
}
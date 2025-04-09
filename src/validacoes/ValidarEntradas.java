package validacoes;

import Enum.SexoPet;
import Enum.TipoPet;

import java.util.Scanner;

public class ValidarEntradas {
    public static final String NAOINFORMADO = "NAO_INFORMADO";

    public String validarNome(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Digite o nome e sobrenome do pet: ");
                String nome = scanner.nextLine().trim();
                if (nome.matches("^[a-zA-Z]+\\s[a-zA-Z\\s]+$")) {
                    return nome;
                } else if (nome.isEmpty()) {
                    return NAOINFORMADO;
                } else {
                    throw new IllegalArgumentException("Nome inválido! O nome deve conter apenas letras e espaços.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validarSexo(Scanner scanner) {
        while (true) {
            try {

                String entrada = scanner.nextLine().trim().toUpperCase();
                if (entrada.isEmpty()) {
                    return SexoPet.NAO_INFORMADO.name();
                }

                for (SexoPet sexoPet : SexoPet.values()) {
                    if (sexoPet.name().equals(entrada)) {
                        return sexoPet.name();
                    }
                }
                throw new IllegalArgumentException("Sexo inválido! Escolha entre: MACHO ou FEMEA.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validarTipo(Scanner scanner) {
        while (true) {
            try {

                String entrada = scanner.nextLine().trim().toUpperCase();
                if (entrada.isEmpty()) {
                    return TipoPet.NAO_INFORMADO.name();
                }
                for (TipoPet tipo : TipoPet.values()) {
                    if (tipo.name().equals(entrada)) {
                        return tipo.name();
                    }
                }
                throw new IllegalArgumentException("Tipo inválido! Escolha entre: CACHORRO ou GATO.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String capturarEndereco(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Número da casa: ");
                String numero = scanner.nextLine().trim();
                if (numero.isEmpty()) {
                    numero = NAOINFORMADO;
                }

                System.out.print("Cidade: ");
                String cidade = scanner.nextLine().trim();
                if (cidade.isEmpty()) {
                    cidade = NAOINFORMADO;
                }

                System.out.print("Rua: ");
                String rua = scanner.nextLine().trim();
                if (rua.isEmpty()) {
                    rua = NAOINFORMADO;
                }

                return "Número: " + numero + ", Cidade: " + cidade + ", Rua: " + rua;
            } catch (Exception e) {
                System.out.println("Erro ao capturar o endereço: " + e.getMessage());
            }
        }
    }

    public String validarIdade(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Digite a idade aproximada do pet (em anos ou meses): ");
                String entrada = scanner.nextLine().trim().replace(",", ".");
                double idade = Double.parseDouble(entrada);
                if (idade > 20) {
                    throw new IllegalArgumentException("Idade inválida! A idade não pode ser maior que 20 anos.");
                } else if (idade < 1) {
                    return String.format("%.1f anos", idade);
                }
                return String.format("%.1f anos", idade);
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida! Digite apenas números.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validarPeso(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Digite o peso aproximado do pet (em kg): ");
                String entrada = scanner.nextLine().trim().replace(",", ".");
                double peso = Double.parseDouble(entrada);
                if (peso < 0.5 || peso > 60) {
                    throw new IllegalArgumentException("Peso inválido! O peso deve estar entre 0.5kg e 60kg.");
                }
                return String.format("%.1f kg", peso);
            } catch (NumberFormatException e) {
                System.out.println("Peso inválido! Digite apenas números.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validarRaca(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Digite a raça do pet: ");
                String raca = scanner.nextLine().trim();
                if (raca.matches("^[a-zA-Z\\s]+$")) {
                    return raca;
                } else if (raca.isEmpty()) {
                    return NAOINFORMADO;
                } else {
                    throw new IllegalArgumentException("Raça inválida! A raça deve conter apenas letras e espaços.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
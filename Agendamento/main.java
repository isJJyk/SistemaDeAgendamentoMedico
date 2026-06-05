package Agendamento;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        agenda agenda = new agenda();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        if (!agenda.verificarCadastro(cpf)) {
            System.out.println("CPF não cadastrado. Encerrando.");
            return;
        }

        System.out.println("\nEspecialidades disponíveis:");
        for (Especialidade esp : Especialidade.values()) {
            System.out.println("- " + esp.getNome());
        }

        System.out.print("Digite a especialidade desejada: ");
        String espDigitada = scanner.nextLine();

        if (!agenda.verificarEspecialidade(espDigitada)) {
            System.out.println("Especialidade inválida.");
            return;
        }

        System.out.println("\n--- Seleção de Horário ---");
        agenda.horariosDisponiveis();

        System.out.print("Escolha o número do horário: ");
        int opcao = scanner.nextInt();

        agenda.agendarHorario(opcao);

        System.out.println("\n--- Verificando horários restantes ---");
        agenda.horariosDisponiveis();

        scanner.close();
    }
}

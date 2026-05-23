package SistemaDeAgendamentoMedico;

import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        agenda genda = new agenda();

        System.out.print("Informe o seu CPF: ");
        String cpf = sc.next();
        sc.nextLine();

        System.out.print("Informe o seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Informe a especialidade desejada: ");
        String esp = sc.nextLine();

        project paciente = new project(cpf, nome);

        if (!genda.verificarCadastro(paciente.getCpf())) {
            System.out.println("Paciente não cadastrado.");
            System.out.println("Encerramento do sistema.");
            System.exit(0);
        }
        if (!genda.verificarEspecialidade(esp)) {
            System.out.println("Não há horários disponíveis.");
            System.out.println("Encerramento do sistema.");
            System.exit(0);
        }
        genda.HorariosDisponiveis();
        System.out.print("Escolha o número do horário desejado: ");
        int HDisp = sc.nextInt();

        boolean hragendada = genda.agendarHorario(HDisp);

        if (hragendada) {
            System.out.println("Confirmação enviada para " + paciente.getNome());
            System.out.println("Consulta agendada com sucesso.");
        }
        System.out.println("Encerramento do sistema. Obrigado!");
        sc.close();
    }
}

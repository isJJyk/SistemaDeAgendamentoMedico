package Agendamento.application;

import Agendamento.entities.JDBC.ClassConnection;
import Agendamento.entities.enums.Especialidade;
import Agendamento.entities.enums.Horario;
import Agendamento.entities.objects.Agenda;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);


        try {
            System.out.print("Nome: ");

            String nome = sc.nextLine();

            System.out.print("CPF: ");

            String cpf = sc.nextLine();

            Agenda paciente = new Agenda(nome, cpf);

            if (!paciente.verificarCadastro()) {
                System.out.println("CPF não cadastrado. Encerrando.");
                return;

            }

            System.out.println("\nEspecialidades disponíveis:");

            for (Especialidade esp : Especialidade.values()) {
                System.out.println("- " + esp.getNome());
            }

            System.out.print("Digite a especialidade desejada: ");

            String especialidadeDigitada = sc.nextLine();

            Agenda especialidade = new Agenda(especialidadeDigitada);

            if (!especialidade.verificarEspecialidade()) {
                System.out.println("Especialidade inválida.");
                return;
            }

            System.out.println("\n--- Seleção de Horário ---");
            especialidade.horariosDisponiveis();

            System.out.print("Escolha o número do horário: ");

            int opcao = sc.nextInt();

            Agenda horario = new Agenda(opcao);

            horario.agendarHorario();

            System.out.println("\n--- Verificando horários restantes ---");
            horario.horariosDisponiveis();

            sc.close();

            Connection conexao = ClassConnection.getConnection();

            String pacientes_dados = "INSERT INTO pacientes (CPF, nome) VALUES("+cpf+",'"+nome+"');";
            String especialidade_dados = "INSERT INTO especialidadesmedicas (especialidades) " +
                    "VALUES('"+Especialidade.CARDIOLOGIA+"'),('"+Especialidade.ORTOPEDIA+"'),('"+Especialidade.PEDIATRIA+"');";
            String horarios_dados = "INSERT INTO horario (horarios)" +
                    "VALUES('"+ Horario.MANHA_09+"'),('"+Horario.TARDE_14+"'),('"+Horario.TARDE_16+"');";
            String manha = "Delete from horario where horarios = 'MANHA_09' ";
            String tardeUm = "Delete from horario where horarios = 'TARDE_14'";
            String tardeDois = "Delete from horario where horarios = 'TARDE_16'";

            Statement stmt = conexao.createStatement();
            stmt.execute(pacientes_dados);
            stmt.execute(especialidade_dados);
            stmt.execute(horarios_dados);

            if (opcao == 1){
                stmt.execute(manha);
            } else if (opcao == 2) {
                stmt.execute(tardeUm);
            } else if (opcao == 3) {
                stmt.execute(tardeDois);
            }

            conexao.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

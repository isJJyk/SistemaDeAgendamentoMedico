package Agendamento.entities.objects;

import Agendamento.entities.enums.Especialidade;
import Agendamento.entities.enums.Horario;

public class Agenda {
    private String nome;
    private String cpf;
    private String especialidadeDigitada;
    private int opcao;
    private final String[] cpfs = {"12345678900", "98765432100", "11122233344"};

    public Agenda(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Agenda(String especialidadeDigitada) {
        this.especialidadeDigitada = especialidadeDigitada;
    }

    public Agenda(int opcao) {
        this.opcao = opcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEspecialidadeDigitada() {
        return especialidadeDigitada;
    }

    public void setEspecialidadeDigitada(String especialidadeDigitada) {
        this.especialidadeDigitada = especialidadeDigitada;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public boolean verificarCadastro() {
        for (String c : cpfs) {
            if (c.equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarEspecialidade() {
        for (Especialidade esp : Especialidade.values()) {
            if (esp.getNome().equalsIgnoreCase(especialidadeDigitada)) {
                return true;
            }
        }
        return false;
    }

    public void horariosDisponiveis() {
        System.out.println("Horários disponíveis:");
        Horario[] horarios = Horario.values();
        for (int i = 0; i < horarios.length; i++) {
            if (!horarios[i].isOcupado()) {
                System.out.println((i + 1) + " - " + horarios[i].getHora());
            }
        }
    }

    public boolean agendarHorario() {
        Horario[] horarios = Horario.values();
        int op = opcao - 1;

        if (op < 0 || op >= horarios.length) {
            System.out.println("Opção de horário inválida.");
            return false;
        }

        Horario horarioSelecionado = horarios[op];

        if (horarioSelecionado.isOcupado()) {
            System.out.println("Horário indisponível.");
            return false;
        }

        horarioSelecionado.setOcupado(true);
        System.out.println("Agendamento realizado para às " + horarioSelecionado.getHora() + "!");
        return true;
    }
}

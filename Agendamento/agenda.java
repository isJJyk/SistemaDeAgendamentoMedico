package Agendamento;

public class agenda {
    private String[] cpfs = {"12345678900", "98765432100", "11122233344"};

    public boolean verificarCadastro(String cpf) {
        for (String c : cpfs) {
            if (c.equals(cpf)) {
                return true;
            }
        }
        return false;
    }
    public boolean verificarEspecialidade(String especialidadeDigitada) {
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
    public boolean agendarHorario(int opcao) {
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

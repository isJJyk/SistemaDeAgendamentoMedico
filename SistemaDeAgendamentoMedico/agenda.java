package SistemaDeAgendamentoMedico;

public class agenda {

    private String[] cpfs = {"12345678900", "98765432100", "11122233344"};
    private String[] especialidades = {"Cardiologia", "Pediatria", "Ortopedia"};
    private String[] horarios = {"09:00", "14:00", "16:00"};
    private boolean[] horarioOcu = {false, false, false};

    public boolean verificarCadastro(String cpf) {
        for (String c : cpfs) {
            if (c.equals(cpf)) {
                return true;
            }
        }
        return false;
    }
    public boolean verificarEspecialidade(String especialidade) {
        for (String esp : especialidades) {
            if (esp.equalsIgnoreCase(especialidade)) {
                return true;
            }
        }
        return false;
    }
    public void HorariosDisponiveis() {
        System.out.println("Horários disponíveis para a especialidade:");
        for (int i = 0; i < horarios.length; i++) {
            if (!horarioOcu[i]) {
                System.out.println((i + 1) + " - " + horarios[i]);
            }
        }
    }
    public boolean agendarHorario(int opcao) {
        int op = opcao - 1;
        if (op < 0 || op >= horarios.length) {
            System.out.println("Opção de horário inválida.");
            return false;
        }
        if (horarioOcu[op]) {
            System.out.println("Horário indisponível.");
            return false;
        }
        horarioOcu[op] = true;
        return true;
    }
}
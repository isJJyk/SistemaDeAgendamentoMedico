package Agendamento;

public enum Especialidade {
    CARDIOLOGIA("Cardiologia"),
    PEDIATRIA("Pediatria"),
    ORTOPEDIA("Ortopedia");

    private final String nome;

    Especialidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

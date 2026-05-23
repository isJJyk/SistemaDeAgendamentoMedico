package SistemaDeAgendamentoMedico;

public class project {

    private String cpf;
    private String nome;

    public project() {
        this.cpf = "";
        this.nome = "Anônimo";
    }
    public project(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

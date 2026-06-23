package Agendamento;

public enum Horario {

    MANHA_09("09:00"),
    TARDE_14("14:00"),
    TARDE_16("16:00");

    private final String hora;
    private boolean ocupado;

    Horario(String hora) {
        this.hora = hora;
        this.ocupado = false;
    }

    public String getHora() {
        return hora;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}

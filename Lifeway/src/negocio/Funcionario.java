package negocio;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private String matricula;
    private String cargo;

    /**
     * Construtor: Funcionario
     * @param nome
     * @param identificacao
     * @param dataNascimento
     * @param matricula
     * @param cargo
     */
    public Funcionario(String nome, String identificacao, LocalDate dataNascimento, String matricula, String cargo) {
        super(nome, identificacao, dataNascimento);
        this.matricula = matricula;
        this.cargo = cargo;
    }

    // Getters & Setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}

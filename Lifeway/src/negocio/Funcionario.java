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
    
    
    
    /**
     * Equals: Funcionario (compara id e matricula)
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Funcionario) {
            Funcionario param = (Funcionario) obj;
            if ( (param.getIdentificacao() != null) 
                && param.getIdentificacao().equals(this.getIdentificacao()) 
                && param.getMatricula().equals(this.getMatricula()) ) {
                    resultado = true;
                }
        }
        return resultado;
    }

   
    /**
     * toString: Pessoa: nome, id, data de nascimento
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + "Nome: " + this.getNome();
        resultado += "\n" + "Data de Nascimento: " + this.getDataNascimento();
        resultado += "\n" + "Identificação: " + this.getIdentificacao();
        return resultado;
    }
     
}

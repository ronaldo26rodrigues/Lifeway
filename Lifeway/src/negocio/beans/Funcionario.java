package negocio.beans;

import java.time.LocalDate;

public class Funcionario extends Usuario {

    private String idEmpresa;
    private Empresa empresa;

    public Funcionario(String nome, String identificacao, String senha, LocalDate dataDeNascimeto, Empresa empresa) {
        super(nome, identificacao, senha, dataDeNascimeto);
        this.empresa = empresa;
        this.idEmpresa = empresa.getIdEmpresa();
    }

    @Override
    public String getTipo() {
        return "FUNCIONARIO";
    }

    /**
     * toString: Funcionário: nome, id, data de nascimento, matrícula, cargo
     */
    @Override
    public String toString() {
        String resultado = super.toString();
        resultado += "\n" + "Empresa: " + this.getEmpresa().getNome();
        return resultado;
    }

    @Override
    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }

    // Getters & Setters

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}

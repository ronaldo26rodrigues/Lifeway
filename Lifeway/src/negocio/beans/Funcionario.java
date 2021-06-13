package negocio.beans;

public class Funcionario extends Usuario {

    //private String cargo;
    //empresa do funcionario:
    private String idEmpresa;

    public Funcionario(String nome, String identificacao, String senha, String idEmpresa) {
        super(nome, identificacao, senha);
        this.idEmpresa = idEmpresa;
        //cargo?
    }

    //private String matricula;



    // Getters & Setters

    

    /* public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    } */
    
    
    
    // /**
    //  * Equals: Funcionario (compara id e matricula)
    //  */
    // @Override
    // public boolean equals(Object obj) {
    //     boolean resultado = false;
    //     if (obj instanceof Funcionario) {
    //         Funcionario param = (Funcionario) obj;
    //         if ( (param.getIdentificacao() != null) 
    //             && param.getIdentificacao().equals(this.getIdentificacao()) 
    //             /* && param.getMatricula().equals(this.getMatricula()) */ ) {
    //                 resultado = true;
    //             }
    //     }
    //     return resultado;
    // }

   
    /**
     * toString: Funcionário: nome, id, data de nascimento, matrícula, cargo
     */
    @Override
    public String toString() {
        String resultado = super.toString();
        // resultado += "\n" + "Matrícula" + this.getMatricula();
        resultado += "\n" + "Empresa: " + this.getIdEmpresa();
        return resultado;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public boolean validar() {
        // TODO Auto-generated method stub
        return true;
    }
     
}

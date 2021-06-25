package negocio.beans;

public class Funcionario extends Usuario {

    private String idEmpresa;
    private Empresa empresa;

    //recebe o objeto empresa
    public Funcionario(String nome, String identificacao, String senha, Empresa empresa, String idEmpresa) {
        super(nome, identificacao, senha);
        this.empresa = empresa;
        this.idEmpresa = idEmpresa;

        //buscar empresa por ID
    }

    //não recebe o objeto empresa mas recebe a id
    public Funcionario(String nome, String identificacao, String senha, String idEmpresa) {
        super(nome, identificacao, senha);
        this.idEmpresa = idEmpresa;

        //buscar empresa por ID
    }


    @Override
    public String getTipo() {
        return "FUNCIONÁRIO";
    }


    

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

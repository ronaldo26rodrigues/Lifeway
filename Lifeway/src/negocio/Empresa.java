package negocio;

public class Empresa {
    
    private String nome;
    private String servico;
    private String identificacao;

    Empresa(String nome, String servico, String identificacao) {
        this.nome = nome;
        this.servico = servico;
        this.identificacao = identificacao;
    }


    //method(type): type

    // Getters & Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
    
    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }


    /**
     * Equals: Empresa (compara id e tipo de serviço)
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Empresa) {
            Empresa param = (Empresa) obj;
            if ( (param.getIdentificacao() != null) 
                && param.getIdentificacao().equals(this.getIdentificacao()) 
                && param.getServico().equals(this.getServico()) ) {
                    resultado = true;
                }
        }
        return resultado;
    }

    /**
     * toString: Empresa
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "\n" + "Nome: " + this.getNome();
        resultado += "\n" + "Identificação: " + this.getIdentificacao();
        resultado += "\n" + "Serviço: " + this.getServico();
        return resultado;
    }

    

}

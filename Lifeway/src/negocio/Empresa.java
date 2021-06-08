package negocio;

public class Empresa {
    
    private String nome;
    private String servico;

    Empresa(String nome, String servico) {
        this.nome = nome;
        this.servico = servico;
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




    

}

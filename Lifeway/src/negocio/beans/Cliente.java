package negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private List<Propriedade> propriedades;

    public Cliente(String nome, String identificacao, String senha, LocalDate dataNascimento) {
        super(nome, identificacao, senha, dataNascimento);

        this.propriedades = new ArrayList<>();
    }

    @Override
    public String getTipo() {
        return "CLIENTE";
    }

    // Getters & Setters

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    

    /**
     * Equals: Cliente (compara id)
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Cliente) {
            Cliente param = (Cliente) obj;
            if ((param.getIdentificacao() != null) && param.getIdentificacao().equals(this.getIdentificacao())) {
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
        resultado += super.toString();
        return resultado;
    }

}

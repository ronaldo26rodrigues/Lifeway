package excecoes;

public class MenorDeIdadeException extends Exception{
 
    public MenorDeIdadeException(){
       super("É preciso ter mais de 18 anos para utilizar nosso serviço.");
    } 
}

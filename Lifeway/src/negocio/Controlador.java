package negocio;

public class Controlador {
    
    private static Controlador instance;

    private ControladorEmpresas controladorEmpresas;
    private ControladorFuncionarios controladorFuncionarios;
    private ControladorConsumidores controladorConsumidores;
    private ControladorContas controladorContas;

    private Controlador() {
        //construtor privado
        this.controladorEmpresas = controladorEmpresas.getInstance();
        this.controladorFuncionarios = controladorFuncionarios.getInstance();
        this.controladorContas = controladorContas.getInstance();
        this.controladorConsumidores = controladorConsumidores.getInstance();
    }

    public static Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }

    

}

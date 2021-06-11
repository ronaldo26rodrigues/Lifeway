package negocio.bdr;
import java.sql.*;
import java.sql.ResultSet;

import negocio.beans.Empresa;

public class ControladorBDR {
    private Connection conn;
    private Statement stm;

    private static ControladorBDR instance;

    private ControladorBDR() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + "lifewayDB.db");
        this.stm = conn.createStatement();
    }

    public static ControladorBDR getInstance()  throws SQLException, ClassNotFoundException{
        if(instance == null){
            instance = new ControladorBDR();
        }
        return instance;
    }

    public void criarEmpresa(String nome, String servico, String idEmpresa) {
        try {
            this.stm.executeUpdate("CREATE TABLE IF NOT EXSTS empresas ( id TEXT, nome TEXT, servico TEXT");

            this.stm.executeUpdate("INSERT INTO empresas VALUES(" + idEmpresa +", "+ nome + ", "+servico+")");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public Empresa buscarEmpresa(String idEmpresa) {
        Empresa empresaEncontrada = null;
        ResultSet rs = null;
        try {
            rs = this.stm.executeQuery("SELECT * FROM empresas WHERE id = " + idEmpresa);
            while (rs.next()) {
                empresaEncontrada = new Empresa(rs.getString("id"), rs.getString("nome"), rs.getString("servico"));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        return empresaEncontrada;
    }




}

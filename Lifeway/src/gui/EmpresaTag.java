package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import negocio.beans.Empresa;

public class EmpresaTag extends HBox {
    private Label nomeEmpresa;
    private Label iconX;
    private Empresa empresa;

    public EmpresaTag(Empresa empresa) {
        
        nomeEmpresa = new Label(empresa.getNome() + ", ");
        iconX = new Label(null, new ImageView(new Image("gui/imgs/x.png")));

        iconX.setOnMouseEntered(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                getScene().setCursor(Cursor.HAND);
            }
        });

        iconX.setOnMouseExited(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                getScene().setCursor(Cursor.DEFAULT);
            }
        });

        getChildren().addAll(iconX, nomeEmpresa);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Label getIconX() {
        return iconX;
    }
}

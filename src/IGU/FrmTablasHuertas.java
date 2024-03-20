package IGU;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import Back.Huertas;

public class FrmTablasHuertas extends JFrame{
    JPanel panel;
    JScrollPane tablaHuertas;
    static ArrayList<Huertas> propietarios = new ArrayList<Huertas>();
    JButton btnRegresar;

    public FrmTablasHuertas(Inicio frmInicio) {
        // Panel
        panel = new JPanel();
        add(panel);
    
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(300, 500, 80, 25);
        btnRegresar.addActionListener(
            new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                frmInicio.setVisible(true);

            }
        });
        panel.add(btnRegresar);

         if (new File("././src/Huertas.cvs").exists()) {
            tablaHuertas = new Tabla().TablaHuertas();
            panel.add(tablaHuertas);
        } else {
            JLabel mensaje = new JLabel("No hay huertas registradas");
            mensaje.setBounds(100, 250, 10, 30);
            panel.add(mensaje);
        }

        setTitle("Huertas");
        setSize(500, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }
}

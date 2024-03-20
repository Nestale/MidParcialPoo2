package IGU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Inicio extends javax.swing.JFrame {

    JPanel panel;
    JLabel mensaje;
    JButton registrarHuerta, tablaHuertas;

    public Inicio() {
        // Panel
        panel = new JPanel();
        add(panel);

        registrarHuerta = new JButton("Registrar Propietario ");
        registrarHuerta.setBounds(100, 100, 10, 30);
        registrarHuerta.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new FrmRegistro(Inicio.this);

                    }
                });
        panel.add(registrarHuerta);

        tablaHuertas = new JButton("Tabla de Huertas");
        tablaHuertas.setBounds(100, 100, 10, 30);
        tablaHuertas.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new FrmTablasHuertas(Inicio.this);

                    }
                });
        panel.add(tablaHuertas);
        
        
        // config ventana
        setTitle("Quiz 1");
        setSize(500, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

}

package IGU;

import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.*;
import Back.Huertas;
import java.awt.*;

public class FrmRegistro extends JFrame {

    JLabel lblNombres, lblAncho, lblLargo, titleLabel;
    JTextField txtNombres, txtAncho, txtLargo;
    JButton btnRegistrar, btnRegresar;
    JPanel panel;

    public FrmRegistro(Inicio frmInicio) {
        
        setTitle("Registrar Usuario");
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE); 
        add(panel);

        
        titleLabel = new JLabel("Registro de Huertas");
        titleLabel.setBounds(180, 10, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 128, 0));
        panel.add(titleLabel);

    
        lblNombres = new JLabel("Nombre:");
        lblNombres.setBounds(10, 50, 70, 25);
        lblNombres.setForeground(new Color(0, 128, 0)); 
        panel.add(lblNombres);
        txtNombres = new JTextField();
        txtNombres.setBounds(90, 50, 120, 25);
        panel.add(txtNombres);

        lblAncho = new JLabel("Ancho:");
        lblAncho.setBounds(10, 90, 70, 25);
        lblAncho.setForeground(new Color(0, 128, 0)); 
        panel.add(lblAncho);
        txtAncho = new JTextField();
        txtAncho.setBounds(90, 90, 120, 25);
        panel.add(txtAncho);

        lblLargo = new JLabel("Largo:");
        lblLargo.setBounds(10, 130, 70, 25);
        lblLargo.setForeground(new Color(0, 128, 0)); 
        panel.add(lblLargo);
        txtLargo = new JTextField();
        txtLargo.setBounds(90, 130, 120, 25);
        panel.add(txtLargo);

        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(90, 170, 100, 25);
        btnRegistrar.setForeground(new Color(0, 128, 0)); 
        btnRegistrar.addActionListener(
            e -> {
                Huertas huertas = new Huertas(txtNombres.getText(), Integer.parseInt(txtAncho.getText()), Integer.parseInt(txtLargo.getText()));
                JOptionPane.showMessageDialog(null, "Huerta registrada");
                ingresarHuerta(huertas);
                dispose();
                frmInicio.setVisible(true);
            });
        panel.add(btnRegistrar);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(220, 170, 100, 25);
        btnRegresar.setForeground(new Color(0, 128, 0)); 
        btnRegresar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                    frmInicio.setVisible(true);
                }
            });
        panel.add(btnRegresar);
    }

    private static void ingresarHuerta(Huertas huerta) {
        File f = new File("./src/Huertas.cvs");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try (FileWriter fw = new FileWriter(f, true)) {
            fw.write(huerta.toCVS() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

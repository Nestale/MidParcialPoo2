package IGU;

import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.*;
import Back.Huertas;

public class FrmRegistro extends JFrame {

    JLabel lblNombres, lblAncho, lblLargo;
    JTextField txtNombres, txtAncho, txtLargo;
    JButton btnRegistrar, btnRegresar;
    JPanel panel;

    public FrmRegistro(Inicio frmInicio) {

        // Panel
        panel = new JPanel();
        add(panel);

        // inputs
        lblNombres = new JLabel("Nombre");
        lblNombres.setBounds(10, 50, 70, 25);
        panel.add(lblNombres);
        txtNombres = new JTextField(15);
        panel.add(txtNombres);

        lblAncho = new JLabel("Ancho");
        lblAncho.setBounds(80, 80, 70, 25);
        panel.add(lblAncho);
        txtAncho = new JTextField(15);
        panel.add(txtAncho);

        lblLargo = new JLabel("Largo");
        lblLargo.setBounds(80, 80, 70, 25);
        panel.add(lblLargo);
        txtLargo = new JTextField(15);
        panel.add(txtLargo);

        // Botones
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(100, 500, 80, 25);
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

        setTitle("Registrar Usuario");
        setSize(500, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
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

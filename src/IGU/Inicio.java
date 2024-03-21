package IGU;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {

    JButton jButton1, jButton2;
    JPanel buttonPanel, panel;

    public Inicio() {
        initComponents();
    }

    private void initComponents() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); 


        JLabel jLabel1 = new JLabel("Agrocity", JLabel.CENTER);
        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 30));
        jLabel1.setForeground(new Color(153, 255, 153));

        JLabel jLabel2 = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/FondoFinal.jpg")));

        panel.add(jLabel1, BorderLayout.PAGE_START);
        panel.add(jLabel2, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 255, 255));
        buttonPanel.setLayout(new GridLayout(2, 1, 0, 20)); 
        jButton1 = new JButton();
        jButton1.setBackground(new Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14));
jButton1.setText("Registrar Propietarios");
        jButton1.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton1);

        jButton2 = new JButton();
        jButton2.setBackground(new Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14));
        jButton2.setText("Tabla de huertas");
        jButton2.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton2);

        panel.add(buttonPanel, BorderLayout.LINE_START);
        panel.add(jLabel1, BorderLayout.PAGE_START);

        getContentPane().add(panel);
        pack();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        setVisible(false);
        new FrmRegistro(this).setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        setVisible(false);
        new FrmTablasHuertas(this).setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
}    

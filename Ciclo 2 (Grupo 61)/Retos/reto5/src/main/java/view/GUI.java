package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

import controller.ControladorRequerimientosReto4;

public class GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento2;
    private JButton btnRequerimiento3;
    private JButton btnCRUD_Materiales;

    //Constructor realizar la composición de la ventana
    public GUI(){

    }

    private ImageIcon redimensionarIcono ( ImageIcon icono, int pixeles ) {        
        Image image = icono.getImage(); 
        Image newimg = image.getScaledInstance(pixeles, pixeles, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    //Método para composición
    public void iniciarGUI ( ControladorRequerimientosReto4 controlador ) {
        
        //Propiedades del frame
        setTitle("RETO #5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnRequerimiento1 = new JButton(redimensionarIcono(new ImageIcon("Imagenes/project.png"), 45));
        btnRequerimiento1.setText("  Ranking Proyectos");
        btnRequerimiento1.addActionListener(controlador);
        btnRequerimiento1.setActionCommand("rankingProyectos");
        
        btnRequerimiento2 = new JButton(redimensionarIcono(new ImageIcon("Imagenes/bank.png"), 45));
        btnRequerimiento2.setText("  Bancos");
        btnRequerimiento2.addActionListener(controlador);        
        btnRequerimiento2.setActionCommand("rankingBancos");

        btnRequerimiento3 = new JButton(redimensionarIcono(new ImageIcon("Imagenes/paper-crafts.png"), 45));
        btnRequerimiento3.setText("  Materiales Importados"); 
        btnRequerimiento3.addActionListener(controlador);        
        btnRequerimiento3.setActionCommand("rankingMaterialesImportados");  
        
        btnCRUD_Materiales = new JButton(redimensionarIcono(new ImageIcon("Imagenes/edition.png"), 45));
        btnCRUD_Materiales.setText("  Gestión Materiales"); 
        btnCRUD_Materiales.addActionListener(controlador);        
        btnCRUD_Materiales.setActionCommand("crudMateriales");       

        
        //Componente intermedio
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.add(btnRequerimiento1);
        panel.add(btnRequerimiento2);
        panel.add(btnRequerimiento3);
        panel.add(btnCRUD_Materiales);
        
        //Contenedor
        getContentPane().add( panel );        

        //Mostrar ventana/frame
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
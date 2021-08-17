package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;

import controller.ControladorRequerimientosReto4;
import model.vo.MaterialConstruccion;
import util.JDBCUtilities;

public class CRUD_Materiales_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    private JTable jtMateriales;
    private JButton btnAdicionar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JTextField txtNombreMaterial;
    private JTextField txtImportado;
    private JTextField txtPrecioUnidad;
    private JLabel lblNombreMaterial;
    private JLabel lblImportado;
    private JLabel lblPrecioUnidad;  
    private DefaultTableModel modeloTablaMateriales; 

    //Constructor realizar la composición de la ventana
    public CRUD_Materiales_GUI ( ArrayList<MaterialConstruccion> materiales, ControladorRequerimientosReto4 controlador ) {

        //Propiedades del frame
        setTitle("Gestión de Materiales de Construcción");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());      
        GridBagConstraints constraints = new GridBagConstraints();

        //Construcción de la tabla que presentará los materiales
        String[] encabezado = {"ID Material", "Nombre", "Importado", "Precio Unitario"};
        this.jtMateriales = new JTable(this.formatoRegistros(materiales, encabezado.length), encabezado);
        JScrollPane sp = new JScrollPane(this.jtMateriales);

        modeloTablaMateriales = new DefaultTableModel(this.formatoRegistros(materiales, encabezado.length), encabezado){
            
            //Personalizar quién no es editable
            @Override
            public boolean isCellEditable(int row, int column) {                
                
                //Que sea editable cuando la columna es diferente de la primera
                return column != 0;

                //Establecer cuáles son editables (Ejemplo Alex)
                //return column == 1 || column == 3;
            }             

        };
        this.jtMateriales = new JTable(modeloTablaMateriales);

        //Componente intermedio tabla con los materiales
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Materiales del SI"));
        panel.add(sp);  

        //Componente intermedio para formulario de adición de material
        JPanel panelFormularioAdicion = new JPanel(new GridLayout());
        panelFormularioAdicion.setBorder(new TitledBorder("Registro de Materiales del SI"));
        
        this.lblNombreMaterial = new JLabel("Nombre Material: ",SwingConstants.RIGHT);
        this.lblImportado = new JLabel("Importado: ",SwingConstants.RIGHT);        
        this.lblPrecioUnidad = new JLabel("Precio Unitario: ",SwingConstants.RIGHT);

        this.txtNombreMaterial = new JTextField();
        this.txtImportado = new JTextField();        
        this.txtPrecioUnidad = new JTextField();        
        
        panelFormularioAdicion.add(this.lblNombreMaterial);
        panelFormularioAdicion.add(this.txtNombreMaterial);
        panelFormularioAdicion.add(this.lblImportado);
        panelFormularioAdicion.add(this.txtImportado);
        panelFormularioAdicion.add(this.lblPrecioUnidad);
        panelFormularioAdicion.add(this.txtPrecioUnidad);

        //Componente intermedio de botones
        JPanel panelBotones = new JPanel(new GridLayout(1,3));
        panelBotones.setBorder(new TitledBorder("Acciones"));

        btnAdicionar = new JButton(redimensionarIcono(new ImageIcon("Imagenes/add.png"), 24));
        btnAdicionar.setText("  Adicionar"); 
        btnAdicionar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(ActionEvent e) {  
                Connection conexion = null;        

                try{
                    conexion = JDBCUtilities.getConnection();

                    String consulta = "INSERT INTO MaterialConstruccion(Nombre_Material, Importado, Precio_Unidad)" +
                                    "VALUES ('" + txtNombreMaterial.getText()  + "', '" + 
                                    txtImportado.getText() + "', " + txtPrecioUnidad.getText() + ");";

                    PreparedStatement statement = conexion.prepareStatement(consulta);
                
                    //Abiertas esas interacciones con BD
                    statement.executeUpdate();
                    statement.close();

                } catch( SQLException e2 ) {
                    System.err.println("Error consultando todos los materiales! " + e2);
                } finally {
                    //Cierre del controlador
                    if ( conexion != null ) {
                        try {
                            conexion.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }    
        });

        btnActualizar = new JButton(redimensionarIcono(new ImageIcon("Imagenes/actualizar.png"), 24));
        btnActualizar.setText("  Actualizar"); 
        btnActualizar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(ActionEvent e) {  
                ArrayList<MaterialConstruccion> request = new ArrayList<MaterialConstruccion>();
                Connection conexion = null;        

                try{
                    conexion = JDBCUtilities.getConnection();

                    String consulta = "SELECT * FROM MaterialConstruccion;";

                    PreparedStatement statement = conexion.prepareStatement(consulta);
                    ResultSet resultSet = statement.executeQuery();

                    while ( resultSet.next() ) {
                        MaterialConstruccion material = new MaterialConstruccion();
                        material.setIdMaterialConstruccion(resultSet.getInt(1));
                        material.setNombreMaterial(resultSet.getString(2));
                        material.setImportado(resultSet.getString(3));
                        material.setPrecioUnidad(resultSet.getInt(4));                              
                        request.add(material);
                    }

                    //Abiertas esas interacciones con BD
                    resultSet.close();
                    statement.close();
                    
                    int[] filasSeleccionadas = jtMateriales.getSelectedRows();
                    MaterialConstruccion materialActualizar = new MaterialConstruccion();
                    ArrayList<String> filaIntermedia = new ArrayList<String>();
                    int numeroColumnas = modeloTablaMateriales.getColumnCount();
                    for (int j = 0; j < numeroColumnas; j++) {
                        filaIntermedia.add((String) jtMateriales.getValueAt(filasSeleccionadas[0], j) );                   
                    }
                    materialActualizar.setIdMaterialConstruccion(Integer.valueOf(filaIntermedia.get(0)));
                    materialActualizar.setNombreMaterial(filaIntermedia.get(1));
                    materialActualizar.setImportado(filaIntermedia.get(2));
                    materialActualizar.setPrecioUnidad(Integer.valueOf(filaIntermedia.get(3)));

                } catch( SQLException e1 ) {
                    System.err.println("Error consultando todos los materiales! " + e1);
                } finally {
                    //Cierre del controlador
                    if ( conexion != null ) {
                        try {
                            conexion.close();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }    
        });

        btnEliminar = new JButton(redimensionarIcono(new ImageIcon("Imagenes/eraser.png"), 24));
        btnEliminar.setText("  Borrar"); 
        btnEliminar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(ActionEvent e) {  
                Connection conexion = null;        

                try{
                    conexion = JDBCUtilities.getConnection();

                    String consulta = "DELETE FROM MaterialConstruccion WHERE Nombre_Material = "+
                                    "'" +txtNombreMaterial.getText() + "' AND Importado == '" +
                                    txtImportado.getText() + "';";

                    PreparedStatement statement = conexion.prepareStatement(consulta);
                
                    //Abiertas esas interacciones con BD
                    statement.executeUpdate();
                    statement.close();

                } catch( SQLException e2 ) {
                    System.err.println("Error consultando todos los materiales! " + e2);
                } finally {
                    //Cierre del controlador
                    if ( conexion != null ) {
                        try {
                            conexion.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }    
        });

        panelBotones.add(btnAdicionar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);         

        //Contenedor
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 10;
        constraints.gridwidth = 10;
        getContentPane().add(panel, constraints);        

        constraints.gridx = 10;
        constraints.gridy = 0;
        constraints.gridheight = 5;
        constraints.gridwidth = 2;
        getContentPane().add(panelFormularioAdicion, constraints);    
        
        constraints.gridx = 10;
        constraints.gridy = 5;
        constraints.gridheight = 5;
        constraints.gridwidth = 2;
        getContentPane().add(panelBotones, constraints);

        //Mostrar ventana/frame
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }

    private ImageIcon redimensionarIcono ( ImageIcon icono, int pixeles ) {        
        Image image = icono.getImage(); 
        Image newimg = image.getScaledInstance(pixeles, pixeles,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    private String[][] formatoRegistros ( ArrayList<MaterialConstruccion> materiales, int numeroEncabezados ) {
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[materiales.size()][numeroEncabezados];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < materiales.size(); i++) {
            registros[i][0] = String.valueOf(materiales.get(i).getIdMaterialConstruccion()); 
            registros[i][1] = materiales.get(i).getNombreMaterial();            
            registros[i][2] = materiales.get(i).getImportado();
            registros[i][3] = String.valueOf(materiales.get(i).getPrecioUnidad());        
        }

        //Retornar registros en formato JTable
        return registros;
    }

}
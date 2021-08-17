package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.vo.BancoRankeadoAreaPromedio;
import model.vo.MaterialConstruccion;
import model.dao.BancoRankeadoAreaPromedioDao;
import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;
import model.vo.MaterialRankeadoCompras;
import model.dao.MaterialRankeadoComprasDao;
import model.dao.MaterialConstruccionDao;

import view.GUI;
import view.Requerimiento1_GUI;
import view.Requerimiento2_GUI;
import view.Requerimiento3_GUI;
import view.CRUD_Materiales_GUI;

public class ControladorRequerimientosReto4 implements ActionListener {

    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final BancoRankeadoAreaPromedioDao bancoRankeadoAreaPromedioDao;
    private final MaterialRankeadoComprasDao materialRankeadoComprasDao; 
    private final MaterialConstruccionDao materialConstruccionDao;
    
    private final GUI menuPrincipalGUI;
    private Requerimiento1_GUI requerimiento1_GUI;
    private Requerimiento2_GUI requerimiento2_GUI;
    private Requerimiento3_GUI requerimiento3_GUI;
    private CRUD_Materiales_GUI crud_Materiales_GUI;

    public ControladorRequerimientosReto4(){
        //Instanciamos los DAO      
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.bancoRankeadoAreaPromedioDao = new BancoRankeadoAreaPromedioDao();        
        this.materialRankeadoComprasDao = new MaterialRankeadoComprasDao();
        this.materialConstruccionDao = new MaterialConstruccionDao();
        //Instanciamos las interfaces
        this.menuPrincipalGUI = new GUI();
    }

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException {
        return this.proyectoRankeadoComprasDao.rankingProyectosComprasDescendente10();
    }    

    public ArrayList<BancoRankeadoAreaPromedio>  consultarBancosRankeadosAreaPromedio() throws SQLException {
        return this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
    }
    
    public ArrayList<MaterialRankeadoCompras> consultarMaterialesRankeadosCompras() throws SQLException {
        return this.materialRankeadoComprasDao.rankingMaterialesComprasDescendente();
    }

    public void iniciarAplicacion(){
        this.menuPrincipalGUI.iniciarGUI(this);
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        
        //Obtener el evento asociado al botón
        String actionCommand = ( (JButton) e.getSource() ).getActionCommand();

        switch ( actionCommand ) {

            case "rankingProyectos":
                //System.out.println("()()()Interfaz Proyectos en construcción!");                
                try{
                    ArrayList<ProyectoRankeadoCompras> proyectos = new ArrayList<ProyectoRankeadoCompras>();
                    proyectos = this.proyectoRankeadoComprasDao.rankingProyectosComprasDescendente10();
                    this.requerimiento1_GUI = new Requerimiento1_GUI( proyectos );
                } catch( SQLException eProyectosCompras ) {
                    System.err.println("Error cargando rq1 en la ventana!! " + eProyectosCompras);
                }
            break;

            case "rankingBancos":
                //System.out.println("$$$Interfaz BANCOS en construcción!");
                try{
                    ArrayList<BancoRankeadoAreaPromedio> bancos = new ArrayList<BancoRankeadoAreaPromedio>();
                    bancos = this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
                    this.requerimiento2_GUI = new Requerimiento2_GUI(bancos);
                } catch( SQLException eBancosArea ) {
                    System.err.println("Error cargando rq2 en la ventana!! " + eBancosArea);
                }
            break;

            case "rankingMaterialesImportados":
                //System.out.println("--Interfaz mAtErIales en construcción!");
                try{
                    ArrayList<MaterialRankeadoCompras> materiales = new ArrayList<MaterialRankeadoCompras>();
                    materiales = this.materialRankeadoComprasDao.rankingMaterialesComprasDescendente();
                    this.requerimiento3_GUI = new Requerimiento3_GUI(materiales);
                } catch( SQLException eMateriales ) {
                    System.err.println("Error cargando rq3 en la ventana!! " + eMateriales);
                }
            break;

            case "crudMateriales":
                // JOptionPane.showMessageDialog(  this.menuPrincipalGUI, 
                //                                 "CRUD Materiales en Construcción!", 
                //                                 "SW", 
                //                                 JOptionPane.INFORMATION_MESSAGE);

                try{
                    ArrayList<MaterialConstruccion> materiales = new ArrayList<MaterialConstruccion>();
                    materiales = this.materialConstruccionDao.consultarTodos();
                    this.crud_Materiales_GUI = new CRUD_Materiales_GUI(materiales,this);                    
                } catch( SQLException eMaterialesCRUD ) {
                    System.err.println("Error cargando materiales de construcción (CRUD)!! " + eMaterialesCRUD);
                }                

                break;
            
            case "adicionarMaterial":
                // try{
                //     ArrayList<MaterialConstruccion> materiales = new ArrayList<MaterialConstruccion>();
                //     materiales = this.materialConstruccionDao.create();
                //     this.crud_Materiales_GUI = new CRUD_Materiales_GUI(materiales,this);                    
                // } catch( SQLException eMaterialesCRUD ) {
                //     System.err.println("Error cargando materiales de construcción (CRUD)!! " + eMaterialesCRUD);
                // }  
                break;
            
            case "actualizarMaterial":
                break;
            
            case "borrarMaterial":
                break;

        }

    }

}

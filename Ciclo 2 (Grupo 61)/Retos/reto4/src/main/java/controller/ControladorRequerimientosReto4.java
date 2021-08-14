package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.BancoRankeadoAreaPromedio;
import model.dao.BancoRankeadoAreaPromedioDao;

import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;

import model.vo.MaterialRankeadoCompras;
import model.dao.MaterialRankeadoComprasDao;


public class ControladorRequerimientosReto4 {

    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final BancoRankeadoAreaPromedioDao bancoRankeadoAreaPromedioDao;
    private final MaterialRankeadoComprasDao materialRankeadoComprasDao;    

    public ControladorRequerimientosReto4(){
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.bancoRankeadoAreaPromedioDao = new BancoRankeadoAreaPromedioDao();        
        this.materialRankeadoComprasDao = new MaterialRankeadoComprasDao();
    }

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException{
        return this.proyectoRankeadoComprasDao.rankingProyectosComprasDescendente10();
    }    

    public ArrayList<BancoRankeadoAreaPromedio>  consultarBancosRankeadosAreaPromedio() throws SQLException{
        return this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
    }
    
    public ArrayList<MaterialRankeadoCompras> consultarMaterialesRankeadosCompras() throws SQLException {
        return this.materialRankeadoComprasDao.rankingMaterialesComprasDescendente();
    }

}
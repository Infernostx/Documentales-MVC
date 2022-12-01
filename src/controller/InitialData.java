/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Access.DocumentalDAO;
import model.modelDocumental;
import java.util.ArrayList;


/**
 *
 * @author Miguel
 */
public class InitialData {
    private ArrayList<modelDocumental>Documental= null;
           
    public InitialData(){
        DocumentalDAO documentalDAO = new DocumentalDAO();
        this.Documental = documentalDAO.getallDocumentals();
        this.Documental.add(0,new modelDocumental(-1,"Titulo","Nombre D.","Apellido D.","Origen",-1));
    }

    /**
     * @return the Documental
     */
    public ArrayList<modelDocumental> getDocumental() {
        return Documental;
    }    
}

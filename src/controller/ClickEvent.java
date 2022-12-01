package controller;

import Access.DocumentalDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.modelDocumental;
import view.AddDocumental;
import view.ControlsPanel;
import view.DelDocumental;

/**
 *
 * @author Miguel
 */
public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            
            String tituloDocumental = (String)this.controlsPanel.getTxtName().getText();
            
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            DocumentalDAO docuDAO = new DocumentalDAO();
            ArrayList<modelDocumental> documentales = docuDAO.getFilteredDocumentals(tituloDocumental);
            
            this.controlsPanel.setTblResults(documentales);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddDocumental()) {
            AddDocumental addDocumental = new AddDocumental();
            addDocumental.setVisible(true);
    }
        else if(actionEvent.getSource()==this.controlsPanel.getBtnUpdateDocumental()){
            ArrayList<modelDocumental> documentales=new ArrayList();
            ArrayList<modelDocumental> documentalesu=new ArrayList();
            DocumentalDAO docuDAO = new DocumentalDAO();
            int id=0;
            String Titulo=null;
            String Nombre=null;
            String Origen=null;
            String Apellido=null;
            int Anio=0;
            int row=0;
            while (row<this.controlsPanel.getTblResults().getModel().getRowCount()){ 
            int column=0;

                while (column<this.controlsPanel.getTblResults().getModel().getColumnCount()){
                   if(column==0){
                       id = (Integer) this.controlsPanel.getTblResults().getModel().getValueAt(row, column);
                   }
                   else if(column==5){
                   Anio = (Integer) this.controlsPanel.getTblResults().getModel().getValueAt(row, column);
                   }
                   else if(column==1){
                    Titulo = (String) this.controlsPanel.getTblResults().getModel().getValueAt(row, column);

                   }
                   else if(column==2){
                    Nombre = (String) this.controlsPanel.getTblResults().getModel().getValueAt(row, column);
   
                   }
                   else if(column==3){
                    Apellido = (String) this.controlsPanel.getTblResults().getModel().getValueAt(row, column);
   
                   }
                   else if(column==4){
                    Origen= (String) this.controlsPanel.getTblResults().getModel().getValueAt(row, column);
   
                   }
                   
                   column++;
                }
                documentales = docuDAO.actualizarDocumental(id, Titulo, Nombre, Apellido, Origen, Anio);
                row++;
                
                
            }
            
            
            this.controlsPanel.setTblResults(documentales);
             documentales.clear();
            documentalesu = docuDAO.getallDocumentals();

            this.controlsPanel.setTblResults(documentalesu);

        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnDelDocumental()) {
            DelDocumental delDocumental = new DelDocumental();
            delDocumental.setVisible(true);
    }
        
    }
}
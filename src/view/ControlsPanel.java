/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.modelDocumental;
import controller.ClickEvent;
import controller.InitialData;
/**
 *
 * @author Miguel
 */
public class ControlsPanel extends JPanel {
    
    private JLabel                              lblDocumentales;
    
    private JComboBox<modelDocumental>          cbxDocuList;
    private JLabel                              lblPresentacion;
    private JLabel                              lblName;
    private JTextField                          txtName;
    private JButton                             btnSearch;
    private JButton                             btnAddDocumental;
    private JButton                             btnUpdateDocumental;
    private JButton                             btnDelDocumental;
    private JTable                              tblResults;
    
    
    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        InitComponents();
    }
    
    private void InitComponents(){
        setLayout(new GridLayout(4,1));
        InitialData initialData = new InitialData();
        
      
        
        
        // Name patttern 
        this.lblName = new JLabel("Documentales");
        add(this.getLblName());
        
        this.txtName = new JTextField();
        add(this.getTxtName());
        
        
        // Search button
        this.btnSearch = new JButton("Buscar");
        add(this.getBtnSearch());
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.getBtnSearch().addActionListener(clickEvent);
        
        // Insert  button
        this.btnAddDocumental = new JButton("Agregar Nuevo Documental");
        add(this.getBtnAddDocumental());
        this.getBtnAddDocumental().addActionListener(clickEvent);
        
        // Delete  button
        this.btnDelDocumental = new JButton("Eliminar Documental");
        add(this.getBtnDelDocumental());
        this.getBtnDelDocumental().addActionListener(clickEvent);
        
        // Update button
        this.btnUpdateDocumental = new JButton("Actualizar y Ver todos los Documentales");
        add(this.getBtnUpdateDocumental());
        this.getBtnUpdateDocumental().addActionListener(clickEvent);
    }

    /**
     * @return the lblDocumentales
     */
    public JLabel getLblDocumentales() {
        return lblDocumentales;
    }

    /**
     * @return the cbxDocuList
     */
    public JComboBox getCbxDocuList() {
        return cbxDocuList;
    }

    /**
     * @return the lblPresentacion
     */
    public JLabel getLblPresentacion() {
        return lblPresentacion;
    }

    /**
     * @return the lblName
     */
    public JLabel getLblName() {
        return lblName;
    }

    /**
     * @return the txtName
     */
    public JTextField getTxtName() {
        return txtName;
    }

    /**
     * @return the btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @return the btnAddDocumental
     */
    public JButton getBtnAddDocumental() {
        return btnAddDocumental;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param documentales
     * 
     */
    public void setTblResults(ArrayList<modelDocumental> documentales) {
        String[] headers = {"ID", "Titulo", "Nombre D.", "Apellido D.", "Origen", "Anio"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<documentales.size(); i++){
            tableModel.addRow(documentales.get(i).toArray() );
        }
    }

  
    /**
     * @return the btnUpdateDocumental
     */
    public JButton getBtnUpdateDocumental() {
        return btnUpdateDocumental;
    }

    /**
     * @return the btnDelDocumental
     */
    public JButton getBtnDelDocumental() {
        return btnDelDocumental;
    }

  


   
}

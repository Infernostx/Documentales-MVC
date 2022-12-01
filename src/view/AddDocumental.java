/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Access.DocumentalDAO;
import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.modelDocumental;



/**
 *
 * @author Miguel
 */
public class AddDocumental extends JFrame implements ActionListener {
   // private JLabel                     lblId;
   // private JTextField                 txtId;
    private JLabel                     lblNombre;
    private JTextField                 txtNombre;
    private JLabel                     lblTitulo;
    private JTextField                 txtTitulo;
    private JLabel                     lblApellido;
    private JTextField                 txtApellido;
    private JLabel                     lblOrigen;
    private JTextField                 txtOrigen;
    private JLabel                     lblAnio;
    private JTextField                 txtAnio;
    
  
    private JButton                    btnInsertDocumental;
    
    public AddDocumental(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Documentales - Agregar Documental");
        setLayout(new GridLayout(7,2));
       
        
//        this.lblId = new JLabel("ID del Documental");
//        add(this.lblId);
//        this.txtId = new JTextField();
//        add(this.txtId);
        
        
        this.lblTitulo = new JLabel("Nombre del Documental");
        add(this.lblTitulo);
        this.txtTitulo = new JTextField();
        add(this.txtTitulo);
        
        
        this.lblNombre = new JLabel("Nombre del Director");
        add(this.lblNombre);
        this.txtNombre = new JTextField();
        add(this.txtNombre);
        
        
        this.lblApellido = new JLabel("Apellido del Director");
        add(this.lblApellido);
        this.txtApellido = new JTextField();
        add(this.txtApellido);
        
        this.lblOrigen = new JLabel("Origen");
        add(this.lblOrigen);
        this.txtOrigen = new JTextField();
        add(this.txtOrigen);
               
        
        this.lblAnio = new JLabel("Anio de Estreno");
        add(this.lblAnio);
        this.txtAnio = new JTextField();
        add(this.txtAnio);
        
        this.btnInsertDocumental = new JButton("Agregar a BD");
        add(this.btnInsertDocumental);
        
        this.btnInsertDocumental.addActionListener(this);
       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnInsertDocumental) {
            //int    id = Integer.parseInt( (String)this.txtId.getText()); 
            String titulo = (String)this.txtTitulo.getText();
            String nombre = (String)this.txtNombre.getText(); 
            String apellido = (String)this.txtApellido.getText(); 
            String origen = (String)this.txtOrigen.getText(); 
            int anio= Integer.parseInt( (String)this.txtAnio.getText());  
           
    
            modelDocumental documental = new modelDocumental(titulo,nombre,apellido,origen,anio);
            
            
            System.out.println( " " + titulo + " " + origen + " " + anio);
            DocumentalDAO documentalDAO = new DocumentalDAO();
            documentalDAO.agregarDocumental(documental);
        }
    }
}

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
public class DelDocumental extends JFrame implements ActionListener {
    private JLabel                     lblId;
    private JTextField                 txtId;

    
  
    private JButton                    btnDeleteDocumental;
    
    public DelDocumental(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Documentales - Eliminar Documental");
        setLayout(new GridLayout(1,3));
       
        
        this.lblId = new JLabel("ID del Documental");
        add(this.lblId);
        this.txtId = new JTextField();
        add(this.txtId);
        this.btnDeleteDocumental=new JButton();
        this.btnDeleteDocumental = new JButton("Eliminar de BD");
        add(this.btnDeleteDocumental);
        this.btnDeleteDocumental.addActionListener(this);
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  -frameSize.width-350)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnDeleteDocumental) {
            int    id = Integer.parseInt( (String)this.txtId.getText()); 
            
           
    
            modelDocumental documental = new modelDocumental(id);
            
            
            
            DocumentalDAO documentalDAO = new DocumentalDAO();
            documentalDAO.deleteDocumental(documental);
        }
    }
}

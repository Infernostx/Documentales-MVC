/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import model.modelDocumental;
import utils.ConnectionDB;

/**
 *
 * @author Miguel
 */
public class DocumentalDAO {
    private Connection conn = null;
    
    
    public ArrayList<modelDocumental> getallDocumentals(){
        ArrayList<modelDocumental> Documentals = new ArrayList();
        try{
            if(conn == null) 
                conn = ConnectionDB.getConnection();
            
           String sql = "SELECT do_id,do_titulo,do_nombre,do_apellido,do_origen,do_anio FROM Documental;"; 
           Statement statement= conn.createStatement();
           ResultSet    result =    statement.executeQuery(sql);
           System.out.println(sql);       
           while (result.next()){
               modelDocumental Documental = new modelDocumental(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getInt(6));
               Documentals.add(Documental);
           }
           
    }
    catch(SQLException ex){
    JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
    }
    catch(RuntimeException ex){
        JOptionPane.showMessageDialog(null, "No es posible conectarse a la base de datos, modo de prueba");
    }
        return Documentals;
    }
    
    public ArrayList<modelDocumental> getFilteredDocumentals(String tituloDocumental) {
        ArrayList<modelDocumental> documentals = new ArrayList();
        
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT do_id,do_titulo,do_nombre,do_apellido,do_origen,do_anio FROM Documental " +
                         "WHERE do_titulo LIKE ?;";
                     
            PreparedStatement statement = conn.prepareStatement(sql);
            //System.out.println(sql);            
            statement.setString(1, "%"+tituloDocumental+"%");
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                modelDocumental documental = new modelDocumental(result.getInt(1),result.getString(2),result.getString(3), result.getString(4), result.getString(5), result.getInt(6));
                documentals.add( documental );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return documentals;
    }
  
    public void agregarDocumental(modelDocumental documental){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO Documental(do_id,do_titulo,do_nombre,do_apellido,do_origen,do_anio)"
                    + "VALUES(?,?, ?, ?, ?,?);";
PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, documental.getId());
            statement.setString(2, documental.getTitulo());
            statement.setString(3, documental.getNombre());
            statement.setString(4, documental.getApellido());
            statement.setString(5, documental.getOrigen());
            statement.setInt(6, documental.getAnio());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }    
        
    public void deleteDocumental(modelDocumental documental){
        try{
            if(conn== null)
             conn=ConnectionDB.getConnection();
            //conn.equals( ConnectionDB.getConnection());
            String sql ="DELETE FROM Documental WHERE do_id=?; ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,documental.getId());
            statement.execute();
            
            
        }
        catch(SQLException ex){
    JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
    }
    }  
        
    public ArrayList<modelDocumental> actualizarDocumental(int Id,String Titulo,String Nombre,String Apellido,String Origen,int Anio){
                ArrayList<modelDocumental> documentals = new ArrayList();

        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE documental SET do_titulo =?,do_nombre=?,do_apellido=?,do_origen=?,do_anio=? WHERE do_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, Titulo);
            statement.setString(2, Nombre);
            statement.setString(3, Apellido);
            statement.setString(4, Origen);
            statement.setInt(5, Anio);
            statement.setInt(6, Id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }      
        return documentals;
    }
}

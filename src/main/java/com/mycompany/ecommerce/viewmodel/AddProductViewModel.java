
package com.mycompany.ecommerce.viewmodel;

import com.mycompany.ecommerce.model.ProductItem;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




/**
 *
 * @author samah
 */
public class AddProductViewModel {
    
    
    public static  java.sql.Connection getConnection()  {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/";
            String databasename="sust";
            String username="root";
            String password="";
            
             java.sql.Connection con=DriverManager.getConnection(url + databasename , username, password);
     
            System.out.println("Connected successflly");
            
            return  con;
            
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
        
        return null;
    }
    
    public static boolean insert (ProductItem product) {
        
         java.sql.Connection connection=getConnection();
        try {
           
             String query = "INSERT INTO products (id, name, price) values (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, product.getId());
            if (checkId(product.getId())) ;
            else
            {
                return false;
            }
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());
            
            stmt.execute();
            connection.close();
            System.out.println("added");
            return true;
          
            
        } catch (SQLException ex) {
            System.out.println("laaaa");
            }
        
        return false;
    }
    public static Boolean checkId (int id ) throws SQLException
    {
         ArrayList <ProductItem> existingproducts= getProducts();
         for (int i=0; i< existingproducts.size(); i++)
         {
             if (existingproducts.get(i).getId()==id )
                 return false;
         }
        
         return true;
    }
    public static ArrayList <ProductItem> getProducts() throws SQLException
    {
         java.sql.Connection connection=getConnection();
         ArrayList <ProductItem> products= new ArrayList<>();
         
        
            Statement stmt = connection.createStatement();
            ResultSet rs= stmt.executeQuery("select id, name, price from products");
            
            while (rs.next())
            {
                ProductItem product = new ProductItem();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                
                products.add(product);
            }
            
            connection.close();
            
            return products;
            
        
    }
            
           
}

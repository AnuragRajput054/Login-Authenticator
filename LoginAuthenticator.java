
package modal;

import db.DBConnector;
import dto.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginAuthenticator {
    
    public  boolean islogin(UserDTO user){
          
        
            String username = user.getUsername();
            String password = user.getPassword();
            String tablepassword = "";
            
           
             try{
                   Statement st = DBConnector.getStatement();
                   String query = "SELECT password FROM login WHERE Name ='"+username+"' ";
                   System.out.println(query);
                   ResultSet rs = st.executeQuery(query);
                   if(rs.next()){
                        
                             tablepassword = rs.getString(1);
                              System.out.print(rs.getString(1)+"\t");
                   }else{
                          return false;
                   }
                   
             }
             catch(SQLException e){
                    System.out.println(e);
             }
             
             
           if(username != null && password != null  && !username.trim().equals("")  && password.equals(tablepassword)  ){
               return true;
           }
           return false;
            
    }
     public  boolean isRegister(String username,String password ,String city ,String number ,String id ){
          
               boolean f= false;
             try{
                   Statement st = DBConnector.getStatement();
                   String query = "INSERT INTO login values( '"+id+"','"+username+"','"+password+"','"+city+"','"+number+"')";
                   System.out.println(query);
        
                    int i = st.executeUpdate(query);
                      if(i>0){
                                System.out.println(i+"record inserted");
                                 f= true;
                                return true;
                                 
                                
                      }
                      else {
                                  System.out.println(i+"record failed to insert");
                                  return false;
                              
                              }
                     
                   
             }
             catch(SQLException e){
                    System.out.println(e);
             }
             
            
             return f;
                     
                                 
                                 
                              
                             
                    
        
     }
     
     public boolean dataUpdata(String username ,String city  ,String number,String id,String password ){
               
                             boolean f = false;
                                                                                    
                           try{  
                                 Statement st = DBConnector.getStatement();
                                String query =  "UPDATE login SET city = '"+city+"', password = '"+password+"' ,Name = '"+username+"' , number = '"+number+"'  where id = '"+id+"' " ;
                                
                                  int   i  = st.executeUpdate(query);
                                  System.out.println(i + " "+i);
                                  if(i == 1){
                                      f = true;
                                  }
                                  
                                System.out.println(i);
                           }
                           catch(SQLException e){
                               System.out.println(e);
                           }
                         return f;                        
     }
         
     public String getId(String password)
             {
                    String id="";
            
           
             try{
                   Statement st = DBConnector.getStatement();
                   String query = "SELECT id FROM login WHERE password = '"+password+"' ";
                   System.out.println(query);
                   ResultSet rs = st.executeQuery(query);
                   if(rs.next()){
                        
                             id =  rs.getString(1);
                            System.out.print(rs.getString(1)+"\t");
                   }
                   
             }
             catch(SQLException e){
                    System.out.println(e);
             }
             
          return id;                          
}
      public String getcity(String password)
             {
                    String city ="";
            
           
             try{
                   Statement st = DBConnector.getStatement();
                   String query = "SELECT city FROM login WHERE password = '"+password+"' ";
                   System.out.println(query);
                   ResultSet rs = st.executeQuery(query);
                   if(rs.next()){
                        
                            city =  rs.getString(1);
                          
                             System.out.print(rs.getString(1)+"\t");
                   }
                   
             }
             catch(SQLException e){
                    System.out.println(e);
             }
             
          return city;                       
}
       public String getNumber(String password)
             {
                    String number="";
            
           
             try{
                   Statement st = DBConnector.getStatement();
                   String query = "SELECT number FROM login WHERE password = '"+password+"' ";
                   System.out.println(query);
                   ResultSet rs = st.executeQuery(query);
                   if(rs.next()){
                        
                             number =  rs.getString(1);
                           
                             System.out.print(rs.getString(1)+"\t");
                   }
                   
             }
             catch(SQLException e){
                    System.out.println(e);
             }
             
          return number;                          
}

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteData(String id){
                 boolean f = false;
                try{  
                                 Statement st = DBConnector.getStatement();
                                String query =  "DELETE FROM login where id='"+id+"'" ;
                                System.out.println(query);
                                  int   i  = st.executeUpdate(query);
                                  System.out.println(i + " "+i);
                                  if(i == 1){
                                      f = true;
                                  }
                                  
                                System.out.println(i);
                           }
                           catch(SQLException e){
                               System.out.println(e);
                           }
                         return f;                  
           
       }
     
}

package es.banco.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.banco.modelo.TarjetaCredito;

public class TarjetaCreditoDAO {
	
	 private Connection cx;
     private static TarjetaCreditoDAO tarjetacreditoDao=null;
     
     private TarjetaCreditoDAO(){
     }
     public static TarjetaCreditoDAO getInstance(){
    	 if(TarjetaCreditoDAO.tarjetacreditoDao==null)
    		 TarjetaCreditoDAO.tarjetacreditoDao= new TarjetaCreditoDAO();
    	 return TarjetaCreditoDAO.tarjetacreditoDao;
     }
     
     private void conectar() {
	     try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","root");
	            cx.setAutoCommit(false);
	     }
    catch(SQLException e) {
             
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error en SQL ", e);
         }
	     catch(ClassNotFoundException e) {
	         Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No se encuentra lib mySQL ", e);
         }
	     }
     
	     private void desconectar() {
	         try {
	             if(cx!=null)
	                cx.close();
	        } catch (SQLException e) {
	           
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
	        }  
	     }
	     
	     
public int darAlta(TarjetaCredito tarjetaCredito) {
		
	int id=0;
		try {
			//CONEXION
			conectar();
			//QUERY
			PreparedStatement ps;
			ps = cx.prepareStatement("INSERT INTO TARJETACREDITO VALUES(?,?,?,?,?,?,?)");
			
			ps.setInt(1, 0);
			ps.setString(2, tarjetaCredito.getNumero());
			ps.setInt(3, tarjetaCredito.getCupoMaximo());
			ps.setInt(4, tarjetaCredito.getCupoDisponible());
			ps.setString(5, tarjetaCredito.getTipo());
			ps.setString(6, tarjetaCredito.getNumeroComprobacion());
			ps.setString(7, tarjetaCredito.getContrasenha());
			//CONSULTAR
			int filasAfectadas = ps.executeUpdate();
			//COMMIT
			cx.commit();
			if(filasAfectadas>=1){
				id= ultimoId(); 
			}
			
		} catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
        }
        finally {
            //DESCONEXION
            desconectar();
          }
     return id;
}

private int ultimoId() {
	int  idM=90;
	try {
		//CONEXION
		conectar();
		//SENTENCIA		
		PreparedStatement ps= cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM TARJETACREDITO");
		//CONSULTA
		ResultSet consulta= ps.executeQuery();
		//RESULTADO DE LA CONSULTA
		if(consulta.next()){
			idM=consulta.getInt("ULTIMO");
		}
		
	} catch (SQLException e) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
    }
    finally {
        //DESCONEXION
        desconectar();
      }
 return idM;
}

public int ampliarCupo(int cupoDisponible, int id) {
	int filasAfectada=0;
	try {
		//CONEXION
		conectar();
		//SENTENCIA
		PreparedStatement ps = cx.prepareStatement("UPDATE tarjetaCredito SET cupoDisponible=? WHERE ID=?");
		ps.setInt(1, cupoDisponible);
		ps.setInt(2, id);
		//CONSULTA
		filasAfectada=ps.executeUpdate();
		cx.commit();

	} catch (SQLException e) {

		Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
	}   
	finally {
		//DESCONEXION
		desconectar();
	}
	return filasAfectada;
	}

public TarjetaCredito consultarUno(int id) {
	TarjetaCredito t = new TarjetaCredito();
    try {
     //CONEXION
   	     conectar();
     //CONSULTA
          PreparedStatement ps;
          ps = cx.prepareStatement("SELECT * FROM banco WHERE ID=?");
         //SET ?
              ps.setInt(1, id);
             //EJECUTAR
               ResultSet rs =ps.executeQuery();  
           //RESPUESTA BBDD
             if(rs.next()) {
            	      t.setId(rs.getInt("id"));
                      t.setNumero(rs.getString("numero"));
                      t.setCupoMaximo(rs.getInt("cupoMaximo"));
                      t.setCupoDisponible(rs.getInt("cupoDisponible"));
                      t.setTipo(rs.getString("tipo"));
                      t.setNumeroComprobacion(rs.getString("numeroComprobacion"));
                      t.setContrasenha(rs.getString("contrasenha"));
       	           	  
                  }
     
  } catch (SQLException e) {
       // TODO Auto-generated catch block
       Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error SQL ", e);
   }
      finally {
          //DESCONEXION
            desconectar();
      }
  return t;
}

}

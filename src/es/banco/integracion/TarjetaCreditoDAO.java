package es.banco.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.banco.modelo.TarjetaCredito;

public class TarjetaCreditoDAO {
private Connection cx;
	
	private void conectar(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cx=DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","root");
			                                
			cx.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private void desconectar(){	
		try {
			cx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public int darAlta(TarjetaCredito tarjetaCredito) {
		
		int idRetornar = 0;
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
			ps.setString(7, tarjetaCredito.getContraseña());
			//CONSULTAR
			int filasAfectadas = ps.executeUpdate();
			//COMMIT
			cx.commit();
			if(filasAfectadas>=1){
				idRetornar= ultimoId();
			}
			//DESCONEXION
			desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idRetornar;
		
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
		//DESCONEXION
		desconectar();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return idM;
}

}

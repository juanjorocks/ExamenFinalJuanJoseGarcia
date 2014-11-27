package es.banco.modelo;

import javax.jws.WebMethod;
import javax.jws.WebService;

import es.banco.integracion.TarjetaCreditoDAO;

@WebService(endpointInterface = "es.banco.modelo.BancoWS")
public class Banco implements BancoWS {
	private TarjetaCreditoDAO tarjetaCreditodao = TarjetaCreditoDAO.getInstance();
	
	public String DarAlta(String numero, int cupoMaximo, int cupoDisponible, String tipo, String numeroComprobacion, String contrasenha){
		
		 TarjetaCredito tarjetaCredito= new TarjetaCredito(numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contrasenha);
		 String msg;
		 int id =tarjetaCreditodao.darAlta(tarjetaCredito);
	     msg="Tarjetas dadas de alta :" + id;
		 return msg;
	}
	
	/* (non-Javadoc)
	 * @see es.banco.modelo.BancoWS#ampliarCupo(int, int)
	 */
	@WebMethod
	@Override
	public String ampliarCupo(int id, int cupoDisponible ) {
	       
		String msg;
		int tarjetasampliadas=tarjetaCreditodao.ampliarCupo(cupoDisponible, id);
			msg="Tarjetas con cupo ampliado :" + tarjetasampliadas;
		return msg;
    }
	
	public TarjetaCredito consultarUno(int id) {
	       // validar si el q solicita la consulta tiene autorizacion
	        TarjetaCredito tarjetaCredito = tarjetaCreditodao.consultarUno(id);
	      
	        return tarjetaCredito;
	}
	
	

}
  
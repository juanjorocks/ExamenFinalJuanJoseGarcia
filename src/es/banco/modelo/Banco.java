package es.banco.modelo;

import es.banco.integracion.TarjetaCreditoDAO;


public class Banco {
	private TarjetaCreditoDAO tarjetaCreditodao = TarjetaCreditoDAO.getInstance();
	
	public String DarAlta(String numero, int cupoMaximo, int cupoDisponible, String tipo, String numeroComprobacion, String contrasenha){
		
		 TarjetaCredito tarjetaCredito= new TarjetaCredito(numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contrasenha);
		 String msg;
		 int id =tarjetaCreditodao.darAlta(tarjetaCredito);
	     msg="Tarjetas dadas de alta :" + id;
		 return msg;
	}
	
	public String ampliarCupo(int id, int cupoDisponible ) {
	       
		String msg;
		int tarjetasampliadas=tarjetaCreditodao.ampliarCupo(cupoDisponible, id);
			msg="Tarjetas con cupo ampliado :" + tarjetasampliadas;
		return msg;
    }
	
	

}
  
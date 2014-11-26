package es.banco.modelo;



public class Banco {
	private TarjetaCreditoDAO tarjetaCreditodao = TarjetaCreditoDAO.getInstance();
	
	public int DarAlta(String numero, int cupoMaximo, int cupoDisponible, String tipo,
						String numeroComprobacion, String contraseña){
		 TarjetaCredito tarjetaCredito= new TarjetaCredito(numero, cupoMaximo, cupoDisponible, tipo,
				 											numeroComprobacion, contraseña);
		 int id =tarjetaCreditodao.darAlta(tarjetaCredito);
	      return  id;
		
	}

}

package es.banco.modelo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface BancoWS {
@WebMethod
	public abstract String ampliarCupo(int id, int cupoDisponible);

}
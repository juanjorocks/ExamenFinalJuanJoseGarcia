package es.banco.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.banco.modelo.Banco;
import es.banco.modelo.TarjetaCredito;


/**
 * Servlet implementation class DarAltaServlet
 */
@WebServlet("/DarAlta")
public class DarAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarAltaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.recuperar los datos de la URL
				String numero = request.getParameter("numero");
				int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
				int cupoDisponible = Integer.parseInt(request.getParameter("cupoDisponible"));
				String tipo = request.getParameter("tipo");
				String tipoBBDD;
				if(tipo.equals("tipoV")){
					tipoBBDD="VISA";
				}else{
					tipoBBDD="MasterCard";
				}
				String numeroComprobacion = request.getParameter("numeroComprobacion");
				String contrasenha= request.getParameter("contrasenha");
				String b="";
				Banco banco= new Banco();
				b=banco.DarAlta(numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contrasenha);
				request.setAttribute("mensaje", b);
				RequestDispatcher rd;
				rd=request.getRequestDispatcher("vistaMensaje.jsp");
				rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

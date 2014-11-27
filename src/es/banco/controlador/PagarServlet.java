package es.banco.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.banco.modelo.Banco;
import es.banco.modelo.BancoWS;

/**
 * Servlet implementation class PagarServlet
 */
@WebServlet("/Pagar")
public class PagarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String numero=request.getParameter("numero");
		int cupoMaximo=Integer.parseInt(request.getParameter("cupoMaximo"));
		int cupoDisponible=Integer.parseInt(request.getParameter("cupoDisponible"));
		String tipo=request.getParameter("tipo");
		String numeroComprobacion=request.getParameter("numeroComprobacion");
		String contrasenha=request.getParameter("contrasenha");
		
		String ampliarCupo=request.getParameter("ampliarCupo");
		BancoWS banco= new Banco();
		String b="";
		
		if(ampliarCupo!=null)
		{
			b=banco.ampliarCupo(cupoDisponible, id);
		}
		
		request.setAttribute("mensaje", b);
		RequestDispatcher rd=request.getRequestDispatcher("vistaMensaje.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

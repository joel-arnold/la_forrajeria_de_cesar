package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Producto;
import extras.Excepcion;
import logica.ControladorProducto;

@WebServlet("/ProductoAlta")
public class ProductoAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductoAlta() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		ControladorProducto cp = new ControladorProducto();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Double tamano = Double.parseDouble(request.getParameter("tamano"));
		String umedida = request.getParameter("umedida");
		Double precioventa = Double.parseDouble(request.getParameter("precioventa"));
		String categoria = request.getParameter("categoria");
		String imagen = "bolsa_perros.png";
		
		if(categoria.equals("1")){
			imagen = "bolsa_perros.png";		
		}
		else if(categoria.equals("2")){
			imagen = "bolsa_gatos.jpg";	
		}
		else if(categoria.equals("4")){
			imagen = "bolsa_aves.jpeg";	
		}
		else if(categoria.equals("5")){
			imagen = "caja_pipeta.jpg";
		}
		
		Producto producto = new Producto(codigo, nombre, descripcion, tamano, umedida, precioventa, categoria, imagen);
		try {
			cp.alta(producto);
			sesion.setAttribute("huboError", null);
			response.sendRedirect("productosAdmin.jsp");
		} catch (SQLException e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			response.sendRedirect("error.jsp");
		} catch (Excepcion e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			response.sendRedirect("error.jsp");
		}
	}

}
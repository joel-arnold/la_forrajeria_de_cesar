package logica;

import java.sql.SQLException;
import java.util.ArrayList;
import org.json.*;
import datos.DatosProducto;
import entidades.Producto;
import extras.Excepcion;

public class ControladorProducto {
	
	DatosProducto datos = new DatosProducto();
	
	public ArrayList<Producto> buscarTodos() throws SQLException, Excepcion {
		datos = new DatosProducto();
		return datos.buscarTodos();
	}

	public void alta(Producto producto) throws SQLException, Excepcion{
		datos.alta(producto);
	}
	
	public void modificacion(Producto producto) throws SQLException, Excepcion{
		datos.modificacion(producto);
	}
	
	public void baja(int id) throws SQLException, Excepcion{
		datos.baja(id);
	}
	
}

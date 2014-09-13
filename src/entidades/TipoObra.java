package entidades;

import java.util.HashMap;

public class TipoObra {

	public static final HashMap<Integer, String> opciones = new HashMap<Integer, String>();

	static {
		opciones.put(1, "Libro");
		opciones.put(2, "Revista");
		opciones.put(3, "Normas");
		opciones.put(4, "Tesis");
		opciones.put(5, "Proyecto");
	}

	int idTipo;
	String descripcion;

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

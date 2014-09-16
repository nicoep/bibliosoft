package entidades;

public class Obra {
	int idObra;
	String titulo;
	String autor;
	String editorial;
	String cdu;
	String isbn;
	String imagen;
	int stock;
	int idTipo;
	int state;

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String getTipoString() {
		switch (idTipo) {
		case 1: return "Libro";
		case 2: return "Revista";
		case 3: return "Tesis";
		case 4: return "Norma";
		case 5: return "Proyecto";
		}
		return "";
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getCdu() {
		return cdu;
	}

	public void setCdu(String cdu) {
		this.cdu = cdu;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}

package es.banco.modelo;

public class TarjetaCredito {
	private int id;
	private String numero;
	private int cupoMaximo;
	private int cupoDisponible;
	private String tipo;
	private String numeroComprobacion;
	private String contraseña;
	
	//CONSTRUCTORES
	
	public TarjetaCredito(int id, String numero, int cupoMaximo,
			int cupoDisponible, String tipo, String numeroComprobacion,
			String contraseña) {
		super();
		this.id = id;
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contraseña = contraseña;
	}

	public TarjetaCredito(String numero, int cupoMaximo, int cupoDisponible,
			String tipo, String numeroComprobacion, String contraseña) {
		super();
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contraseña = contraseña;
	}

	public TarjetaCredito() {
		super();
	}
	
	//METODOS GETTERS Y SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public int getCupoDisponible() {
		return cupoDisponible;
	}

	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumeroComprobacion() {
		return numeroComprobacion;
	}

	public void setNumeroComprobacion(String numeroComprobacion) {
		this.numeroComprobacion = numeroComprobacion;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
	
	

}

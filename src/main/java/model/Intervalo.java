package model;

public class Intervalo {
	private String simbolo;
	private int precipitacion; // Transform from .2f to int
	private String horaInicio;
	private String horaFinal;
	private float temperaturaMinima; // Transform from kelvin to celsius
	private float temperaturaMaxima;
	private String cielo;
	
	public Intervalo() {
	}

	public Intervalo(String simbolo, int precipitacion, String horaInicio, String horaFinal,
			float temperaturaMinima, float temperaturaMaxima, String cielo) {
		this.simbolo = simbolo;
		this.precipitacion = precipitacion;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
		this.cielo = cielo;
	}



	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(int precipitacion) {
		this.precipitacion = precipitacion;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public float getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(float temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public float getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(float temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public String getCielo() {
		return cielo;
	}

	public void setCielo(String cielo) {
		this.cielo = cielo;
	}

	@Override
	public String toString() {
		return "Intervalo [simbolo=" + simbolo + ", precipitacion=" + precipitacion
				+ ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", temperaturaMinima=" + temperaturaMinima
				+ ", temperaturaMaxima=" + temperaturaMaxima + ", cielo=" + cielo + "]";
	}

	
}

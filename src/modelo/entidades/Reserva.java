package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	
	
	
	private int numeroQuarto;
	private Date checkinDate;
	private Date checkoutDate;

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {

	}

	public Reserva(int numeroQuarto, Date checkinDate, Date checkoutDate) {
		this.numeroQuarto = numeroQuarto;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}


	public Date getCheckoutDate() {
		return checkoutDate;
	}


	public long duracao() {
		long diff = checkoutDate.getTime() - checkinDate.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public void atualizaDatas(Date checkinDate, Date checkoutDate) {
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto 
				+ " Data Entrada: " 
				+ simpleDateFormat.format(checkinDate)
				+ ", Data de Saida: "
				+ simpleDateFormat.format(checkoutDate)
				+ ", "
				+ duracao()
				+ " noites";
	}
	
	
	
}

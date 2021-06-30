package desafio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Anuncio {
	private String nome;
	private String cliente;
	private Date dataInicio;
	private Date dataTermino;
	private int investimentoDia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public int getInvestimentoDia() {
		return investimentoDia;
	}

	public void setInvestimentoDia(int investimentoDia) {
		this.investimentoDia = investimentoDia;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Anuncio [nome=");
		builder.append(nome);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", dataInicio=");
		builder.append(dataInicio);
		builder.append(", dataTermino=");
		builder.append(dataTermino);
		builder.append(", investimentoDia=");
		builder.append(investimentoDia);
		builder.append("]");
		return builder.toString();
	}

	public static String retornaData(Date data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataString = format.format(data);
		return dataString;
	}

	public static Date retornaData(String data) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataDate = format.parse(data);
		return dataDate;
	}

	public double valorInvestido(Date dataInicio, Date dataTermino, double valorInvestido) throws ParseException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(retornaData(dataInicio), format);
		LocalDate date2 = LocalDate.parse(retornaData(dataTermino), format);

		long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		
		if (daysBetween == 0)
			return valorInvestido;
		else
			return (daysBetween + 1) * valorInvestido;
	}

}

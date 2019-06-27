import java.util.Date;

import entidades.Cidade;
import entidades.Hotel;

public class Pacote {

	private int codpac;
	private Cidade cid;
	private int valor;
	private Date dataInicio;
	private Date dataFim;
	private Hotel hotel;
	
	public Pacote(int codpac, Cidade cid, int valor, Date dataInicio, Date dataFim, Hotel hotel) {
		super();
		this.codpac = codpac;
		this.cid = cid;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.hotel = hotel;
	}
	
	public Pacote(int codpac, Cidade cid, int valor, Date dataInicio, Date dataFim) {
		super();
		this.codpac = codpac;
		this.cid = cid;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getCodpac() {
		return codpac;
	}

	public void setCodpac(int codpac) {
		this.codpac = codpac;
	}

	public Cidade getCid() {
		return cid;
	}

	public void setCid(Cidade cid) {
		this.cid = cid;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
	
}

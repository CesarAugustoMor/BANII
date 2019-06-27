import java.util.Date;

import entidades.PontoTuristico;

public class AtracaoPacote {

	
	private Pacote pacote;
	private PontoTuristico pt;
	private Date diaVisita;
	
	public AtracaoPacote(Pacote pacote, PontoTuristico pt, Date diaVisita) {
		super();
		this.pacote = pacote;
		this.pt = pt;
		this.diaVisita = diaVisita;
	}
	
	
	public Pacote getPacote() {
		return pacote;
	}
	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	public PontoTuristico getPt() {
		return pt;
	}
	public void setPt(PontoTuristico pt) {
		this.pt = pt;
	}
	public Date getDiaVisita() {
		return diaVisita;
	}
	public void setDiaVisita(Date diaVisita) {
		this.diaVisita = diaVisita;
	}
	
	
	
}

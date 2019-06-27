/**
 * 
 */
package entidades;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author César Agusto Moro Fürst
 *
 */
public class CasaShow {
	private Integer cod;
	private String nome;
	private String descricao;
	private String endereco;
	private LocalTime horaInicio;
	private String diaFechado;
	private Integer codRest;
	private Integer precoMedio;
	private String especialidade;
	/**
	 * @return the cod
	 */
	public Integer getCod() {
		return cod;
	}
	/**
	 * @param cod the cod to set
	 */
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		if (!nome.equals("")) {
			this.nome = nome;
		}
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		if (!nome.equals("")) {
			this.descricao = descricao;
		}
	}
	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		if (!endereco.equals("")) {
			this.endereco = endereco;
		}
	}
	/**
	 * @return the horaInicio
	 */
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	/**
	 * @return the horaInicio
	 */
	public String getHoraInicioToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
		return horaInicio.format(formatter);
	}
	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(String horaInicio) {
		DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_TIME;
		this.horaInicio = LocalTime.parse(horaInicio,formatter);
	}
	/**
	 * @return the diaFechado
	 */
	public String getDiaFechado() {
		return diaFechado;
	}
	/**
	 * @param diaFechado the diaFechado to set
	 */
	public void setDiaFechado(String diaFechado) {
		this.diaFechado = diaFechado;
	}
	/**
	 * @return the codRest
	 */
	public Integer getCodRest() {
		return codRest;
	}
	/**
	 * @param codRest the codRest to set
	 */
	public void setCodRest(Integer codRest) {
		this.codRest = codRest;
	}
	
/**
	 * @return the precoMedio
	 */
	public Integer getPrecoMedio() {
		return precoMedio;
	}
	/**
	 * @param precoMedio the precoMedio to set
	 */
	public void setPrecoMedio(Integer precoMedio) {
		this.precoMedio = precoMedio;
	}
	/**
	 * @return the especialidade
	 */
	public String getEspecialidade() {
		return especialidade;
	}
	/**
	 * @param especialidade the especialidade to set
	 */
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	/**
	 * @return {@link StringBuilder} com a string já formatada para cadastrar um ponto no banco de dados
	 */
	public StringBuilder pontoParaCadastro() {
		//inserir_pontosturistico(no varchar,endere varchar,descri varchar)
		StringBuilder result = new StringBuilder();
		result.append("SELECT inserir_pontosturistico(");
		if (!isNull(nome)) {
			result.append('\'')
				.append(nome)
				.append('\'')
				.append(',');
			if (!isNull(endereco)) {
				result.append('\'')
					.append(endereco)
					.append('\'')
					.append(',');
				if (!isNull(descricao)) {
					result.append('\'')
						.append(descricao)
						.append("\');");
					return result;
				} else
					return null;
			} else
				return null;
		}
		return null;
	}
	/**
	 * @return {@link StringBuilder} com a string já formatada para cadastrar um ponto no banco de dados. DEVE se utilizar primeiro o método {@link PontoTuristico}, em seguida realizar uma busca no banco para se obter o código do ponto
	 */
	public StringBuilder casaShowParaCadastro() {
/*
inserir_casasshow(codp numeric,horarioini time without time zone,diafe varchar,codres numeric,precome numeric,especi varchar) returns boolean language 'plpgsql' as $$
inserir_casasshow(codp numeric,horarioini time without time zone,diafe varchar)
*/
		StringBuilder result = new StringBuilder();
		result.append("SELECT inserir_casasshow(");
		if (!isNull(cod)) {
			result.append(cod);
			if (!isNull(horaInicio)) {
				result.append(',')
				.append('\'')
					.append(getHoraInicioToString())
					.append('\'');
				if (!isNull(diaFechado)) {
					result.append(',')
						.append('\'')
						.append(diaFechado)
						.append('\'');
					if (!isNull(codRest)) {
						result.append(',')
							.append(codRest);
						if (!isNull(precoMedio)) {
							result.append(',')
								.append(precoMedio);
							if (!isNull(especialidade)) {
								result.append(',')
									.append('\'')
									.append(especialidade)
									.append("\');");
								return result;
							} else {
								return null;
							}
						} else {
							return null;
						}
					} else {
						result.append(");");
						return result;
					}
				} else {
					return null;
				}
			}else
				return null;
		}
		return null;
	}
	/**
	 * @return true se o objeto em questão é null
	 */
	private boolean isNull(Object valor) {
		return valor==null;
	}
}
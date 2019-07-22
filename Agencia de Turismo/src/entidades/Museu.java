/**
 * 
 */
package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author César Agusto Moro Fürst
 *
 */
public class Museu {
	private Integer cod;
	private String nome;
	private String descricao;
	private String endereco;
	private LocalDate dataFund;
	private Integer numeroSalas;
	private Integer numeroFundadores;
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
		this.nome = nome;
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
		this.descricao = descricao;
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
		this.endereco = endereco;
	}
	/**
	 * @return the dataFund
	 */
	public LocalDate getDataFund() {
		return dataFund;
	}
	/**
	 * @return the dataFund
	 */
	public String getDataFundToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataFund.format(formatter);
	}
	/**
	 * @param dataFund the dataFund to set
	 */
	public void setDataFund(LocalDate dataFund) {
		this.dataFund = dataFund;
	}
	/**
	 * @param dataFundacao
	 */
	public void setDataFund(String dataFundacao) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (dataFundacao!=null) {
			this.dataFund = LocalDate.parse(dataFundacao, formatter);
		}
	}
	/**
	 * @return the numeroSalas
	 */
	public Integer getNumeroSalas() {
		return numeroSalas;
	}
	/**
	 * @param numeroSalas the numeroSalas to set
	 */
	public void setNumeroSalas(Integer numeroSalas) {
		this.numeroSalas = numeroSalas;
	}
	/**
	 * @return the numeroFundadores
	 */
	public Integer getNumeroFundadores() {
		return numeroFundadores;
	}
	/**
	 * @param numeroFundadores the numeroFundadores to set
	 */
	public void setNumeroFundadores(Integer numeroFundadores) {
		this.numeroFundadores = numeroFundadores;
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
	public StringBuilder museuParaCadastro() {
		StringBuilder result = new StringBuilder();
        result.append("SELECT inserir_museu(");
		if (!isNull(cod)) {
			result.append(cod)
				.append(',');
			if (!isNull(dataFund)) {
				result.append('\'')
					.append(dataFund)
					.append('\'')
					.append(',');
				if (!isNull(numeroSalas)) {
					result.append(numeroSalas)
						.append(',');
					if (!isNull(numeroFundadores)) {
						result.append(numeroFundadores)
							.append(");");
						return result;
					} else {
						return null;
					}
				} else {
					return null;
				}
			} else {
				return null;
			}
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

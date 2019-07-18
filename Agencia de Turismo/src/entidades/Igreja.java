/**
 * 
 */
package entidades;

/**
 * @author Lucas
 *
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Igreja {

	private Integer cod;
	private String nome;
	private String descricao;
	private String endereco;
	private LocalDate dataConstrucao;
	private String estiloConstrucao;

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
	 * @return the dataConstrucao
	 */
	public LocalDate getDataConstrucao() {
		return dataConstrucao;
	}

	/**
	 * @return the dataConstrucao
	 */
	public String getDataConstrucaoToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataConstrucao.format(formatter);
	}

	/**
	 * @param dataConstrucao the dataConstrucao to set
	 */
	public void setDataConstrucao(LocalDate dataConstrucao) {
		this.dataConstrucao = dataConstrucao;
	}

	/**
	 * @return the estiloConstrucao
	 */
	public String getEstiloConstrucao() {
		return estiloConstrucao;
	}

	/**
	 * @param estiloConstrucao the estiloConstrucao to set
	 */
	public void setEstiloConstrucao(String estiloConstrucao) {
		this.estiloConstrucao = estiloConstrucao;
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
	public StringBuilder igrejaParaCadastro() {
		StringBuilder result = new StringBuilder();
        result.append("SELECT inserir_Igreja(");
		if (!isNull(cod)) {
			result.append(cod)
				.append(',');
			if (!isNull(dataConstrucao)) {
				result.append('\'')
					.append(dataConstrucao)
					.append('\'')
					.append(',');
				if (!isNull(estiloConstrucao)) {
					result.append('\'')
						.append(estiloConstrucao)
						.append("\');");
					return result;
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
	 * @return true se o objeto em questão é nulo
	 */
	private boolean isNull(Object valor) {
		return valor==null;
	}

	/**
	 * @param dataConstrucao
	 */
	public void setDataConstrucao(String dataConstrucao) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (dataConstrucao!=null) {
			this.dataConstrucao = LocalDate.parse(dataConstrucao, formatter);
		}
	}
}

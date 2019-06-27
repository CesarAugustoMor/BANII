/**
 * 
 */
package entidades;

/**
 * @author Lucas
 *
 */
public class Cidade {

	private Integer cod;
	private String nome;
	private String estado;
	private Integer populacao;

	public Cidade(Integer codcid, String nome, String estado, Integer populacao) {

		this.cod = codcid;
		this.nome = nome;
		this.estado = estado;
		this.populacao = populacao;
	}

	public Cidade(String nome, String estado, Integer populacao) {

		this.nome = nome;
		this.estado = estado;
		this.populacao = populacao;
	}

	/**
	 * @return the cod
	 */
	public Integer getCodcid() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCodcid(Integer cod) {
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the populacao
	 */
	public Integer getPopulacao() {
		return populacao;
	}

	/**
	 * @param populacao the populacao to set
	 */
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	/**
	 * @return {@link StringBuilder} com a string já formatada para cadastrar uma cidade.
	 */
	public StringBuilder cidadeParaCadastro() {
		StringBuilder result = new StringBuilder();
		result.append("SELECT inserir_cidade(");
		if (!isNull(nome)) {
			result.append('\'')
				.append(nome)
				.append('\'')
				.append(',');
			if (!isNull(estado)) {
				result.append('\'')
					.append(estado)
					.append('\'')
					.append(',');
				if (!isNull(populacao)) {
					result.append('\'')
						.append(populacao)
						.append("\');");
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
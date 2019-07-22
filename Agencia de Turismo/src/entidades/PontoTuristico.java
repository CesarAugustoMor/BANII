/**
 * 
 */
package entidades;

/**
 * @author Lucas
 *
 */
public class PontoTuristico {

	private Integer cod;
	private String nome;
	private String descricao;
	private String endereco;

	/**
	 * @return the cod
	 */
	public Integer getCod() {
		return cod;
	}

	/**
	 * @param codpot the cod to set
	 */
	public void setCod(Integer codpot) {
		this.cod = codpot;
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
	 * @return true se o objeto em questão é nulo
	 */
	private boolean isNull(Object valor) {
		return valor==null;
	}
}
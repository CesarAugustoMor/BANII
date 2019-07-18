/**
 * 
 */
package entidades;

/**
 * @author Lucas
 *
 */
public class Hotel {

	private Integer cod;
	private String nome;
	private String endereco;
	private Integer categoria;
	private Integer numeroQuartos;
	private Integer rest;

	/**
	 * @return the codhot
	 */
	public Integer getCodhot() {
		return cod;
	}

	/**
	 * @param codhot the codhot to set
	 */
	public void setCodhot(Integer codhot) {
		this.cod = codhot;
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
	 * @return the categoria
	 */
	public Integer getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the numeroquartos
	 */
	public Integer getNumeroquartos() {
		return numeroQuartos;
	}

	/**
	 * @param numeroquartos the numeroquartos to set
	 */
	public void setNumeroquartos(Integer numeroquartos) {
		this.numeroQuartos = numeroquartos;
	}

	/**
	 * @return the rest
	 */
	public Integer getRest() {
		return rest;
	}

	/**
	 * @param rest the rest to set
	 */
	public void setRest(Integer rest) {
		this.rest = rest;
	}
	/**
	 * @return {@link StringBuilder} com a string já formatada para cadastrar um hotel no banco de dados.
	 */
	public StringBuilder hotelParaCadastro() {
		StringBuilder result = new StringBuilder();
        result.append("SELECT inserir_hotel(");
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
				if (!isNull(categoria)) {
					result.append(categoria)
						.append(',');
					if (!isNull(numeroQuartos)) {
						result.append(numeroQuartos)
							.append(',');
						if (!isNull(rest)) {
							result.append(rest)
								.append(");");
							return result;
						} else {
							result.append(");");
							return result;
						}
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

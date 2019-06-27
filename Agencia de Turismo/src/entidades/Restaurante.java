/**
 * 
 */
package entidades;

/**
 * @author Lucas
 *
 */
public class Restaurante {

	private Integer codrest;
	private String nome;
	private String endereco;
	private Integer categoria;
	private Integer precoMedio;
	private String especialidade;
	
	
	public Restaurante(Integer codrest, String nome, String endereco, Integer categoria, Integer precomedio, String especialidade) {
		
		this.codrest = codrest;
		this.nome = nome;
		this.endereco = endereco;
		this.categoria = categoria;
		this.precoMedio	= precomedio;
		this.especialidade = especialidade;
	}
	
	public Restaurante(Integer codrest, String nome, String endereco, Integer categoria) {
		
		this.codrest = codrest;
		this.nome = nome;
		this.endereco = endereco;
		this.categoria = categoria;
	}

	/**
	 * 
	 */
	public Restaurante() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codrest
	 */
	public Integer getCodrest() {
		return codrest;
	}

	/**
	 * @param codrest the codrest to set
	 */
	public void setCodrest(Integer codrest) {
		this.codrest = codrest;
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
	 * @return the precoMedio
	 */
	public Integer getPrecomedio() {
		return precoMedio;
	}

	/**
	 * @param precomedio the precoMedio to set
	 */
	public void setPrecomedio(Integer precomedio) {
		this.precoMedio = precomedio;
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
	 * @return {@link StringBuilder} com a string já formatada para cadastrar um restaurante.
	 */
	public StringBuilder restauranteParaCadastro() {
		StringBuilder result = new StringBuilder();
        result.append("SELECT inserir_restaurante(");
		if (!isNull(nome)) {
			System.out.println(nome+"sdfg");
			result.append('\'')
				.append(nome)
				.append('\'')
				.append(',');
			if (!isNull(endereco)) {
				System.out.println(endereco+"fgj");
				result.append('\'')
					.append(endereco)
					.append('\'')
					.append(',');
				if (!isNull(categoria)) {
					System.out.println(categoria+"klj");
					result.append(categoria);
					if (!isNull(precoMedio)) {
						System.out.println(precoMedio);
						result.append(',')
							.append(precoMedio);
						if (!isNull(especialidade)) {
							System.out.println(especialidade);
							result.append(',')
								.append('\'')
								.append(especialidade)
								.append("\');");
							return result;
						} else {
							result.append("\');");
							return result;
						}
					} else if (!isNull(especialidade)) {
						System.out.println(especialidade);
						result.append(',')
							.append('\'')
							.append(especialidade)
							.append("\');");
						return result;
					} else {
						result.append(");");
						return result;
					}
				} else {
					result.append(");");
					return result;
				}
			} else {
				System.out.println("endereço é nulo");
				return null;
			}
		}
		System.out.println("nome é nulo");
		return null;
	}
	/**
	 * @return true se o objeto em questão é null
	 */
	private boolean isNull(Object valor) {
		return valor==null;
	}
}
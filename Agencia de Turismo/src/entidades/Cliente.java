/**
 * 
 */
package entidades;

/**
 * @author César Augusto Moro Fürst
 *
 */
public class Cliente {
	private Integer cod;
	private Integer cpf;
	private String nome;
	private Integer telefone;
	private String email;

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCodigo(Integer cod) {
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
	 * @return the telefone
	 */
	public Integer getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the cpf
	 */
	public Integer getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return {@link StringBuilder} com a string já formatada para cadastrar um cliente.
	 */
	public StringBuilder clienteParaCadastro() {
		StringBuilder result = new StringBuilder();
        result.append("SELECT inserir_cliente(");
        if (!isNull(cpf)) {
            result.append(cpf)
                    .append(',');
            if (!isNull(nome)) {
                result.append('\'')
                        .append(nome)
                        .append('\'');
                if (!isNull(telefone)) {
                    result.append(',')
                    	.append('\'')
                    	.append(telefone)
                            .append('\'');
                    if (!isNull(email)) {
						result.append(',')
							.append('\'')
                        .append(email)
                        .append("\');");
						return result;
					} else {
	                	result.append("\');");
	                	return result;
					}
                } else
                	if (!isNull(email)) {
						result.append(',')
							.append('\'')
                        .append(email)
                        .append("\');");
						return result;
					} else {
	                	result.append("\');");
	                	return result;
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

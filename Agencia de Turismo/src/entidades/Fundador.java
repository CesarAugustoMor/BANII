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
public class Fundador {
	private Integer cod;
	private String nome;
	private LocalDate dataNascimento;
	private LocalDate dataFalecimento;
	private String nacionalidade;
	private String profisao;
	
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
	 * @return the dataNascimento
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @return the dataNascimento
	 */
	public String getDataNascimentoToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataNascimento.format(formatter);
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(String dataNascimento) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
	}
	/**
	 * @return the dataFalecimento
	 */
	public LocalDate getDataFalecimento() {
		return dataFalecimento;
	}
	/**
	 * @return the dataFalecimento
	 */
	public String getDataFalecimentoToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataFalecimento.format(formatter);
	}
	/**
	 * @param dataFalecimento the dataFalecimento to set
	 */
	public void setDataFalecimento(LocalDate dataFalecimento) {
		this.dataFalecimento = dataFalecimento;
	}
	/**
	 * @param dataFalecimento the dataFalecimento to set
	 */
	public void setDataFalecimento(String dataFalecimento) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataFalecimento = LocalDate.parse(dataFalecimento, formatter);
	}
	/**
	 * @return the nacionalidade
	 */
	public String getNacionalidade() {
		return nacionalidade;
	}
	/**
	 * @param nacionalidade the nacionalidade to set
	 */
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	/**
	 * @return the profisao
	 */
	public String getProfisao() {
		return profisao;
	}
	/**
	 * @param profisao the profisao to set
	 */
	public void setProfisao(String profisao) {
		this.profisao = profisao;
	}
	/**
	 * @return {@link StringBuilder} com a string já formatada para cadastrar um fundador no banco de dados.
	 */
	public StringBuilder fundadorParaCadastro() {
		StringBuilder result = new StringBuilder();
        result.append("SELECT inserir_fundador(");
		if (!isNull(nome)) {
			result.append('\'')
				.append(nome)
				.append('\'')
				.append(',');
			if (!isNull(dataNascimento)) {
				result.append(dataNascimento)
					.append(',');
				if (!isNull(dataFalecimento)) {
					result.append(dataFalecimento)
						.append(',');
					if (!isNull(nacionalidade)) {
						result.append('\'')
							.append(nacionalidade)
							.append('\'')
							.append(',');
						if (!isNull(profisao)) {
							result.append('\'')
								.append(profisao)
								.append("\');");
							return result;

						} else {
							return null;
						}

					} else {
						return null;
					}
				} else {
					if (!isNull(nacionalidade)) {
						result.append('\'')
							.append(nacionalidade)
							.append('\'')
							.append(',');
						if (!isNull(profisao)) {
							result.append('\'')
								.append(profisao)
								.append("\');");
							return result;
						} else {
							return null;
						}
					} else {
						return null;
					}
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
}
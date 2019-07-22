/**
 * 
 */
package entidades;

/**
 * @author César Agusto Moro Fürst
 *
 */
public class Quarto {
	//quartos(#&codhot, #codquart, tipoquart, valor);
	private int codhot;
	private int cod;
	private String tipoQuarto;
	private double valor;
	/**
	 * @return the codhot
	 */
	public int getCodhot() {
		return codhot;
	}
	/**
	 * @param codhot the codhot to set
	 */
	public void setCodhot(int codhot) {
		this.codhot = codhot;
	}
	/**
	 * @return the cod
	 */
	public int getCod() {
		return cod;
	}
	/**
	 * @param cod the cod to set
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}
	/**
	 * @return the tipoQuarto
	 */
	public String getTipoQuarto() {
		return tipoQuarto;
	}
	/**
	 * @param tipoQuarto the tipoQuarto to set
	 */
	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * @return {@link StringBuilder} com a string já formatada para cadastrar um quarto.
	 */
	public StringBuilder quartoParaCadastro() {
		StringBuilder result = new StringBuilder();
		result.append("SELECT inserir_quarto(");
		if (!isNull(codhot)) {
			result.append(codhot)
				.append(',');
			if (!isNull(tipoQuarto)) {
				result.append('\'')
					.append(tipoQuarto)
					.append('\'')
					.append(',');
				if (!isNull(valor)) {
					result.append(valor)
						.append(");");
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
}

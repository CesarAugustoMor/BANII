/**
 * 
 */
package entidades;

/**
 * @author C�sar Agusto Moro F�rst
 *
 */
public class Quarto {
	//quartos(#&codhot, #codquart, tipoquart, valor);
	private int codhot;
	private int cod;
	private int tipoQuarto;
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
	public int getTipoQuarto() {
		return tipoQuarto;
	}
	/**
	 * @param tipoQuarto the tipoQuarto to set
	 */
	public void setTipoQuarto(int tipoQuarto) {
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
	 * @return {@link StringBuilder} com a string j� formatada para cadastrar um quarto.
	 */
	public StringBuilder quartoParaCadastro() {
		StringBuilder result = new StringBuilder();
		result.append("SELECT inserir_quarto(");
		if (!isNull(codhot)) {
			result.append(codhot)
				.append(',');
			if (isNull(tipoQuarto)) {
				result.append(tipoQuarto)
					.append(',');
				if (isNull(valor)) {
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
	 * @return true se o objeto em quest�o � nulo
	 */
	private boolean isNull(Object valor) {
		return valor==null;
	}
}

/**
 * 
 */
package janelas;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author C�sar Agusto Moro F�rst
 *
 */
public class Mesnsagens {

	/**
	 * Mostra mensagem informando erro ao cadastrar
	 */
	public static void mensagemErroCadastrar() {
		JOptionPane.showMessageDialog(null, "Erro ao cadastrar. Revise os dados inseridos.", "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(Toolkit.getDefaultToolkit().getImage(CadastroQuartos.class.getResource("/Imagens/Erro32.png"))));
	}
	
	/**
	 * Mostra mensagem informando sucesso ao cadastrar
	 */
	public static void mensegemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar.", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Toolkit.getDefaultToolkit().getImage(CadastroQuartos.class.getResource("/Imagens/Sucesso32.png"))));
	}

	/**
	 * Mostra mensagem solicitando que seja realizado a conec��o com o banco
	 */
	public static void mensagemConectarBanco() {
		JOptionPane.showMessageDialog(null, "Favor realizar primeiro a conec��o com o servidor.", "Alerta", JOptionPane.WARNING_MESSAGE, new ImageIcon(Toolkit.getDefaultToolkit().getImage(CadastroQuartos.class.getResource("/Imagens/Alerta32.png"))));
	}

	/**
	 * Mostra mensagem que seja selecionado o item recem cadastrado.
	 */
	public static void mensagemRealizarCadastro() {
		JOptionPane.showMessageDialog(null, "Favor clique em atualizar para re-listar e selecionar o novo item recem cadastrado.", "Informa��o", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Toolkit.getDefaultToolkit().getImage(CadastroQuartos.class.getResource("/Imagens/Informacao32.png"))));
	}

	/**
	 * Mostra mensagem informando que conec��o com o servidor foi realizada com sucesso
	 */
	public static void mensagemConeccaoRealizada() {
		JOptionPane.showMessageDialog(null, "Conec��o realizada com sucesso.", "Informa��o", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Toolkit.getDefaultToolkit().getImage(CadastroQuartos.class.getResource("/Imagens/Sucesso32.png"))));
	}

	/**
	 * Mostra mensagem Alertando que n�o foi possivel realizar a concec��o com o servidor.
	 */
	public static void mensagemConeccaoFracassada() {
		JOptionPane.showMessageDialog(null, "N�o � possivel conectar ao banco de dados. Verifique as informa��es. Tente novamente", "Alerta", JOptionPane.ERROR_MESSAGE, new ImageIcon(Toolkit.getDefaultToolkit().getImage(CadastroQuartos.class.getResource("/Imagens/Erro32.png"))));
	}
}

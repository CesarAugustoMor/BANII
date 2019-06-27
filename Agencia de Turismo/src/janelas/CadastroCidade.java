package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;

public class CadastroCidade {

	private JFrame frmCadatroDeCidade;
	private JTextField nomeCidade;
	private JTextField estadoCidade;
	private JTextField populacaoCidade;
	private Connection conection;

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCidade window = new CadastroCidade(conection);
					window.frmCadatroDeCidade.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroCidade(Connection conection) {
		this.conection=conection;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadatroDeCidade = new JFrame();
		frmCadatroDeCidade.setLocationByPlatform(true);
		frmCadatroDeCidade.setResizable(false);
		frmCadatroDeCidade.setType(Type.UTILITY);
		frmCadatroDeCidade.setTitle("Cadatro de Cidade");
		frmCadatroDeCidade.setBounds(100, 100, 230, 250);
		frmCadatroDeCidade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setToolTipText("Nome da cidade.");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeCidade = new JTextField();
		nomeCidade.setToolTipText("Nome da ciadade.");
		nomeCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado: *");
		lblEstado.setToolTipText("Estado em que a cidade pertence.");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		estadoCidade = new JTextField();
		estadoCidade.setToolTipText("Estado em que a cidade pertence.");
		estadoCidade.setColumns(10);
		
		JLabel lblPopulcao = new JLabel("Popula\u00E7\u00E3o: *");
		lblPopulcao.setToolTipText("N\u00FAmero de habitantes da cidade.");
		lblPopulcao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		populacaoCidade = new JTextField();
		populacaoCidade.setToolTipText("N\u00FAmero de habitantes da cidade.");
		populacaoCidade.setColumns(10);
		
		JLabel lblCamposObrigatorios = new JLabel("* Campos Obrigatorios.");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadatroDeCidade.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmCadatroDeCidade.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNome)
						.addComponent(lblEstado)
						.addComponent(lblPopulcao)
						.addComponent(populacaoCidade)
						.addComponent(estadoCidade)
						.addComponent(nomeCidade, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(lblCamposObrigatorios))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nomeCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEstado)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(estadoCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPopulcao)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(populacaoCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCamposObrigatorios)
					.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadatroDeCidade.getContentPane().setLayout(groupLayout);
	}

}

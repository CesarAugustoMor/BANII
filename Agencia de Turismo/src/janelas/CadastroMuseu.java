package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class CadastroMuseu {

	private JFrame frmCadastroDeMuseu;
	private JTextField enderecoMuseu;
	private JTextField nomeMuseu;
	private JTextField dataFundacao;
	private JTextField numeroSalasMuseu;
	private JTextField numeroFundadores;
	private Connection conection;

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMuseu window = new CadastroMuseu(conection);
					window.frmCadastroDeMuseu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroMuseu(Connection conection) {
		this.conection=conection;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeMuseu = new JFrame();
		frmCadastroDeMuseu.setResizable(false);
		frmCadastroDeMuseu.setTitle("Cadastro de Museu");
		frmCadastroDeMuseu.setType(Type.UTILITY);
		frmCadastroDeMuseu.setBounds(100, 100, 260, 670);
		frmCadastroDeMuseu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JEditorPane descricaoMuseu = new JEditorPane();
		
		JLabel labelDescricao = new JLabel("Descri\u00E7\u00E3o: *");
		labelDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoMuseu = new JTextField();
		enderecoMuseu.setColumns(10);
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o: *");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeMuseu = new JTextField();
		nomeMuseu.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome: *");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDataDeFundao = new JLabel("Data de funda\u00E7\u00E3o: *");
		lblDataDeFundao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		dataFundacao = new JTextField();
		lblDataDeFundao.setLabelFor(dataFundacao);
		dataFundacao.setColumns(10);
		
		JLabel lblNmeroDeSalas = new JLabel("N\u00FAmero de Salas: *");
		lblNmeroDeSalas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		numeroSalasMuseu = new JTextField();
		lblNmeroDeSalas.setLabelFor(numeroSalasMuseu);
		numeroSalasMuseu.setColumns(10);
		
		JLabel lblNumeroDeFundadores = new JLabel("N\u00FAmero de Fundadores: *");
		lblNumeroDeFundadores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		numeroFundadores = new JTextField();
		numeroFundadores.setColumns(10);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeMuseu.dispose();
			}
		});
		cancelar.setToolTipText("Cancela o cadastro de um quarto.");
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeMuseu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(nomeMuseu, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(labelEndereco, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(enderecoMuseu, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(lblDataDeFundao)
							.addComponent(dataFundacao)
							.addComponent(lblNmeroDeSalas)
							.addComponent(numeroSalasMuseu)
							.addComponent(lblNumeroDeFundadores)
							.addComponent(numeroFundadores))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(labelDescricao, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addComponent(descricaoMuseu, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cadastrar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
							.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(nomeMuseu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(labelEndereco, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(enderecoMuseu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDataDeFundao)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dataFundacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNmeroDeSalas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numeroSalasMuseu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNumeroDeFundadores)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numeroFundadores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelDescricao, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(descricaoMuseu, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadastrar)
						.addComponent(cancelar))
					.addContainerGap())
		);
		frmCadastroDeMuseu.getContentPane().setLayout(groupLayout);
	}

}
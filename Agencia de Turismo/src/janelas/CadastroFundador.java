package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class CadastroFundador {

	private JFrame frmCadastroDeFundador;
	private JTextField nomeFundador;
	private JLabel lblNacionalidade;
	private JTextField nacionalidadeFundador;
	private JLabel lblProfisso;
	private JTextField profissaoFundador;
	private JLabel lblDataNascimento;
	private JTextField dataNascimentoFundador;
	private JLabel lblDataFalecimento;
	private JTextField dataFalecimentoFundador;
	private JButton button;
	private JButton button_1;
	private Connection conection;

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFundador window = new CadastroFundador(conection);
					window.frmCadastroDeFundador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroFundador(Connection conection) {
		this.conection=conection;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeFundador = new JFrame();
		frmCadastroDeFundador.setTitle("Cadastro de Fundador de Museu");
		frmCadastroDeFundador.setResizable(false);
		frmCadastroDeFundador.setBounds(100, 100, 260, 350);
		frmCadastroDeFundador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		nomeFundador = new JTextField();
		nomeFundador.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome: *");
		labelNome.setLabelFor(nomeFundador);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNacionalidade = new JLabel("Nacionalidade: *");
		lblNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nacionalidadeFundador = new JTextField();
		lblNacionalidade.setLabelFor(nacionalidadeFundador);
		nacionalidadeFundador.setColumns(10);
		
		lblProfisso = new JLabel("Profiss\u00E3o: *");
		lblProfisso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		profissaoFundador = new JTextField();
		profissaoFundador.setColumns(10);
		
		lblDataNascimento = new JLabel("Data nascimento: *");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		dataNascimentoFundador = new JTextField();
		lblDataNascimento.setLabelFor(dataNascimentoFundador);
		dataNascimentoFundador.setColumns(10);
		
		lblDataFalecimento = new JLabel("Data falecimento:");
		lblDataFalecimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		dataFalecimentoFundador = new JTextField();
		lblDataFalecimento.setLabelFor(dataFalecimentoFundador);
		dataFalecimentoFundador.setColumns(10);
		
		button = new JButton("Cadastrar");
		button.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
		button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeFundador.dispose();
			}
		});
		button_1.setToolTipText("Cancela o cadastro de um quarto.");
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeFundador.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeFundador, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
								.addComponent(lblNacionalidade)
								.addComponent(nacionalidadeFundador)
								.addComponent(lblProfisso)
								.addComponent(profissaoFundador)
								.addComponent(lblDataNascimento)
								.addComponent(dataNascimentoFundador)
								.addComponent(lblDataFalecimento)
								.addComponent(dataFalecimentoFundador)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(nomeFundador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNacionalidade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nacionalidadeFundador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblProfisso)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(profissaoFundador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDataNascimento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dataNascimentoFundador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDataFalecimento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dataFalecimentoFundador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		frmCadastroDeFundador.getContentPane().setLayout(groupLayout);
	}

}

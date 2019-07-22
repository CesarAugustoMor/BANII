package janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JDateChooser;

import entidades.Fundador;
import interacaoBanco.ExecutaQuery;

public class CadastroFundador {

	private JDialog frmCadastroDeFundador;
	private JDateChooser dataFalecimento;
	JDateChooser dataNascimento;
	private JTextField nomeFundador;
	private JLabel lblNacionalidade;
	private JTextField nacionalidadeFundador;
	private JLabel lblProfisso;
	private JTextField profissaoFundador;
	private JLabel lblDataNascimento;
	private JLabel lblDataFalecimento;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private Connection conection;

	/**
	 * Launch the window.
	 */
	public static void Abrir(Connection conection, JFrame frPrincipal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFundador window = new CadastroFundador(conection, frPrincipal);
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
	public CadastroFundador(Connection conection, JFrame frPrincipal) {
		this.conection=conection;
		initialize(frPrincipal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frPrincipal) {
		frmCadastroDeFundador = new JDialog(frPrincipal);
		frmCadastroDeFundador.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		frmCadastroDeFundador.setTitle("Cadastro de Fundador de Museu");
		frmCadastroDeFundador.setResizable(false);
		frmCadastroDeFundador.setBounds(100, 100, 260, 350);
		frmCadastroDeFundador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		nomeFundador = new JTextField();
		nomeFundador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		nomeFundador.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome: *");
		labelNome.setLabelFor(nomeFundador);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNacionalidade = new JLabel("Nacionalidade: *");
		lblNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nacionalidadeFundador = new JTextField();
		nacionalidadeFundador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		lblNacionalidade.setLabelFor(nacionalidadeFundador);
		nacionalidadeFundador.setColumns(10);
		
		lblProfisso = new JLabel("Profiss\u00E3o: *");
		lblProfisso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		profissaoFundador = new JTextField();
		profissaoFundador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		profissaoFundador.setColumns(10);
		
		lblDataNascimento = new JLabel("Data nascimento: *");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblDataFalecimento = new JLabel("Data falecimento:");
		lblDataFalecimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fundador fundador= new Fundador();
				fundador.setNome(getNomeFundador());
				fundador.setDataFalecimento(getDataFalecimento());
				fundador.setDataNascimento(getDataNascimento());
				fundador.setNacionalidade(getNascionalidade());
				fundador.setProfisao(getProfissao());
				if (!ExecutaQuery.cadastra(fundador.fundadorParaCadastro(), conection)) {
					Mesnsagens.mensagemErroCadastrar();
				} else {
					Mesnsagens.mensegemSucessoCadastro();
					frmCadastroDeFundador.dispose();
				}
			}
		});
		btnCadastrar.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeFundador.dispose();
			}
		});
		
		dataFalecimento = new JDateChooser();
		lblDataFalecimento.setLabelFor(dataFalecimento);
		btnCancelar.setToolTipText("Cancela o cadastro de um Fundador.");
		
		dataNascimento = new JDateChooser();
		lblDataNascimento.setLabelFor(dataNascimento);
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeFundador.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
									.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(labelNome, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addComponent(nomeFundador, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
									.addComponent(lblNacionalidade, Alignment.LEADING)
									.addComponent(nacionalidadeFundador, Alignment.LEADING)
									.addComponent(lblProfisso, Alignment.LEADING)
									.addComponent(profissaoFundador, Alignment.LEADING)
									.addComponent(lblDataNascimento, Alignment.LEADING))
								.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDataFalecimento))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(dataFalecimento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(21))))
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
					.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDataFalecimento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dataFalecimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroDeFundador.getContentPane().setLayout(groupLayout);
	}
	/**
	 * @return the nomeCidade
	 */
	private String getNomeFundador() {
		if (nomeFundador.getText().equals("")) {
			return null;
		}
		return nomeFundador.getText().trim();
	}

	/**
	 * @return the dataNascimneto
	 */
	private String getDataNascimento() {
		if (isNull(dataNascimento.getDate())) {
			return null;
		}
		DateFormat df = new SimpleDateFormat(dataNascimento.getDateFormatString());
		return df.format(dataNascimento.getDate());
	}

	/**
	 * @return the dataFalecimento
	 */
	private String getDataFalecimento() {
		if (dataFalecimento.getDate()==null){
			return null;
		}
		DateFormat df = new SimpleDateFormat(dataFalecimento.getDateFormatString());
		return df.format(dataFalecimento.getDate());
	}

	/**
	 * @return the nacionaliadeFundador
	 */
	private String getNascionalidade() {
		if (nacionalidadeFundador.getText().equals("")) {
			return null;
		}
		return nacionalidadeFundador.getText().trim();
	}

	/**
	 * @return the profissao
	 */
	private String getProfissao() {
		if (profissaoFundador.getText().equals("")) {
			return null;
		}
		return profissaoFundador.getText().trim();
	}

	/**
	 * @return true se o objeto em questão é null
	 */
	private boolean isNull(Object valor) {
		return valor==null;
	}
}

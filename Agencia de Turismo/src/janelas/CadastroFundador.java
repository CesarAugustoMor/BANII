package janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Fundador;
import interacaoBanco.ExecutaQuery;

public class CadastroFundador {

	private JDialog frmCadastroDeFundador;
	private JTextField nomeFundador;
	private JLabel lblNacionalidade;
	private JTextField nacionalidadeFundador;
	private JLabel lblProfisso;
	private JTextField profissaoFundador;
	private JLabel lblDataNascimento;
	private JTextField dataNascimentoFundador;
	private JLabel lblDataFalecimento;
	private JTextField dataFalecimentoFundador;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private Connection conection;

	/**
	 * Launch the application.
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
		
		dataNascimentoFundador = new JTextField();
		dataNascimentoFundador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		lblDataNascimento.setLabelFor(dataNascimentoFundador);
		dataNascimentoFundador.setColumns(10);
		
		lblDataFalecimento = new JLabel("Data falecimento:");
		lblDataFalecimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		dataFalecimentoFundador = new JTextField();
		dataFalecimentoFundador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		lblDataFalecimento.setLabelFor(dataFalecimentoFundador);
		dataFalecimentoFundador.setColumns(10);
		
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
					mensagemErroCadastrar();
				} else {
					mensegemSucessoCadastro();
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
		btnCancelar.setToolTipText("Cancela o cadastro de um quarto.");
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
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
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
		if (dataNascimentoFundador.getText().equals("")) {
			return null;
		}
		return dataNascimentoFundador.getText().trim();
	}

	/**
	 * @return the dataFalecimento
	 */
	private String getDataFalecimento() {
		if (dataFalecimentoFundador.getText().equals("")) {
			return null;
		}
		return dataFalecimentoFundador.getText().trim();
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
	 * Mostra mensagem solicitando que seja revisado os dados inseridos
	 */
	private void mensagemErroCadastrar() {
		JOptionPane.showMessageDialog(null, "Erro ao inserir o Cliente. Revise os dados inseridos.", "Alerta", 0);
	}
	private void mensegemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar a Casa de Show.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

}

package janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Igreja;
import interacaoBanco.ExecutaQuery;

public class CadastroIgreja {

	private JDialog frmCadastroDeIgreja;
	private JTextField enderecoPontoIgreja;
	private JTextField nomePontoIgreja;
	private JTextField dataConstrucao;
	private JTextField estiloConstrucao;
	private Connection conection;
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnCancelar = new JButton("Cancelar");
	JEditorPane descricaoPontoIgreja = new JEditorPane();

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection, JFrame frPrincipal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroIgreja window = new CadastroIgreja(conection, frPrincipal);
					window.frmCadastroDeIgreja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroIgreja(Connection conection, JFrame frPrincipal) {
		this.conection=conection;
		initialize(frPrincipal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frPrincipal) {
		frmCadastroDeIgreja = new JDialog(frPrincipal);
		frmCadastroDeIgreja.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		frmCadastroDeIgreja.setType(Type.UTILITY);
		frmCadastroDeIgreja.setTitle("Cadastro de Igreja");
		frmCadastroDeIgreja.setResizable(false);
		frmCadastroDeIgreja.setBounds(100, 100, 260, 570);
		frmCadastroDeIgreja.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		descricaoPontoIgreja.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		
		JLabel labelDescricaoPontoIgreja = new JLabel("Descri\u00E7\u00E3o: *");
		labelDescricaoPontoIgreja.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoPontoIgreja = new JTextField();
		enderecoPontoIgreja.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		enderecoPontoIgreja.setColumns(10);
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o: *");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomePontoIgreja = new JTextField();
		nomePontoIgreja.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		nomePontoIgreja.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome: *");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Igreja cidade= new Igreja();
				cidade.setNome(getNomeIgreja());
				cidade.setEndereco(getEdereco());
				cidade.setDataConstrucao(getDataConstrucao());
				cidade.setEstiloConstrucao(getEstiloConstrucao());
				cidade.setDescricao(getDescricao());
					if (!ExecutaQuery.cadastra(cidade.pontoParaCadastro(), conection)) {
						mensagemErroCadastrar();
					} else {
						try {
							cidade.setCod(buscaCodigoPonto(getNomeIgreja(), getEdereco()));
							if (!ExecutaQuery.cadastra(cidade.igrejaParaCadastro(), conection)) {
								mensagemErroCadastrar();
							} else {
								mensegemSucessoCadastro();
								frmCadastroDeIgreja.dispose();
							}
						} catch (SQLException e) {
							mensagemErroCadastrar();
							e.printStackTrace();
						}
				}
			}
		});
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
		
		btnCadastrar.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
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
				frmCadastroDeIgreja.dispose();
			}
		});
		btnCancelar.setToolTipText("Cancela o cadastro de um quarto.");
		
		JLabel lblData = new JLabel("Data constru\u00E7\u00E3o (inaugura\u00E7\u00E3o): *");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		dataConstrucao = new JTextField();
		dataConstrucao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		lblData.setLabelFor(dataConstrucao);
		dataConstrucao.setColumns(10);
		
		JLabel lblEstiloDeContruo = new JLabel("Estilo de contru\u00E7\u00E3o: *");
		lblEstiloDeContruo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		estiloConstrucao = new JTextField();
		estiloConstrucao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		estiloConstrucao.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeIgreja.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(descricaoPontoIgreja, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEstiloDeContruo)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(estiloConstrucao, Alignment.LEADING)
							.addComponent(dataConstrucao, Alignment.LEADING)
							.addComponent(lblData, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(labelNome, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(nomePontoIgreja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(labelEndereco, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(enderecoPontoIgreja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
						.addComponent(labelDescricaoPontoIgreja, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(nomePontoIgreja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(labelEndereco, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(enderecoPontoIgreja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblData)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dataConstrucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEstiloDeContruo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(estiloConstrucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelDescricaoPontoIgreja, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(descricaoPontoIgreja, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroDeIgreja.getContentPane().setLayout(groupLayout);
	}

	/**
	 * @return the nomeIgreja
	 */
	private String getNomeIgreja() {
		if (nomePontoIgreja.getText().equals("")) {
			return null;
		}
		return nomePontoIgreja.getText().trim();
	}
	
	private int buscaCodigoPonto(String nome, String endereco) throws SQLException {
		StringBuilder esprecao = new StringBuilder();
		esprecao.append("SELECT codpont From pontosturisticos where nome=")
				.append('\'')
				.append(nome)
				.append('\'')
				.append(" and endereco=")
				.append('\'')
				.append(endereco)
				.append('\'');
		ResultSet rs = ExecutaQuery.busca(esprecao, conection);
		int result;
		rs.next();
		result=rs.getInt("codpont");
		rs.close();
		return result;
	}

	/**
	 * @return the enderecoPontoIgreja
	 */
	private String getEdereco() {
		if (enderecoPontoIgreja.getText().equals("")) {
			return null;
		}
		return enderecoPontoIgreja.getText().trim();
	}

	/**
	 * @return the dataConstrucao
	 */
	private String getDataConstrucao() {
		if (dataConstrucao.getText().equals("")) {
			return null;
		}
		return dataConstrucao.getText().trim();
	}

	/**
	 * @return the estiloConstrucao
	 */
	private String getEstiloConstrucao() {
		if (estiloConstrucao.getText().equals("")) {
			return null;
		}
		return estiloConstrucao.getText().trim();
	}

	/**
	 * @return the descricao
	 */
	private String getDescricao() {
		if (descricaoPontoIgreja.getText().equals("")) {
			return null;
		}
		return estiloConstrucao.getText().trim();
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

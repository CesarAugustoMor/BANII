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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JDateChooser;

import entidades.Museu;
import interacaoBanco.ExecutaQuery;

public class CadastroMuseu {

	private JDialog frmCadastroDeMuseu;
	private JTextField enderecoMuseu;
	private JTextField nomeMuseu;
	private JTextField numeroSalasMuseu;
	private JTextField numeroFundadores;
	JDateChooser dataFundacao;
	JEditorPane descricaoMuseu;
	private Connection conection;
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Launch the window.
	 */
	public static void Abrir(Connection conection, JFrame frPrincipal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMuseu window = new CadastroMuseu(conection, frPrincipal);
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
	public CadastroMuseu(Connection conection, JFrame frPrincipal) {
		this.conection=conection;
		initialize(frPrincipal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frPrincipal) {
		frmCadastroDeMuseu = new JDialog(frPrincipal);
		frmCadastroDeMuseu.setResizable(false);
		frmCadastroDeMuseu.setTitle("Cadastro de Museu");
		frmCadastroDeMuseu.setType(Type.UTILITY);
		frmCadastroDeMuseu.setBounds(100, 100, 260, 670);
		frmCadastroDeMuseu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		descricaoMuseu = new JEditorPane();
		descricaoMuseu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		
		JLabel labelDescricao = new JLabel("Descri\u00E7\u00E3o: *");
		labelDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoMuseu = new JTextField();
		enderecoMuseu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		enderecoMuseu.setColumns(10);
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o: *");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeMuseu = new JTextField();
		nomeMuseu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		nomeMuseu.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome: *");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDataDeFundao = new JLabel("Data de funda\u00E7\u00E3o: *");
		lblDataDeFundao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNmeroDeSalas = new JLabel("N\u00FAmero de Salas: *");
		lblNmeroDeSalas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		numeroSalasMuseu = new JTextField();
		numeroSalasMuseu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		lblNmeroDeSalas.setLabelFor(numeroSalasMuseu);
		numeroSalasMuseu.setColumns(10);
		
		JLabel lblNumeroDeFundadores = new JLabel("N\u00FAmero de Fundadores: *");
		lblNumeroDeFundadores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		numeroFundadores = new JTextField();
		numeroFundadores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		numeroFundadores.setColumns(10);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Museu museu= new Museu();
				museu.setNome(getNomeMuseu());
				museu.setEndereco(getEndereco());
				museu.setDescricao(getDescricao());
				museu.setDataFund(getDataFundacao());
				museu.setNumeroFundadores(getNumeroFundadores());
				museu.setNumeroSalas(getNumerosSalas());
				if (!ExecutaQuery.cadastra(museu.pontoParaCadastro(), conection)) {
					Mesnsagens.mensagemErroCadastrar();
				} else {
					try {
						museu.setCod(buscaCodigoPonto(getNomeMuseu(), getEndereco()));
						if (!ExecutaQuery.cadastra(museu.museuParaCadastro(), conection)) {
							Mesnsagens.mensagemErroCadastrar();
						} else {
							Mesnsagens.mensegemSucessoCadastro();
							frmCadastroDeMuseu.dispose();
						}
					} catch (SQLException e) {
						Mesnsagens.mensagemErroCadastrar();
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
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (e.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeMuseu.dispose();
			}
		});
		btnCancelar.setToolTipText("Cancela o cadastro de um quarto.");
		
		dataFundacao = new JDateChooser();
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeMuseu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(nomeMuseu, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(labelEndereco, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(enderecoMuseu, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(lblDataDeFundao)
							.addComponent(lblNmeroDeSalas)
							.addComponent(numeroSalasMuseu)
							.addComponent(lblNumeroDeFundadores)
							.addComponent(numeroFundadores)
							.addComponent(dataFundacao, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(labelDescricao, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addComponent(descricaoMuseu, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
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
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroDeMuseu.getContentPane().setLayout(groupLayout);
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
	 * @return the nomeMuseu
	 */
	private String getNomeMuseu() {
		if (nomeMuseu.getText().equals("")) {
			return null;
		}
		return nomeMuseu.getText().trim();
	}

	/**
	 * @return the numeroSalas
	 */
	private Integer getNumerosSalas() {
		if (numeroSalasMuseu.getText().equals("")) {
			return null;
		}
		return Integer.parseInt(numeroSalasMuseu.getText().trim());
	}

	/**
	 * @return the numeroFundadores
	 */
	private Integer getNumeroFundadores() {
		if (numeroFundadores.getText().equals("")) {
			return null;
		}
		return Integer.parseInt(numeroFundadores.getText().trim());
	}

	/**
	 * @return the enderecoMuseu
	 */
	private String getEndereco() {
		if (enderecoMuseu.getText().equals("")) {
			return null;
		}
		return enderecoMuseu.getText().trim();
	}

	/**
	 * @return the descricao
	 */
	private String getDescricao() {
		if (descricaoMuseu.getText().equals("")) {
			return null;
		}
		return descricaoMuseu.getText().trim();
	}

	/**
	 * @return the dataFundacao
	 */
	private String getDataFundacao() {
		if (dataFundacao.getDate()==null){
			return null;
		}
		DateFormat df = new SimpleDateFormat(dataFundacao.getDateFormatString());
		return df.format(dataFundacao.getDate());
	}
}

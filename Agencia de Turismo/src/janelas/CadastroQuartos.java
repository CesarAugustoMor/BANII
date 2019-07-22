package janelas;

import java.awt.Dimension;
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
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Quarto;
import interacaoBanco.ExecutaQuery;

public class CadastroQuartos {

	private JDialog frmCadastroDeQuartos;
	private JTextField valorQuarto;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Connection conection;
	private DefaultComboBoxModel<String> list;
	private HashMap<String , Integer> listaHot = new HashMap<String,Integer>();
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Launch the window.
	 */
	public static void Abrir(Connection conection, JFrame frPrincipal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroQuartos window = new CadastroQuartos(conection, frPrincipal);
					window.frmCadastroDeQuartos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroQuartos(Connection conection, JFrame frPrincipal) {
		this.conection=conection;
		initialize(frPrincipal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frPrincipal) {
		frmCadastroDeQuartos = new JDialog(frPrincipal);
		frmCadastroDeQuartos.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		frmCadastroDeQuartos.setTitle("Cadastro de Quartos em Hot\u00E9is.");
		frmCadastroDeQuartos.setType(Type.UTILITY);
		frmCadastroDeQuartos.setResizable(false);
		frmCadastroDeQuartos.setBounds(100, 100, 260, 390);
		frmCadastroDeQuartos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblHotel = new JLabel("Hotel: *");
		lblHotel.setToolTipText("* Campo de quisito obrigat\u00F3rio.");
		lblHotel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> listaHotel = new JComboBox<String>();
		listaHotel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		listaHotel.setToolTipText("Lista de Hoteis j\u00E1 cadastrados. * Campo de quisito obrigat\u00F3rio.");
		lblHotel.setLabelFor(listaHotel);
		try {
			list = new DefaultComboBoxModel<String>(buscaHoteis());
			listaHotel.setModel(list);
		} catch (SQLException e) {
			list = new DefaultComboBoxModel<String>(new String[] {null});
			listaHotel.setModel(list);
			e.printStackTrace();
		}
		
		JLabel lblValor = new JLabel("Valor: *");
		lblValor.setToolTipText("Valor em Reais (R$) do quarto a ser cadastrado.");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		valorQuarto = new JTextField();
		valorQuarto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		valorQuarto.setToolTipText("Valor em Reais (R$) do quarto a ser cadastrado.");
		lblValor.setLabelFor(valorQuarto);
		valorQuarto.setColumns(10);
		
		JLabel lblTipoDoQuarto = new JLabel("Tipo do quarto: *");
		lblTipoDoQuarto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnUmaEstrela = new JRadioButton("Uma Estrela");
		rdbtnUmaEstrela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(rdbtnUmaEstrela);
		lblTipoDoQuarto.setLabelFor(rdbtnUmaEstrela);
		rdbtnUmaEstrela.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		rdbtnUmaEstrela.setSelected(true);
		rdbtnUmaEstrela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnDuasEstrelas = new JRadioButton("Duas Estrelas");
		rdbtnDuasEstrelas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(rdbtnDuasEstrelas);
		rdbtnDuasEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		rdbtnDuasEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnTresEstrelas = new JRadioButton("Tr\u00EAs Estrelas");
		rdbtnTresEstrelas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(rdbtnTresEstrelas);
		rdbtnTresEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		rdbtnTresEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnQuatroEstrelas = new JRadioButton("Quatro Estrela");
		rdbtnQuatroEstrelas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(rdbtnQuatroEstrelas);
		rdbtnQuatroEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		rdbtnQuatroEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnCincoEstrela = new JRadioButton("Cinco Estrela");
		rdbtnCincoEstrela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(rdbtnCincoEstrela);
		rdbtnCincoEstrela.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		rdbtnCincoEstrela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemSelect = listaHotel.getItemAt(listaHotel.getSelectedIndex());
				if(!isNull(itemSelect)) {
					Quarto hotel = new Quarto();
					hotel.setCodhot(listaHot.get(itemSelect));
					if (rdbtnCincoEstrela.isSelected()) {
						hotel.setTipoQuarto("Cinco Estrelas");
					} else if (rdbtnDuasEstrelas.isSelected()) {
						hotel.setTipoQuarto("Duas Estrelas");
					} else if (rdbtnTresEstrelas.isSelected()) {
						hotel.setTipoQuarto("Tres Estrelas");
					} else if (rdbtnQuatroEstrelas.isSelected()) {
						hotel.setTipoQuarto("Quatro Estrelas");
					} else {
						hotel.setTipoQuarto("Uma Estrela");
					}
					hotel.setValor(getValorQaurto());
					if (!ExecutaQuery.cadastra(hotel.quartoParaCadastro(), conection)) {
						Mesnsagens.mensagemErroCadastrar();
					} else {
						Mesnsagens.mensegemSucessoCadastro();
						frmCadastroDeQuartos.dispose();
					}
				}else {
						Mesnsagens.mensagemErroCadastrar();
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
		
		btnCancelar.setToolTipText("Cancela o cadastro de um quarto.");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeQuartos.dispose();
			}
		});
		
		JButton novoHotel = new JButton("Novo");
		novoHotel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					novoHotel.doClick();
				}
			}
		});
		novoHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroHotel.Abrir(conection, frPrincipal);
				Mesnsagens.mensagemRealizarCadastro();
			}
		});
		novoHotel.setToolTipText("Cadastra um novo Restaurante.");
		novoHotel.setPreferredSize(new Dimension(75, 23));
		
		JButton atualizarListaHoteis = new JButton("Atualizar");
		atualizarListaHoteis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					atualizarListaHoteis.doClick();
				}
			}
		});
		atualizarListaHoteis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String novoRest = buscaHotelNovo();
					if (!isNull(novoRest)) {
						list.addElement(novoRest);
						listaHotel.setSelectedIndex(list.getSize()-1);
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		atualizarListaHoteis.setToolTipText("Atualiza a lista de Restaurantess.");
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeQuartos.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblValor)
							.addComponent(rdbtnUmaEstrela, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnDuasEstrelas, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnTresEstrelas, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnQuatroEstrelas, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnCincoEstrela, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTipoDoQuarto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblHotel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(listaHotel, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(novoHotel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(atualizarListaHoteis, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
							.addComponent(valorQuarto, Alignment.LEADING)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHotel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listaHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(novoHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(atualizarListaHoteis))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblValor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(valorQuarto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTipoDoQuarto, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(rdbtnUmaEstrela, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(rdbtnDuasEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(rdbtnTresEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(rdbtnQuatroEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(rdbtnCincoEstrela, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroDeQuartos.getContentPane().setLayout(groupLayout);
	}
	
	private String[] buscaHoteis() throws SQLException {
		StringBuilder esprecao = new StringBuilder();
		esprecao.append("SELECT codhot,nome From hoteis order by nome,codhot");
		ResultSet rs = ExecutaQuery.busca(esprecao, conection);
		ArrayList<String> hoteis = new ArrayList<String>();
		hoteis.add(null);
		while (rs.next()) {
			hoteis.add(rs.getString("nome"));
			listaHot.put(rs.getString("nome"), rs.getInt("codhot"));
		}
		rs.close();
		String[] retorno=new String[hoteis.size()];
		for (int i = 0; i < hoteis.size(); i++) {
			retorno[i]=hoteis.get(i);
		}
		return retorno;
	}
	
	private String buscaHotelNovo() throws SQLException {
		StringBuilder esprecao = new StringBuilder();
		esprecao.append("SELECT codhot,nome From hoteis order by nome,codhot");
		ResultSet rs = ExecutaQuery.busca(esprecao, conection);
		String restaurantes = null;
		while (rs.next()) {
			if (!listaHot.containsKey(rs.getString("nome"))) {
				listaHot.put(rs.getString("nome"), rs.getInt("codhot"));
				restaurantes=rs.getString("nome");
			}
		}
		rs.close();
		return restaurantes;
	}

	/**
	 * @return the valorQaurto
	 */
	private Double getValorQaurto() {
		if (valorQuarto.getText().equals("")) {
			return null;
		}
		return Double.parseDouble(valorQuarto.getText().trim());
	}

	/**
	 * @return true se o objeto em questão é null
	 */
	private boolean isNull(Object valor) {
		return valor==null;
	}
}

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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Hotel;
import interacaoBanco.ExecutaQuery;

public class CadastroHotel {

	private JDialog frmCadastroHotel;
	private JTextField nomeHotel;
	private JTextField enderecoHotel;
	private JTextField nQuartosHotel;
	private JLabel lblCategoria;
	private Connection conection;
	private DefaultComboBoxModel<String> list;
	private JComboBox<String> listaRestaurantes;
	private HashMap<String, Integer> listaRest = new HashMap<String,Integer>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection, JFrame frPrincipal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroHotel window = new CadastroHotel(conection, frPrincipal);
					window.frmCadastroHotel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroHotel(Connection conection, JFrame frPrincipal) {
		this.conection=conection;
		initialize(frPrincipal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frPrincipal) {
		frmCadastroHotel = new JDialog(frPrincipal);
		frmCadastroHotel.setType(Type.UTILITY);
		frmCadastroHotel.setResizable(false);
		frmCadastroHotel.setTitle("Cadastro de Hotel");
		frmCadastroHotel.setBounds(100, 100, 260, 480);
		frmCadastroHotel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setToolTipText("Nome do Hotel a ser cadastrado!. Este campo \u00E9 de quesito Obrigat\u00F3rio.");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeHotel = new JTextField();
		nomeHotel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		nomeHotel.setToolTipText("Nome do Hotel a ser cadastrado!. Este campo \u00E9 de quesito Obrigat\u00F3rio.");
		lblNome.setLabelFor(nomeHotel);
		nomeHotel.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o: *");
		lblEndereo.setToolTipText("Endere\u00E7o do hotel em quest\u00E3o. Campo de crit\u00E9rio obrigat\u00F3rio.");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoHotel = new JTextField();
		enderecoHotel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		lblEndereo.setLabelFor(enderecoHotel);
		enderecoHotel.setToolTipText("Endere\u00E7o do hotel em quest\u00E3o. Campo de crit\u00E9rio obrigat\u00F3rio.");
		enderecoHotel.setColumns(10);
		
		JLabel lblQuartosHotel = new JLabel("N\u00FAmero de quartos: *");
		lblQuartosHotel.setToolTipText("N\u00FAmero de quartos no hotel em quest\u00E3o. Campo de  quesito Obrigat\u00F3rio.");
		lblQuartosHotel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nQuartosHotel = new JTextField();
		nQuartosHotel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		nQuartosHotel.setToolTipText("N\u00FAmero de quartos no hotel em quest\u00E3o. Campo de  quesito Obrigat\u00F3rio.");
		lblQuartosHotel.setLabelFor(nQuartosHotel);
		nQuartosHotel.setColumns(10);
		
		lblCategoria = new JLabel("Categoria: *");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
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
		rdbtnUmaEstrela.setSelected(true);
		rdbtnUmaEstrela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnUmaEstrela);
		rdbtnUmaEstrela.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
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
		rdbtnDuasEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnDuasEstrelas);
		rdbtnDuasEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
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
		rdbtnTresEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnTresEstrelas);
		rdbtnTresEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
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
		rdbtnQuatroEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnQuatroEstrelas);
		rdbtnQuatroEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
		JRadioButton rdbtnCincoEstrelas = new JRadioButton("Cinco Estrela");
		rdbtnCincoEstrelas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		rdbtnCincoEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnCincoEstrelas);
		rdbtnCincoEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroHotel.dispose();
			}
		});
		
		JLabel lblRestaurante = new JLabel("Restaurante:");
		lblRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		listaRestaurantes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				}
			}
		});
		try {
			list = new DefaultComboBoxModel<String>(buscaRestaurantes());
			listaRestaurantes.setModel(list);
		} catch (SQLException e1) {
			list = new DefaultComboBoxModel<String>(new String[] {null});
			listaRestaurantes.setModel(list);
			e1.printStackTrace();
		}
		try {
			final DefaultComboBoxModel<String> list = new DefaultComboBoxModel<String>(buscaRestaurantes());
			listaRestaurantes.setModel(list);
		} catch (SQLException e1) {
			final DefaultComboBoxModel<String> list = new DefaultComboBoxModel<String>(new String[] {null});
			listaRestaurantes.setModel(list);
			e1.printStackTrace();
		}
		lblRestaurante.setLabelFor(listaRestaurantes);
		listaRestaurantes.setSelectedIndex(0);
		
		JButton btnAtualizarListaRest = new JButton("Atualizar");
		btnAtualizarListaRest.setToolTipText("Atualiza a lista de Restaurantess.");
		btnAtualizarListaRest.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnAtualizarListaRest.doClick();
				}
			}
		});
		btnAtualizarListaRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String novoRest = buscaRestauranteNovo();
					if (!isNull(novoRest)) {
						list.addElement(novoRest);
						listaRestaurantes.setSelectedIndex(list.getSize()-1);
					}else
						System.out.println("a busca não retornou resultados");
				} catch (SQLException ex) {
					System.out.println("depois de tenatr adicionar novo Rest e falhar na busca do novo restaurante.");
					ex.printStackTrace();
				}
			}
		});
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setToolTipText("Cadastra um novo Restaurante.");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroRestaurante.Abrir(conection, frPrincipal);
				mensagemRealizarCadastro();
			}
		});
		btnNovo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnNovo.doClick();
				}
			}
		});
		btnNovo.setPreferredSize(new Dimension(75, 23));
		GroupLayout groupLayout = new GroupLayout(frmCadastroHotel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnCincoEstrelas)
						.addComponent(rdbtnQuatroEstrelas)
						.addComponent(rdbtnUmaEstrela)
						.addComponent(lblCategoria)
						.addComponent(rdbtnTresEstrelas)
						.addComponent(rdbtnDuasEstrelas)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblRestaurante)
						.addComponent(lblNome)
						.addComponent(lblEndereo)
						.addComponent(lblQuartosHotel)
						.addComponent(nomeHotel, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtualizarListaRest, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addComponent(listaRestaurantes, 0, 234, Short.MAX_VALUE)
						.addComponent(enderecoHotel, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(nQuartosHotel, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
					.addContainerGap())
		);
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
				String itemSelect = listaRestaurantes.getItemAt(listaRestaurantes.getSelectedIndex());
				if(!isNull(itemSelect)) {
					Hotel hotel = new Hotel();
					hotel.setNome(getNomeHotel());
					if (rdbtnCincoEstrelas.isSelected()) {
						hotel.setCategoria(5);
					} else if (rdbtnDuasEstrelas.isSelected()) {
						hotel.setCategoria(2);
					} else if (rdbtnTresEstrelas.isSelected()) {
						hotel.setCategoria(3);
					} else if (rdbtnQuatroEstrelas.isSelected()) {
						hotel.setCategoria(4);
					} else {
						hotel.setCategoria(1);
					}
					hotel.setEndereco(getEndereco());
					hotel.setNumeroquartos(getNQuartos());
					hotel.setRest(listaRest.get(itemSelect));
					if (!ExecutaQuery.cadastra(hotel.hotelParaCadastro(), conection)) {
							mensagemErroCadastrar();
						} else {
							mensegemSucessoCadastro();
							frmCadastroHotel.dispose();
						}
				}else {
					Hotel hotel =new Hotel();
					hotel.setNome(getNomeHotel());
					if (rdbtnCincoEstrelas.isSelected()) {
						hotel.setCategoria(5);
					} else if (rdbtnDuasEstrelas.isSelected()) {
						hotel.setCategoria(2);
					} else if (rdbtnTresEstrelas.isSelected()) {
						hotel.setCategoria(3);
					} else if (rdbtnQuatroEstrelas.isSelected()) {
						hotel.setCategoria(4);
					} else {
						hotel.setCategoria(1);
					}
					hotel.setEndereco(getEndereco());
					hotel.setNumeroquartos(getNQuartos());
				}
			}
		});
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nomeHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEndereo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(enderecoHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblQuartosHotel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nQuartosHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblRestaurante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listaRestaurantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAtualizarListaRest))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCategoria)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnUmaEstrela)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnDuasEstrelas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnTresEstrelas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnQuatroEstrelas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnCincoEstrelas)
					.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroHotel.getContentPane().setLayout(groupLayout);
	}
	
	private String buscaRestauranteNovo() throws SQLException {
		StringBuilder esprecao = new StringBuilder();
		esprecao.append("SELECT codrest,nome From restaurantes order by nome,codrest");
		ResultSet rs = ExecutaQuery.busca(esprecao, conection);
		String restaurantes = null;
		while (rs.next()) {
			if (!listaRest.containsKey(rs.getString("nome"))) {
				listaRest.put(rs.getString("nome"), rs.getInt("codrest"));
				System.out.println("Novo Restaurante: "+rs.getString("nome"));
				restaurantes=rs.getString("nome");
			}
		}
		rs.close();
		return restaurantes;
	}

	/**
	 * Mostra mensagem que seja selecionado o restaurante recem cadastrado
	 */
	private void mensagemRealizarCadastro() {
		JOptionPane.showMessageDialog(null, "Favor repita o processo selecionando o novo restaurante cadastrado.", "Informação", 1);
	}

	/**
	 * @return A lista com o nome dos restaurantes já cadastrados
	 */
	private String[] buscaRestaurantes() throws SQLException {
		StringBuilder esprecao = new StringBuilder();
		esprecao.append("SELECT codrest,nome From restaurantes order by nome,codrest");
		ResultSet rs = ExecutaQuery.busca(esprecao, conection);
		ArrayList<String> restaurantes = new ArrayList<String>();
		restaurantes.add(null);
		while (rs.next()) {
			restaurantes.add(rs.getString("nome"));
			listaRest.put(rs.getString("nome"), rs.getInt("codrest"));
		}
		restaurantes.add("Novo Restaurante");
		rs.close();
		String[] retorno=new String[restaurantes.size()];
		for (int i = 0; i < restaurantes.size(); i++) {
			retorno[i]=restaurantes.get(i);
		}
		return retorno;
	}

	/**
	 * @return the nomeHotel
	 */
	private String getNomeHotel() {
		if (nomeHotel.getText().equals("")) {
			return null;
		}
		return nomeHotel.getText().trim();
	}

	/**
	 * @return the nQuartos
	 */
	private Integer getNQuartos() {
		if (nQuartosHotel.getText().equals("")) {
			return null;
		}
		return Integer.parseInt(nQuartosHotel.getText().trim());
	}

	/**
	 * @return the enderecoHotel
	 */
	private String getEndereco() {
		if (enderecoHotel.getText().equals("")) {
			return null;
		}
		return enderecoHotel.getText().trim();
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

	/**
	 * @return true se o objeto em questão é null
	 */
	private boolean isNull(Object valor) {
		return valor==null;
	}
}

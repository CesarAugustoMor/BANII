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
import java.util.Date;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.CasaShow;
import interacaoBanco.ExecutaQuery;
import lu.tudor.santec.jtimechooser.JTimeChooser;

public class CadastroCasaShow {

	private JDialog frmCadastroDeCasas;
	private JTextField enderecoCasaShow;
	private JTextField nomeCasaShow;
	private JTextField precoMedioPratos;
	private JTextField especialidadeRestaurante;
	private JTimeChooser horaInicio;
	private Connection conection;
	private DefaultComboBoxModel<String> list;
	private JComboBox<String> diaFechamento;
	private JComboBox<String> listaRestaurantes;
	private HashMap<String , Integer> listaRest = new HashMap<String,Integer>();
	private JButton btnCancelar = new JButton("Cancelar");
	private	JButton btnCadastrar = new JButton("Cadastrar");

	/**
	 * Launch the window.
	 */
	public static void Abrir(Connection conection, JFrame frPrincipal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCasaShow window = new CadastroCasaShow(conection, frPrincipal);
					window.frmCadastroDeCasas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroCasaShow(Connection conection, JFrame frPrincipal) {
		this.conection=conection;
		initialize(frPrincipal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frPrincipal) {
		frmCadastroDeCasas = new JDialog(frPrincipal);
		frmCadastroDeCasas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (e.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		frmCadastroDeCasas.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		frmCadastroDeCasas.setResizable(false);
		frmCadastroDeCasas.setType(Type.UTILITY);
		frmCadastroDeCasas.setTitle("Cadastro de Casas de Shows");
		frmCadastroDeCasas.setBounds(100, 100, 256, 820);
		frmCadastroDeCasas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JEditorPane descricaoCasaShow = new JEditorPane();
		descricaoCasaShow.setToolTipText("Detalhes da Casa de Show. *Campo de quesito obrigat\u00F3rio.");
		descricaoCasaShow.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		
		JLabel labelDescricaoCasa = new JLabel("Descri\u00E7\u00E3o: *");
		labelDescricaoCasa.setToolTipText("Detalhes da Casa de Show. *Campo de quesito obrigat\u00F3rio.");
		labelDescricaoCasa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoCasaShow = new JTextField();
		enderecoCasaShow.setToolTipText("Endere\u00E7o cuja o qual a casa de show est\u00E1 localizada. *Campo de quesito obrigat\u00F3rio.");
		enderecoCasaShow.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		enderecoCasaShow.setColumns(10);
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o: *");
		labelEndereco.setToolTipText("Endere\u00E7o cuja o qual a casa de show est\u00E1 localizada. *Campo de quesito obrigat\u00F3rio.");
		labelEndereco.setLabelFor(enderecoCasaShow);
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeCasaShow = new JTextField();
		nomeCasaShow.setToolTipText("Nome do restaurante. *Campo de quesito obrigat\u00F3rio.");
		nomeCasaShow.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		nomeCasaShow.setColumns(10);
		
		JLabel labelNomeCasa = new JLabel("Nome: *");
		labelNomeCasa.setToolTipText("Nome do restaurante. *Campo de quesito obrigat\u00F3rio.");
		labelNomeCasa.setLabelFor(nomeCasaShow);
		labelNomeCasa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeCasas.dispose();
			}
		});
		btnCancelar.setToolTipText("Cancela o cadastro de um quarto.");
		
		JLabel lblHorarioDeInicio = new JLabel("Hor\u00E1rio de in\u00EDcio: *");
		lblHorarioDeInicio.setToolTipText("Horario de Inicio de atendimento da Casa de Show, no formato hh:mm. *Campo de quesito obrigat\u00F3rio.");
		lblHorarioDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		horaInicio = new JTimeChooser(new Date());
		horaInicio.setShowIcon(true);
		horaInicio.setShowSeconds(false);
		
		JLabel lblDiaDeFechamento = new JLabel("Dia de Fechamento: *");
		lblDiaDeFechamento.setToolTipText("Dia da semana em que a casa de Show n\u00E3o trabalha. *Campo de quesito obrigat\u00F3rio.");
		lblDiaDeFechamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblRestaurante = new JLabel("Restaurante:");
		lblRestaurante.setToolTipText("Lista de restaurantes cadastrados no banco de dados.");
		lblRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		listaRestaurantes = new JComboBox<String>();
		listaRestaurantes.setToolTipText("Lista de restaurantes cadastrados no banco de dados.");
		listaRestaurantes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				}
			}
		});
		lblRestaurante.setLabelFor(listaRestaurantes);
		try {
			list = new DefaultComboBoxModel<String>(buscaRestaurantes());
			listaRestaurantes.setModel(list);
		} catch (SQLException e1) {
			list = new DefaultComboBoxModel<String>(new String[] {null});
			listaRestaurantes.setModel(list);
			e1.printStackTrace();
		}

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String itemSelect = (String) listaRestaurantes.getSelectedItem();
				if(!isNull(itemSelect)) {
					CasaShow casa =new CasaShow();
					casa.setNome(getNomeCasa());
					casa.setDescricao(getDescricao(descricaoCasaShow));
					casa.setDiaFechado(getDiaFechado());
					casa.setEndereco(getEndereco());
					casa.setEspecialidade(getEspecialidadeRest());
					casa.setHoraInicio(getHoario());
					casa.setPrecoMedio(getprecoMedioPrato());
					casa.setCodRest(listaRest.get(itemSelect));
					if (!ExecutaQuery.cadastra(casa.pontoParaCadastro(), conection)) {
						Mesnsagens.mensagemErroCadastrar();
					} else {
						try {
							casa.setCod(buscaCodigoPonto(getNomeCasa(), getEndereco()));
							if (!ExecutaQuery.cadastra(casa.casaShowParaCadastro(), conection)) {
								Mesnsagens.mensagemErroCadastrar();
							} else {
								Mesnsagens.mensegemSucessoCadastro();
								frmCadastroDeCasas.dispose();
							}
						} catch (SQLException e) {
							Mesnsagens.mensagemErroCadastrar();
							e.printStackTrace();
						}
					}
				}else {
					CasaShow casa =new CasaShow();
					casa.setNome(getNomeCasa());
					casa.setDescricao(getDescricao(descricaoCasaShow));
					casa.setDiaFechado(getDiaFechado());
					casa.setEndereco(getEndereco());
					casa.setEspecialidade(getEspecialidadeRest());
					casa.setHoraInicio(getHoario());
					casa.setPrecoMedio(getprecoMedioPrato());
					//casa.setCodRest(codrest.get(indexSelect));
					if (!ExecutaQuery.cadastra(casa.pontoParaCadastro(), conection)) {
						Mesnsagens.mensagemErroCadastrar();
					} else {
						try {
							casa.setCod(buscaCodigoPonto(getNomeCasa(), getEndereco()));
							if (!ExecutaQuery.cadastra(casa.casaShowParaCadastro(), conection)) {
								Mesnsagens.mensagemErroCadastrar();
							} else {
								Mesnsagens.mensegemSucessoCadastro();
								frmCadastroDeCasas.dispose();
							}
						} catch (SQLException e) {
							Mesnsagens.mensagemErroCadastrar();
							e.printStackTrace();
						}
					}
				}
			}
		});
		btnCadastrar.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
		JLabel lblPreoMdioDos = new JLabel("Pre\u00E7o m\u00E9dio dos pratos:");
		lblPreoMdioDos.setToolTipText("Campo de quesito obrigat\u00F3rio, somente se possuir um restaurante for selecionado.");
		lblPreoMdioDos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		precoMedioPratos = new JTextField();
		precoMedioPratos.setToolTipText("Campo de quesito obrigat\u00F3rio, somente se possuir um restaurante for selecionado.");
		precoMedioPratos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		lblPreoMdioDos.setLabelFor(precoMedioPratos);
		precoMedioPratos.setColumns(10);
		
		JLabel lblEspecialidadeDoRestaurante = new JLabel("Especialidade do restaurante:");
		lblEspecialidadeDoRestaurante.setToolTipText("Campo de quesito obrigat\u00F3rio, somente se possuir um restaurante for selecionado.");
		lblEspecialidadeDoRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		especialidadeRestaurante = new JTextField();
		especialidadeRestaurante.setToolTipText("Campo de quesito obrigat\u00F3rio, somente se possuir um restaurante for selecionado.");
		especialidadeRestaurante.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		especialidadeRestaurante.setColumns(10);
		
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
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setToolTipText("Cadastra um novo Restaurante.");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroRestaurante.Abrir(conection, frPrincipal);
				Mesnsagens.mensagemRealizarCadastro();
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
		
		diaFechamento = new JComboBox<String>();
		diaFechamento.setModel(new DefaultComboBoxModel<String>(new String[] {"Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado", "Domingo", "N\u00E3o Fechamos"}));
		diaFechamento.setSelectedIndex(0);
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeCasas.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(labelNomeCasa, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomeCasaShow, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHorarioDeInicio)
							.addContainerGap(130, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(labelEndereco, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(enderecoCasaShow, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
								.addContainerGap()))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(horaInicio, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDiaDeFechamento)
									.addPreferredGap(ComponentPlacement.RELATED, 95, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(listaRestaurantes, 0, 222, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnAtualizarListaRest, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
									.addComponent(diaFechamento, 0, 222, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblPreoMdioDos)
											.addPreferredGap(ComponentPlacement.RELATED, 79, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblEspecialidadeDoRestaurante)
											.addPreferredGap(ComponentPlacement.RELATED, 49, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(labelDescricaoCasa, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 147, GroupLayout.PREFERRED_SIZE))
										.addComponent(descricaoCasaShow, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
										.addComponent(precoMedioPratos, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
										.addComponent(especialidadeRestaurante, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRestaurante)
									.addPreferredGap(ComponentPlacement.RELATED, 148, GroupLayout.PREFERRED_SIZE)))
							.addGap(18))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNomeCasa, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(nomeCasaShow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(labelEndereco, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(enderecoCasaShow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblHorarioDeInicio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDiaDeFechamento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(diaFechamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblRestaurante)
					.addGap(9)
					.addComponent(listaRestaurantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAtualizarListaRest))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPreoMdioDos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(precoMedioPratos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEspecialidadeDoRestaurante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(especialidadeRestaurante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelDescricaoCasa, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(descricaoCasaShow, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroDeCasas.getContentPane().setLayout(groupLayout);
	}
	
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
		rs.close();
		String[] retorno=new String[restaurantes.size()];
		for (int i = 0; i < restaurantes.size(); i++) {
			retorno[i]=restaurantes.get(i);
		}
		return retorno;
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
	 * @return the nomeCasaShow
	 */
	private String getNomeCasa() {
		if (nomeCasaShow.getText().equals("")) {
			return null;
		}
		return nomeCasaShow.getText().trim();
	}
	/**
	 * @return the horarioInicio
	 */
	private String getHoario() {
		if (horaInicio.getFormatedTime().equals("")) {
			return null;
		}
		return horaInicio.getFormatedTime().trim();
	}
	/**
	 * @return the nomeCasaShow
	 */
	private String getDiaFechado() {
		return (String) diaFechamento.getSelectedItem();
	}
	/**
	 * @return the nomeCasaShow
	 */
	private String getEspecialidadeRest() {
		if (especialidadeRestaurante.getText().equals("")) {
			return null;
		}
		return especialidadeRestaurante.getText().trim();
	}
	/**
	 * @return the nomeCasaShow
	 */
	private String getEndereco() {
		if (enderecoCasaShow.getText().equals("")) {
			return null;
		}
		return enderecoCasaShow.getText().trim();
	}
	/**
	 * @return the nomeCasaShow
	 */
	private String getDescricao(JEditorPane descricaoCasaShow) {
		if (descricaoCasaShow.getText().equals("")) {
			return null;
		}
		return descricaoCasaShow.getText().trim();
	}
	/**
	 * @return the precoMedioPrato
	 */
	private Integer getprecoMedioPrato() {
		if (precoMedioPratos.getText().equals("")) {
			return null;
		}
		return Integer.parseInt(precoMedioPratos.getText().trim());
	}

	/**
	 * @return true se o objeto em questão é null
	 */
	private boolean isNull(Object valor) {
		return valor==null;
	}
}

package janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.CasaShow;
import interacaoBanco.ExecutaQuery;

public class CadastroCasaShow {

	private JFrame frmCadastroDeCasas;
	private JTextField enderecoCasaShow;
	private JTextField nomeCasaShow;
	private JTextField horarioInicio;
	private JTextField diaFechamentoCasa;
	private JTextField precoMedioPratos;
	private JTextField especialidadeRestaurante;
	private Connection conection;
	private ArrayList<Integer> codrest;

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCasaShow window = new CadastroCasaShow(conection);
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
	public CadastroCasaShow(Connection conection) {
		this.conection=conection;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeCasas = new JFrame();
		frmCadastroDeCasas.setResizable(false);
		frmCadastroDeCasas.setType(Type.UTILITY);
		frmCadastroDeCasas.setTitle("Cadastro de Casas de Shows");
		frmCadastroDeCasas.setBounds(100, 100, 260, 770);
		frmCadastroDeCasas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JEditorPane descricaoCasaShow = new JEditorPane();
		
		JLabel labelDescricaoCasa = new JLabel("Descri\u00E7\u00E3o: *");
		labelDescricaoCasa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoCasaShow = new JTextField();
		enderecoCasaShow.setColumns(10);
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o: *");
		labelEndereco.setLabelFor(enderecoCasaShow);
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeCasaShow = new JTextField();
		nomeCasaShow.setColumns(10);
		
		JLabel labelNomeCasa = new JLabel("Nome: *");
		labelNomeCasa.setLabelFor(nomeCasaShow);
		labelNomeCasa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeCasas.dispose();
			}
		});
		cancelar.setToolTipText("Cancela o cadastro de um quarto.");
		
		JLabel lblHorarioDeInicio = new JLabel("Hor\u00E1rio de in\u00EDcio: *");
		lblHorarioDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		horarioInicio = new JTextField();
		lblHorarioDeInicio.setLabelFor(horarioInicio);
		horarioInicio.setColumns(10);
		
		JLabel lblDiaDeFechamento = new JLabel("Dia de Fechamento: *");
		lblDiaDeFechamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		diaFechamentoCasa = new JTextField();
		lblDiaDeFechamento.setLabelFor(diaFechamentoCasa);
		diaFechamentoCasa.setColumns(10);
		
		JLabel lblRestaurante = new JLabel("Restaurante:");
		lblRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//j
		JComboBox<String> listaRestaurantes = new JComboBox<String>();
		lblRestaurante.setLabelFor(listaRestaurantes);
		try {
			final DefaultComboBoxModel<String> list = new DefaultComboBoxModel<String>(buscaRestaurantes());
			listaRestaurantes.setModel(list);
		} catch (SQLException e1) {
			final DefaultComboBoxModel<String> list = new DefaultComboBoxModel<String>(new String[] {null, "Novo Restaurante"});
			listaRestaurantes.setModel(list);
			e1.printStackTrace();
		}

		JButton cadastro = new JButton("Cadastrar");
		cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indexSelect = listaRestaurantes.getSelectedIndex();
				String itemSelect = (String) listaRestaurantes.getSelectedItem();
				if(!isNull(itemSelect)) {
				if (itemSelect.equals("Novo Restaurante")) {
					CadastroRestaurante.Abrir(conection);
					try {
						DefaultComboBoxModel<String> list = new DefaultComboBoxModel<String>(buscaRestaurantes());
						listaRestaurantes.setModel(list);
					} catch (SQLException e) {
						System.out.println("depois de tenatr adicionar novo Rest e falhar.");
						e.printStackTrace();
					}
					mensagemRealizarCadastro();
				} else {
					CasaShow casa =new CasaShow();
					casa.setNome(getNomeCasa());
					casa.setDescricao(getDescricao(descricaoCasaShow));
					casa.setDiaFechado(getDiaFechado());
					casa.setEndereco(getEndereco());
					casa.setEspecialidade(getEspecialidadeRest());
					casa.setHoraInicio(getHoario());
					casa.setPrecoMedio(getprecoMedioPrato());
					casa.setCodRest(codrest.get(indexSelect));
					if (!ExecutaQuery.cadastra(casa.pontoParaCadastro(), conection)) {
						mensagemErroCadastrar();
					} else {
						try {
							casa.setCod(buscaCodigoPonto(getNomeCasa(), getEndereco()));
							if (!ExecutaQuery.cadastra(casa.casaShowParaCadastro(), conection)) {
								mensagemErroCadastrar();
							} else {
								mensegemSucessoCadastro();
								frmCadastroDeCasas.dispose();
							}
						} catch (SQLException e) {
							mensagemErroCadastrar();
							e.printStackTrace();
						}
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
						mensagemErroCadastrar();
					} else {
						try {
							casa.setCod(buscaCodigoPonto(getNomeCasa(), getEndereco()));
							if (!ExecutaQuery.cadastra(casa.casaShowParaCadastro(), conection)) {
								mensagemErroCadastrar();
							} else {
								mensegemSucessoCadastro();
								frmCadastroDeCasas.dispose();
							}
						} catch (SQLException e) {
							mensagemErroCadastrar();
							e.printStackTrace();
						}
					}
				}
			}
		});
		cadastro.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
		JLabel lblPreoMdioDos = new JLabel("Pre\u00E7o m\u00E9dio dos pratos:");
		lblPreoMdioDos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		precoMedioPratos = new JTextField();
		lblPreoMdioDos.setLabelFor(precoMedioPratos);
		precoMedioPratos.setColumns(10);
		
		JLabel lblEspecialidadeDoRestaurante = new JLabel("Especialidade do restaurante:");
		lblEspecialidadeDoRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		especialidadeRestaurante = new JTextField();
		especialidadeRestaurante.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeCasas.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(labelNomeCasa, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomeCasaShow, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelEndereco, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cadastro, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
							.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHorarioDeInicio)
							.addContainerGap(246, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDiaDeFechamento)
							.addContainerGap(246, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRestaurante)
							.addContainerGap(246, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPreoMdioDos)
							.addContainerGap(246, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEspecialidadeDoRestaurante)
							.addContainerGap(246, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(especialidadeRestaurante, Alignment.LEADING)
							.addComponent(precoMedioPratos, Alignment.LEADING)
							.addComponent(listaRestaurantes, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(diaFechamentoCasa, Alignment.LEADING)
							.addComponent(horarioInicio, Alignment.LEADING)
							.addComponent(enderecoCasaShow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelDescricaoCasa, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(descricaoCasaShow, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(69, Short.MAX_VALUE))))
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
					.addGap(6)
					.addComponent(enderecoCasaShow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblHorarioDeInicio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horarioInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDiaDeFechamento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(diaFechamentoCasa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblRestaurante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listaRestaurantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPreoMdioDos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(precoMedioPratos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEspecialidadeDoRestaurante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(especialidadeRestaurante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelDescricaoCasa, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(descricaoCasaShow, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadastro)
						.addComponent(cancelar))
					.addContainerGap())
		);
		frmCadastroDeCasas.getContentPane().setLayout(groupLayout);
	}
	private String[] buscaRestaurantes() throws SQLException {
		StringBuilder esprecao = new StringBuilder();
		esprecao.append("SELECT codrest,nome From restaurantes order by nome,codrest");
		ResultSet rs = ExecutaQuery.busca(esprecao, conection);
		ArrayList<String> restaurantes = new ArrayList<String>();
		ArrayList<Integer> codres = new ArrayList<Integer>();
		codres.add(null);
		restaurantes.add(null);
		while (rs.next()) {
			restaurantes.add(rs.getString("nome"));
			codres.add(rs.getInt("codrest"));
		}
		restaurantes.add("Novo Restaurante");
		rs.close();
		this.codrest=codres;
		String[] retorno=new String[restaurantes.size()];
		for (int i = 0; i < restaurantes.size(); i++) {
			retorno[i]=restaurantes.get(i);
		}
		return retorno;
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
	 * Mostra mensagem  solicitando que seja realizado a conecção com o banco
	 */
	private void mensagemRealizarCadastro() {
		JOptionPane.showMessageDialog(null, "Favor repita o processo selecionando o novo restaurante cadastrado.", "Informação", 1);
	}
	/**
	 * @return the nomeCasaShow
	 */
	private String getNomeCasa() {
		return nomeCasaShow.getText().trim();
	}
	/**
	 * @return the horarioInicio
	 */
	private String getHoario() {
		return horarioInicio.getText().trim();
	}
	/**
	 * @return the nomeCasaShow
	 */
	private String getDiaFechado() {
		return diaFechamentoCasa.getText().trim();
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
		return enderecoCasaShow.getText().trim();
	}
	/**
	 * @return the nomeCasaShow
	 */
	private String getDescricao(JEditorPane descricaoCasaShow) {
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
	 * Mostra mensagem solicitando que seja revisado os dados inseridos
	 */
	private void mensagemErroCadastrar() {
		JOptionPane.showMessageDialog(null, "Erro ao cadastrar a Casa de Show. Revise os dados inseridos.", "Erro", 0);
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

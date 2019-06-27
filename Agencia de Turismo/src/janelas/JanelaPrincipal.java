package janelas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.awt.Frame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import interacaoBanco.ConectaBanco;

import javax.swing.JButton;

public class JanelaPrincipal {

	private JFrame frmAgenciaDeTurismo;
	private JTextField enderecoServidor;
	private JTextField portaServidor;
	private JTextField senhaServidor;
	private Connection conection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.frmAgenciaDeTurismo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgenciaDeTurismo = new JFrame();
		frmAgenciaDeTurismo.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmAgenciaDeTurismo.setLocale(new Locale("pt", "BR"));
		frmAgenciaDeTurismo.setTitle("Agencia de Turismo");
		frmAgenciaDeTurismo.setBounds(100, 100, 600, 540);
		frmAgenciaDeTurismo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAgenciaDeTurismo.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem CadastroCicadades = new JMenuItem("Cidades");
		CadastroCicadades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				}else
				CadastroCidade.Abrir(conection);
			}
		});
		mnCadastros.add(CadastroCicadades);
		
		JMenuItem CadastroClientes = new JMenuItem("Clientes");
		CadastroClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				} else
					CadastroCliente.Abrir(conection);
			}
		});
		mnCadastros.add(CadastroClientes);
		
		JMenu CadastroHoteis = new JMenu("Hoteis");
		mnCadastros.add(CadastroHoteis);
		
		JMenuItem CadastroNovoHotel = new JMenuItem("Novo");
		CadastroNovoHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				}else
				CadastroHotel.Abrir(conection);
			}
		});
		CadastroHoteis.add(CadastroNovoHotel);
		
		JMenuItem CadastroQuartosHotel = new JMenuItem("Quartos");
		CadastroQuartosHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				}else
				CadastroQuartos.Abrir(conection);
			}
		});
		CadastroHoteis.add(CadastroQuartosHotel);
		
		JMenuItem CadastroRestaurantes = new JMenuItem("Restaurantes");
		CadastroRestaurantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				}else
				CadastroRestaurante.Abrir(conection);
			}
		});
		mnCadastros.add(CadastroRestaurantes);
		
		JMenuItem CadastroPacotes = new JMenuItem("Pacotes/Roteiros");
		CadastroPacotes.setEnabled(false);
		mnCadastros.add(CadastroPacotes);
		
		JMenu CadastroPontosTuristicos = new JMenu("Pontos Turisticos");
		mnCadastros.add(CadastroPontosTuristicos);
		
		JMenuItem CadastroCasasDeShow = new JMenuItem("Casas de Show");
		CadastroCasasDeShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				}else
				CadastroCasaShow.Abrir(conection);
			}
		});
		CadastroPontosTuristicos.add(CadastroCasasDeShow);
		
		JMenuItem CadastroIgrejas = new JMenuItem("Igrejas");
		CadastroIgrejas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				}else
				CadastroIgreja.Abrir(conection);
			}
		});
		CadastroPontosTuristicos.add(CadastroIgrejas);
		
		JMenu CadastroMuseus = new JMenu("Museus");
		CadastroPontosTuristicos.add(CadastroMuseus);
		
		JMenuItem CadastroNovoMuseu = new JMenuItem("Novo");
		CadastroNovoMuseu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				}else
				CadastroMuseu.Abrir(conection);
			}
		});
		CadastroMuseus.add(CadastroNovoMuseu);
		
		JMenuItem CadastroFundadores = new JMenuItem("Fundadores");
		CadastroFundadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				}else
				CadastroFundador.Abrir(conection);
			}
		});
		CadastroMuseus.add(CadastroFundadores);
		
		JMenuItem mntmOutros = new JMenuItem("Outros");
		mntmOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conectionIsNull()) {
					mensagemConectarBanco();
				}else
				CadastroPontoTuristico.Abrir(conection);
			}
		});
		CadastroPontosTuristicos.add(mntmOutros);
		
		JMenuItem CadastroVenda = new JMenuItem("Venda");
		CadastroVenda.setEnabled(false);
		mnCadastros.add(CadastroVenda);
		
		JMenu mnBuscas = new JMenu("Buscas/Altera\u00E7\u00F5es");
		menuBar.add(mnBuscas);
		
		JMenuItem BusacaCidades = new JMenuItem("Cidades");
		BusacaCidades.setEnabled(false);
		mnBuscas.add(BusacaCidades);
		
		JMenuItem BusacaClientes = new JMenuItem("Clientes");
		BusacaClientes.setEnabled(false);
		mnBuscas.add(BusacaClientes);
		
		JMenu BusacaHoteis = new JMenu("Hoteis");
		mnBuscas.add(BusacaHoteis);
		
		JMenuItem BusacaHotelBusaca = new JMenuItem("Buscar");
		BusacaHotelBusaca.setEnabled(false);
		BusacaHoteis.add(BusacaHotelBusaca);
		
		JMenuItem BusacaQuartos = new JMenuItem("Quartos");
		BusacaQuartos.setEnabled(false);
		BusacaHoteis.add(BusacaQuartos);
		
		JMenuItem BusacaResturantes = new JMenuItem("Restaurantes");
		BusacaResturantes.setEnabled(false);
		mnBuscas.add(BusacaResturantes);
		
		JMenuItem BusacaPacotes = new JMenuItem("Pacotes/Roteiros");
		BusacaPacotes.setEnabled(false);
		mnBuscas.add(BusacaPacotes);
		
		JMenu BusacaPontosTuristicos = new JMenu("Pontos Turisticos");
		mnBuscas.add(BusacaPontosTuristicos);
		
		JMenuItem BusacaCasasShow = new JMenuItem("Casas de Show");
		BusacaCasasShow.setEnabled(false);
		BusacaPontosTuristicos.add(BusacaCasasShow);
		
		JMenuItem BusacaIgrejas = new JMenuItem("Igrejas");
		BusacaIgrejas.setEnabled(false);
		BusacaPontosTuristicos.add(BusacaIgrejas);
		
		JMenu BusacaMuseus = new JMenu("Museus");
		BusacaPontosTuristicos.add(BusacaMuseus);
		
		JMenuItem BusacaMuseuBusca = new JMenuItem("Buscar");
		BusacaMuseuBusca.setEnabled(false);
		BusacaMuseus.add(BusacaMuseuBusca);
		
		JMenuItem BusacaFundadores = new JMenuItem("Fundadores");
		BusacaFundadores.setEnabled(false);
		BusacaMuseus.add(BusacaFundadores);
		
		JMenuItem mntmOutros_1 = new JMenuItem("Outros");
		mntmOutros_1.setEnabled(false);
		BusacaPontosTuristicos.add(mntmOutros_1);
		
		JMenuItem BusacaVenda = new JMenuItem("Venda");
		BusacaVenda.setEnabled(false);
		mnBuscas.add(BusacaVenda);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setEnabled(false);
		mnAjuda.add(mntmSobre);
		
		JLabel lblPorFavorInsira = new JLabel("Por Favor Insira o endere\u00E7o IP do servidor  em qual o Banco de Dados se situa.");
		lblPorFavorInsira.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoServidor = new JTextField();
		enderecoServidor.setText("localhost");
		lblPorFavorInsira.setLabelFor(enderecoServidor);
		enderecoServidor.setColumns(10);
		
		JLabel lblPorFavorInsira_1 = new JLabel("Por Favor Insira a prota do servidor  em que o Banco de Dados se encontra.");
		lblPorFavorInsira_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		portaServidor = new JTextField();
		lblPorFavorInsira_1.setLabelFor(portaServidor);
		portaServidor.setText("5432");
		portaServidor.setColumns(10);
		
		JLabel lblSenhaDoUsuario = new JLabel("Senha do usuario postgres:");
		lblSenhaDoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		senhaServidor = new JTextField();
		lblSenhaDoUsuario.setLabelFor(senhaServidor);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					conection=ConectaBanco.getConection(getEnderecoServidor(), getPotaServidor(), getSenhaServidor());
					JOptionPane.showMessageDialog(null, "Conecção realizada com sucesso.", "Informação", 1);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Não é possivel conectar ao banco de dados. Verifique as informações.", "Alerta", 0);
					e.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmAgenciaDeTurismo.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblPorFavorInsira, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblPorFavorInsira_1)
							.addComponent(enderecoServidor, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(senhaServidor, Alignment.LEADING)
								.addComponent(portaServidor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)))
						.addComponent(lblSenhaDoUsuario)
						.addComponent(btnConectar))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPorFavorInsira)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(enderecoServidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPorFavorInsira_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(portaServidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSenhaDoUsuario)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(senhaServidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConectar)
					.addContainerGap(287, Short.MAX_VALUE))
		);
		frmAgenciaDeTurismo.getContentPane().setLayout(groupLayout);
	}

	/**
	 * @return the enderecoServidor
	 */
	private String getEnderecoServidor() {
		return enderecoServidor.getText();
	}

	/**
	 * @return the portaServidor
	 */
	private String getPotaServidor() {
		return portaServidor.getText();
	}

	/**
	 * @return the senhaServidor
	 */
	private String getSenhaServidor() {
		return senhaServidor.getText();
	}
	/**
	 * @return true se não foi realiado concção com sucesso
	 */
	private boolean conectionIsNull() {
		return conection==null;
	}

	/**
	 * Mostra mensagem  solicitando que seja realizado a conecção com o banco
	 */
	private void mensagemConectarBanco() {
		JOptionPane.showMessageDialog(null, "Favor realize primeiro a conecção com o servidor.", "Alerta", 0);
	}
}

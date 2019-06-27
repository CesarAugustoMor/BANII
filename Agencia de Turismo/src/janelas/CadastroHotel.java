package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;

public class CadastroHotel {

	private JFrame frmCadastroHotel;
	private JTextField nomeHotel;
	private JTextField enderecoHotel;
	private JTextField nQuartosHotel;
	private JLabel lblCategoria;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Connection conection;

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroHotel window = new CadastroHotel(conection);
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
	public CadastroHotel(Connection conection) {
		this.conection=conection;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroHotel = new JFrame();
		frmCadastroHotel.setType(Type.UTILITY);
		frmCadastroHotel.setResizable(false);
		frmCadastroHotel.setTitle("Cadastro de Hotel");
		frmCadastroHotel.setBounds(100, 100, 260, 450);
		frmCadastroHotel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setToolTipText("Nome do Hotel a ser cadastrado!. Este campo \u00E9 de quesito Obrigat\u00F3rio.");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeHotel = new JTextField();
		nomeHotel.setToolTipText("Nome do Hotel a ser cadastrado!. Este campo \u00E9 de quesito Obrigat\u00F3rio.");
		lblNome.setLabelFor(nomeHotel);
		nomeHotel.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o: *");
		lblEndereo.setToolTipText("Endere\u00E7o do hotel em quest\u00E3o. Campo de crit\u00E9rio obrigat\u00F3rio.");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoHotel = new JTextField();
		lblEndereo.setLabelFor(enderecoHotel);
		enderecoHotel.setToolTipText("Endere\u00E7o do hotel em quest\u00E3o. Campo de crit\u00E9rio obrigat\u00F3rio.");
		enderecoHotel.setColumns(10);
		
		JLabel lblQuartosHotel = new JLabel("N\u00FAmero de quartos: *");
		lblQuartosHotel.setToolTipText("N\u00FAmero de quartos no hotel em quest\u00E3o. Campo de  quesito Obrigat\u00F3rio.");
		lblQuartosHotel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nQuartosHotel = new JTextField();
		nQuartosHotel.setToolTipText("N\u00FAmero de quartos no hotel em quest\u00E3o. Campo de  quesito Obrigat\u00F3rio.");
		lblQuartosHotel.setLabelFor(nQuartosHotel);
		nQuartosHotel.setColumns(10);
		
		lblCategoria = new JLabel("Categoria: *");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnUmaEstrela = new JRadioButton("Uma Estrela");
		rdbtnUmaEstrela.setSelected(true);
		rdbtnUmaEstrela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnUmaEstrela);
		rdbtnUmaEstrela.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
		JRadioButton rdbtnDuasEstrelas = new JRadioButton("Duas Estrelas");
		rdbtnDuasEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnDuasEstrelas);
		rdbtnDuasEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
		JRadioButton rdbtnTrsEstrelas = new JRadioButton("Tr\u00EAs Estrelas");
		rdbtnTrsEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnTrsEstrelas);
		rdbtnTrsEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
		JRadioButton rdbtnQuatroEstrela = new JRadioButton("Quatro Estrela");
		rdbtnQuatroEstrela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnQuatroEstrela);
		rdbtnQuatroEstrela.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
		JRadioButton rdbtnCincoEstrela = new JRadioButton("Cinco Estrela");
		rdbtnCincoEstrela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnCincoEstrela);
		rdbtnCincoEstrela.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroHotel.dispose();
			}
		});
		
		JLabel lblRestaurante = new JLabel("Restaurante:");
		lblRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> restaurantes = new JComboBox<String>();// Colocar Lógica para aparecer na lista
		lblRestaurante.setLabelFor(restaurantes);
		restaurantes.setModel(new DefaultComboBoxModel<String>(new String[] {null,"Novo Restaurante", "teste1", "teste2", "teste3", "teste4", "teste5", "teste6", "teste7"}));
		restaurantes.setSelectedIndex(0);
		GroupLayout groupLayout = new GroupLayout(frmCadastroHotel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblRestaurante)
						.addComponent(rdbtnCincoEstrela)
						.addComponent(rdbtnQuatroEstrela)
						.addComponent(rdbtnUmaEstrela)
						.addComponent(lblCategoria)
						.addComponent(rdbtnTrsEstrelas)
						.addComponent(rdbtnDuasEstrelas)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(nomeHotel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
							.addComponent(lblNome, Alignment.LEADING)
							.addComponent(lblEndereo, Alignment.LEADING)
							.addComponent(enderecoHotel, Alignment.LEADING)
							.addComponent(lblQuartosHotel, Alignment.LEADING)
							.addComponent(nQuartosHotel, Alignment.LEADING)
							.addComponent(restaurantes, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
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
					.addComponent(restaurantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCategoria)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnUmaEstrela)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnDuasEstrelas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnTrsEstrelas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnQuatroEstrela)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnCincoEstrela)
					.addPreferredGap(ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroHotel.getContentPane().setLayout(groupLayout);
	}
}

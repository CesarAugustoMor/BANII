package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class CadastroQuartos {

	private JFrame frmCadastroDeQuartos;
	private JTextField valorQuarto;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Connection conection;

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroQuartos window = new CadastroQuartos(conection);
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
	public CadastroQuartos(Connection conection) {
		this.conection=conection;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeQuartos = new JFrame();
		frmCadastroDeQuartos.setTitle("Cadastro de Quartos em Hot\u00E9is.");
		frmCadastroDeQuartos.setType(Type.UTILITY);
		frmCadastroDeQuartos.setResizable(false);
		frmCadastroDeQuartos.setBounds(100, 100, 260, 360);
		frmCadastroDeQuartos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblHotel = new JLabel("Hotel: *");
		lblHotel.setToolTipText("* Campo de quisito obrigat\u00F3rio.");
		lblHotel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> listaHotel = new JComboBox<String>();
		listaHotel.setToolTipText("Lista de Hoteis j\u00E1 cadastrados. * Campo de quisito obrigat\u00F3rio.");
		lblHotel.setLabelFor(listaHotel);
		listaHotel.setModel(new DefaultComboBoxModel<String>(new String[] {null, "teste1", "teste2", "teste3", "teste4", "teste5"}));
		
		JLabel lblValor = new JLabel("Valor: *");
		lblValor.setToolTipText("Valor em Reais (R$) do quarto a ser cadastrado.");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		valorQuarto = new JTextField();
		valorQuarto.setToolTipText("Valor em Reais (R$) do quarto a ser cadastrado.");
		lblValor.setLabelFor(valorQuarto);
		valorQuarto.setColumns(10);
		
		JLabel lblTipoDoQuarto = new JLabel("Tipo do quarto: *");
		lblTipoDoQuarto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton = new JRadioButton("Uma Estrela");
		buttonGroup.add(radioButton);
		lblTipoDoQuarto.setLabelFor(radioButton);
		radioButton.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		radioButton.setSelected(true);
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_1 = new JRadioButton("Duas Estrelas");
		buttonGroup.add(radioButton_1);
		radioButton_1.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_2 = new JRadioButton("Tr\u00EAs Estrelas");
		buttonGroup.add(radioButton_2);
		radioButton_2.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		radioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_3 = new JRadioButton("Quatro Estrela");
		buttonGroup.add(radioButton_3);
		radioButton_3.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		radioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_4 = new JRadioButton("Cinco Estrela");
		buttonGroup.add(radioButton_4);
		radioButton_4.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		radioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setToolTipText("Cancela o cadastro de um quarto.");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeQuartos.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeQuartos.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(listaHotel, 0, 224, Short.MAX_VALUE)
							.addComponent(lblHotel)
							.addComponent(lblValor)
							.addComponent(valorQuarto)
							.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addComponent(radioButton_3, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addComponent(radioButton_4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTipoDoQuarto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
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
					.addComponent(lblValor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(valorQuarto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTipoDoQuarto, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(radioButton_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(radioButton_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroDeQuartos.getContentPane().setLayout(groupLayout);
	}

}

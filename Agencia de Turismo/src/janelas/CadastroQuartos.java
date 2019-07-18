package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastroQuartos {

	private JDialog frmCadastroDeQuartos;
	private JTextField valorQuarto;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Connection conection;
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Launch the application.
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
		valorQuarto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar());
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
		
		JRadioButton umaEstrela = new JRadioButton("Uma Estrela");
		umaEstrela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar());
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(umaEstrela);
		lblTipoDoQuarto.setLabelFor(umaEstrela);
		umaEstrela.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		umaEstrela.setSelected(true);
		umaEstrela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton duasEstrelas = new JRadioButton("Duas Estrelas");
		duasEstrelas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar());
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(duasEstrelas);
		duasEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		duasEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton tresEstrelas = new JRadioButton("Tr\u00EAs Estrelas");
		tresEstrelas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar());
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(tresEstrelas);
		tresEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		tresEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton quatroEstrelas = new JRadioButton("Quatro Estrela");
		quatroEstrelas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar());
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(quatroEstrelas);
		quatroEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		quatroEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton cincoEstrela = new JRadioButton("Cinco Estrela");
		cincoEstrela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar());
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		buttonGroup.add(cincoEstrela);
		cincoEstrela.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		cincoEstrela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnCadastrar.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
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
							.addComponent(umaEstrela, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addComponent(duasEstrelas, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addComponent(tresEstrelas, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addComponent(quatroEstrelas, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addComponent(cincoEstrela, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(umaEstrela, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(duasEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(tresEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(quatroEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(cincoEstrela, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroDeQuartos.getContentPane().setLayout(groupLayout);
	}

}

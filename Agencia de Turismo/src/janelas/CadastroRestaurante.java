package janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Restaurante;
import interacaoBanco.ExecutaQuery;

public class CadastroRestaurante {

	private JDialog frmCadastroDeRestaurante;
	private JTextField nomeRestaurante;
	private JTextField enderecoRestaurante;
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
					CadastroRestaurante window = new CadastroRestaurante(conection, frPrincipal);
					window.frmCadastroDeRestaurante.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroRestaurante(Connection conection, JFrame frPrincipal) {
		this.conection=conection;
		initialize(frPrincipal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frPrincipal) {
		frmCadastroDeRestaurante = new JDialog(frPrincipal);
		frmCadastroDeRestaurante.setModal(true);
		frmCadastroDeRestaurante.setTitle("Cadastro de Restaurante.");
		frmCadastroDeRestaurante.setResizable(false);
		frmCadastroDeRestaurante.setType(Type.UTILITY);
		frmCadastroDeRestaurante.setBounds(100, 100, 260, 350);
		frmCadastroDeRestaurante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeRestaurante = new JTextField();
		nomeRestaurante.addKeyListener(new KeyAdapter() {
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
		lblNome.setLabelFor(nomeRestaurante);
		nomeRestaurante.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o: *");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoRestaurante = new JTextField();
		enderecoRestaurante.addKeyListener(new KeyAdapter() {
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
		enderecoRestaurante.setColumns(10);

		JRadioButton umEstrela = new JRadioButton("Uma Estrela");
		umEstrela.addKeyListener(new KeyAdapter() {
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
		buttonGroup.add(umEstrela);
		umEstrela.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		umEstrela.setSelected(true);
		umEstrela.setFont(new Font("Tahoma", Font.PLAIN, 13));

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
		
		JRadioButton cincoEstrelas = new JRadioButton("Cinco Estrela");
		cincoEstrelas.addKeyListener(new KeyAdapter() {
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
		buttonGroup.add(cincoEstrelas);
		cincoEstrelas.setToolTipText("Qualidade do Hotel representada em uma classifica\u00E7\u00E3o de uma a cindo estrelas.");
		cincoEstrelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel labelTipoQuarto = new JLabel("Tipo do quarto: *");
		labelTipoQuarto.setLabelFor(umEstrela);
		labelTipoQuarto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Restaurante rest = new Restaurante();
				rest.setEndereco(getEndereco());
				rest.setNome(getNomeRetaurante());
				if (cincoEstrelas.isSelected()) {
					rest.setCategoria(5);
				} else if (duasEstrelas.isSelected()) {
					rest.setCategoria(2);
				} else if (tresEstrelas.isSelected()) {
					rest.setCategoria(3);
				} else if (quatroEstrelas.isSelected()) {
					rest.setCategoria(4);
				} else {
					rest.setCategoria(1);
				}
				if (!ExecutaQuery.cadastra(rest.restauranteParaCadastro(), conection)) {
					Mesnsagens.mensagemErroCadastrar();
				} else {
					Mesnsagens.mensegemSucessoCadastro();
					frmCadastroDeRestaurante.dispose();
				}
			}
		});
		btnCadastrar.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeRestaurante.dispose();
			}
		});
		btnCancelar.setToolTipText("Cancela o cadastro de um quarto.");
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeRestaurante.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nomeRestaurante, 223, 223, 223)
						.addComponent(umEstrela, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(duasEstrelas, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(tresEstrelas, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(quatroEstrelas, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(lblEndereo)
						.addComponent(enderecoRestaurante, 223, 223, 223)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(cincoEstrelas, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
									.addGap(3)))
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(labelTipoQuarto, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nomeRestaurante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEndereo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(enderecoRestaurante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelTipoQuarto, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(umEstrela, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(duasEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(tresEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(quatroEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(cincoEstrelas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroDeRestaurante.getContentPane().setLayout(groupLayout);
	}
	/**
	 * @return the nomeRest
	 */
	private String getNomeRetaurante() {
		System.out.println("Nome: "+nomeRestaurante.getText());
		return nomeRestaurante.getText();
	}
	/**
	 * @return the nomeCasaShow
	 */
	private String getEndereco() {
		return enderecoRestaurante.getText();
	}
}

package janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Cliente;
import interacaoBanco.ExecutaQuery;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastroCliente {

	private JDialog frmCadastroCliente;
	private JTextField nomeCliente;
	private JTextField cpfCliente;
	private JTextField telefoneCliente;
	private JTextField emailCliente;
	private Connection conection;
	private JButton btnCadastrar = new JButton("Cadastrar");
	JButton btnCancelar = new JButton("Cancelar");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void Abrir(Connection conection, JFrame frPrincipal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente window = new CadastroCliente(conection, frPrincipal);
					window.frmCadastroCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param conection 
	 */
	public CadastroCliente(Connection conection, JFrame frPrincipal) {
		this.conection=conection;
		initialize(frPrincipal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frPrincipal) {
		frmCadastroCliente = new JDialog(frPrincipal);
		frmCadastroCliente.setResizable(false);
		frmCadastroCliente.setTitle("Cadastro Cliente");
		frmCadastroCliente.setLocationByPlatform(true);
		frmCadastroCliente.setType(Type.UTILITY);
		frmCadastroCliente.setBounds(100, 100, 233, 310);
		frmCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeCliente = new JTextField();
		nomeCliente.addKeyListener(new KeyAdapter() {
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
		nomeCliente.setToolTipText("Nome (Obrigat\u00F3rio)");
		nomeCliente.setColumns(10);
		
		JLabel lblCpfapnasNumeros = new JLabel("CPF: (apenas n\u00FAmeros) *");
		lblCpfapnasNumeros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cpfCliente = new JTextField();
		cpfCliente.addKeyListener(new KeyAdapter() {
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
		cpfCliente.setToolTipText("CPF (Apenas n\u00FAmeros e \u00E9 Obrigat\u00F3rio)");
		cpfCliente.setColumns(10);
		
		JLabel lblTelefoneapenasNmeros = new JLabel("Telefone: (apenas n\u00FAmeros)");
		lblTelefoneapenasNmeros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		telefoneCliente = new JTextField();
		telefoneCliente.addKeyListener(new KeyAdapter() {
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
		telefoneCliente.setToolTipText("Telefone (Opcional)");
		telefoneCliente.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		emailCliente = new JTextField();
		emailCliente.addKeyListener(new KeyAdapter() {
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
		emailCliente.setToolTipText("E-mail  (Opcional)");
		emailCliente.setColumns(10);
		
		buttonGroup.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente= new Cliente();
				cliente.setCpf(getCpfCliente());
				cliente.setNome(getNomeCliente());
				cliente.setTelefone(getTelefoneCliente());
				cliente.setEmail(getEmailCliente());
				if (!ExecutaQuery.cadastra(cliente.clienteParaCadastro(), conection)) {
					mensagemErroCadastrar();
				} else {
					mensegemSucessoCadastro();
					frmCadastroCliente.dispose();
				}
			}
		});
		
		buttonGroup.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroCliente.dispose();
			}
		});
		btnCancelar.setToolTipText("Cancela a Opera\u00E7\u00E3o");
		GroupLayout groupLayout = new GroupLayout(frmCadastroCliente.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpfapnasNumeros)
						.addComponent(lblEmail)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(emailCliente)
							.addComponent(nomeCliente, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
							.addComponent(lblTelefoneapenasNmeros)
							.addComponent(telefoneCliente)
							.addComponent(cpfCliente)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCpfapnasNumeros)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cpfCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTelefoneapenasNmeros)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(telefoneCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(emailCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadastroCliente.getContentPane().setLayout(groupLayout);
	}

	/**
	 * @return the nomeCliente
	 */
	private String getNomeCliente() {
		return nomeCliente.getText().trim();
	}

	/**
	 * @return the cpfCliente
	 */
	private Integer getCpfCliente() {
		return Integer.parseInt(cpfCliente.getText().trim());
	}

	/**
	 * @return the telefoneCliente
	 */
	private Integer getTelefoneCliente() {
		if (telefoneCliente.getText().equals("")) {
			return null;
		}
		return Integer.parseInt(telefoneCliente.getText());
	}

	/**
	 * @return the emailCliente
	 */
	private String getEmailCliente() {
		if (emailCliente.getText().equals("")) {
			return null;
		}
		return emailCliente.getText().trim();
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
}

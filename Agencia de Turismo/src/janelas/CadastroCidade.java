package janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Cidade;
import interacaoBanco.ExecutaQuery;

public class CadastroCidade {

	private JDialog frmCadatroDeCidade;
	private JTextField nomeCidade;
	private JTextField estadoCidade;
	private JTextField populacaoCidade;
	private Connection conection;
	private JButton btnCadastrar = new JButton("Cadastrar");
	
	private JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection,JFrame frPrincipal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCidade window = new CadastroCidade(conection,frPrincipal);
					window.frmCadatroDeCidade.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroCidade(Connection conection, JFrame frPrincipal) {
		this.conection=conection;
		initialize(frPrincipal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frPrincipal) {
		frmCadatroDeCidade = new JDialog(frPrincipal);
		frmCadatroDeCidade.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		frmCadatroDeCidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		frmCadatroDeCidade.setLocationByPlatform(true);
		frmCadatroDeCidade.setResizable(false);
		frmCadatroDeCidade.setType(Type.UTILITY);
		frmCadatroDeCidade.setTitle("Cadatro de Cidade");
		frmCadatroDeCidade.setBounds(100, 100, 230, 261);
		frmCadatroDeCidade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setToolTipText("Nome da cidade.");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomeCidade = new JTextField();
		nomeCidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		nomeCidade.setToolTipText("Nome da ciadade.");
		nomeCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado: *");
		lblEstado.setToolTipText("Estado em que a cidade pertence.");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		estadoCidade = new JTextField();
		estadoCidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		estadoCidade.setToolTipText("Estado em que a cidade pertence.");
		estadoCidade.setColumns(10);
		
		JLabel lblPopulcao = new JLabel("Popula\u00E7\u00E3o: *");
		lblPopulcao.setToolTipText("N\u00FAmero de habitantes da cidade.");
		lblPopulcao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		populacaoCidade = new JTextField();
		populacaoCidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCadastrar.doClick();
				}
			}
		});
		populacaoCidade.setToolTipText("N\u00FAmero de habitantes da cidade.");
		populacaoCidade.setColumns(10);
		
		JLabel lblCamposObrigatorios = new JLabel("* Campos Obrigatorios.");
		lblCamposObrigatorios.setLabelFor(frmCadatroDeCidade);
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
			public void actionPerformed(ActionEvent arg0) {
				Cidade cidade= new Cidade();
				cidade.setNome(getNomeCidade());
				cidade.setEstado(getEstado());
				cidade.setPopulacao(getPopulacao());
				if (!ExecutaQuery.cadastra(cidade.cidadeParaCadastro(), conection)) {
					mensagemErroCadastrar();
				} else {
					mensegemSucessoCadastro();
					frmCadatroDeCidade.dispose();
				}
			}
		});
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar()==KeyEvent.VK_ESCAPE) {
					btnCancelar.doClick();
				} else if (arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					btnCancelar.doClick();
				}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadatroDeCidade.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmCadatroDeCidade.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNome)
						.addComponent(lblEstado)
						.addComponent(lblPopulcao)
						.addComponent(populacaoCidade)
						.addComponent(estadoCidade)
						.addComponent(nomeCidade, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(lblCamposObrigatorios))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nomeCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEstado)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(estadoCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPopulcao)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(populacaoCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCamposObrigatorios)
					.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		frmCadatroDeCidade.getContentPane().setLayout(groupLayout);
	}
	/**
	 * @return the nomeCidade
	 */
	private String getNomeCidade() {
		if (nomeCidade.getText().equals("")) {
			return null;
		}
		return nomeCidade.getText().trim();
	}

	/**
	 * @return the populacaoCiadade
	 */
	private Long getPopulacao() {
		if (populacaoCidade.getText().equals("")) {
			return null;
		}
		return Long.parseLong(populacaoCidade.getText().trim());
	}

	/**
	 * @return the estadoCidade
	 */
	private String getEstado() {
		if (estadoCidade.getText().equals("")) {
			return null;
		}
		return estadoCidade.getText().trim();
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

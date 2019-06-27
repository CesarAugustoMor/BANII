package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class CadastroIgreja {

	private JFrame frmCadastroDeIgreja;
	private JTextField enderecoPontoIgreja;
	private JTextField nomePontoIgreja;
	private JTextField dataConstrucao;
	private JTextField estiloConstrucao;
	private Connection conection;

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroIgreja window = new CadastroIgreja(conection);
					window.frmCadastroDeIgreja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroIgreja(Connection conection) {
		this.conection=conection;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeIgreja = new JFrame();
		frmCadastroDeIgreja.setType(Type.UTILITY);
		frmCadastroDeIgreja.setTitle("Cadastro de Igreja");
		frmCadastroDeIgreja.setResizable(false);
		frmCadastroDeIgreja.setBounds(100, 100, 260, 570);
		frmCadastroDeIgreja.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JEditorPane descricaoPontoIgreja = new JEditorPane();
		
		JLabel labelDescricaoPontoIgreja = new JLabel("Descri\u00E7\u00E3o: *");
		labelDescricaoPontoIgreja.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		enderecoPontoIgreja = new JTextField();
		enderecoPontoIgreja.setColumns(10);
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o: *");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomePontoIgreja = new JTextField();
		nomePontoIgreja.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome: *");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton button = new JButton("Cadastrar");
		button.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeIgreja.dispose();
			}
		});
		button_1.setToolTipText("Cancela o cadastro de um quarto.");
		
		JLabel lblData = new JLabel("Data constru\u00E7\u00E3o: *");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		dataConstrucao = new JTextField();
		lblData.setLabelFor(dataConstrucao);
		dataConstrucao.setColumns(10);
		
		JLabel lblEstiloDeContruo = new JLabel("Estilo de contru\u00E7\u00E3o: *");
		lblEstiloDeContruo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		estiloConstrucao = new JTextField();
		estiloConstrucao.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeIgreja.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(descricaoPontoIgreja, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEstiloDeContruo)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(estiloConstrucao, Alignment.LEADING)
							.addComponent(dataConstrucao, Alignment.LEADING)
							.addComponent(lblData, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(labelNome, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(nomePontoIgreja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(labelEndereco, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addComponent(enderecoPontoIgreja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
						.addComponent(labelDescricaoPontoIgreja, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(nomePontoIgreja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(labelEndereco, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(enderecoPontoIgreja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblData)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dataConstrucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEstiloDeContruo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(estiloConstrucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelDescricaoPontoIgreja, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(descricaoPontoIgreja, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		frmCadastroDeIgreja.getContentPane().setLayout(groupLayout);
	}
}

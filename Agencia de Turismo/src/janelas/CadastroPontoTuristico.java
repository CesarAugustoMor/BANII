package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class CadastroPontoTuristico {

	private JFrame frmCadastroPontoTurstico;
	private JTextField enderecoPonto;
	private JTextField nomePontoT;
	private Connection conection;

	/**
	 * Launch the application.
	 */
	public static void Abrir(Connection conection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPontoTuristico window = new CadastroPontoTuristico(conection);
					window.frmCadastroPontoTurstico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroPontoTuristico(Connection conection) {
		this.conection=conection;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroPontoTurstico = new JFrame();
		frmCadastroPontoTurstico.setResizable(false);
		frmCadastroPontoTurstico.setType(Type.UTILITY);
		frmCadastroPontoTurstico.setTitle("Cadastro Ponto Tur\u00EDstico.");
		frmCadastroPontoTurstico.setBounds(100, 100, 260, 501);
		frmCadastroPontoTurstico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		enderecoPonto = new JTextField();
		enderecoPonto.setColumns(10);
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o: *");
		labelEndereco.setLabelFor(enderecoPonto);
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nomePontoT = new JTextField();
		nomePontoT.setColumns(10);
		
		JLabel labelNomePonto = new JLabel("Nome: *");
		labelNomePonto.setLabelFor(nomePontoT);
		labelNomePonto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setToolTipText("Cadastra o quarto se n\u00E3o eceder o numero de quartos j\u00E1 cadastrados no hotel em espec\u00EDfico.");
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroPontoTurstico.dispose();
			}
		});
		Cancelar.setToolTipText("Cancela o cadastro de um quarto.");
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o: *");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JEditorPane descricaoPontoTuristico = new JEditorPane();
		lblDescrio.setLabelFor(descricaoPontoTuristico);
		GroupLayout groupLayout = new GroupLayout(frmCadastroPontoTurstico.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(labelNomePonto, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomePontoT, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Cadastrar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(Cancelar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDescrio)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(descricaoPontoTuristico, Alignment.LEADING)
							.addComponent(labelEndereco, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(enderecoPonto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNomePonto, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(nomePontoT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(labelEndereco, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(enderecoPonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDescrio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(descricaoPontoTuristico, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Cadastrar)
						.addComponent(Cancelar))
					.addContainerGap())
		);
		frmCadastroPontoTurstico.getContentPane().setLayout(groupLayout);
	}
}

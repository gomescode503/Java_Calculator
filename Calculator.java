import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;	 
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Serif", Font.BOLD, 30); //(fonte, formatação, tamanho)
	
	double num1=0, num2 = 0, result = 0;
	char operator;
	
	
	Calculator(){
		
		frame = new JFrame("Calculator"); //titulo
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //função para fechar
		frame.setSize(420, 550); //tamanho da janela
		frame.setLayout(null); 
		
		textfield = new JTextField(); //regula a parte que mostra o display dos numeros
		textfield.setBounds(50, 25, 300, 50); //regula o tamanho do display
		textfield.setFont(myFont); // seta a fonte
		textfield.setEditable(false);// nao consegue dar inputs pelo teclado
		textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//adicionar os numeros:
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("←");
		clrButton = new JButton("C");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);		
			functionButtons[i].setBackground(Color.GRAY);
			functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);	
			numberButtons[i].setBackground(Color.GRAY);
			numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);
		
		//fundo cinza (panel)
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.GRAY); 
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		//adiciona os numeros e operadores
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield); //adiciona o display
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();	    

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		//metodo de soma
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText()); 
			operator = '+';
			textfield.setText(""); 
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) { 
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;			
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}		
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length()-1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		//negativo:
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText()); //guarda o valor em temp
			temp *= -1;// transforma em negativo
			textfield.setText(String.valueOf(temp)); //printa o novo valor
		}
	}
}

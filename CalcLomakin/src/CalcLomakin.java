import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class CalcLomakin {
	
	public static void main(String[] args) {
	Form1 f =	new Form1();
		
	}
}

class Form1 extends JFrame{
	protected String action=null;
	protected int first=0;
	protected int second=0;
	
	Form1() {
		JLabel label = new JLabel("0");
		Font f = new Font("Courier", Font.BOLD, 25);
		label.setFont(f);
		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setOpaque(true);
						
		ArrayList<JButton> buttonList = getButtonArray();
		setButtonActions(buttonList, label);
		
		JPanel panel0 = new JPanel(); //Общая панель 
		JPanel panel1 = new JPanel(); //это общая панель кнопок
		
		JPanel panelNubmers1= new JPanel(); //Для кнопок действий
		JPanel panelNubmers2= new JPanel(); //789
		JPanel panelNubmers3= new JPanel(); //456
		JPanel panelNubmers4= new JPanel(); //123
		JPanel panelNubmers5= new JPanel(); //,0=
		
		panel0.setLayout(new BorderLayout(0, 0));
		panel1.setLayout(new GridLayout(5, 1, 0, 0));
		
		panelNubmers1.setLayout(new GridLayout(1, 5, 0, 0));
		panelNubmers1.add(buttonList.get(10));
		panelNubmers1.add(buttonList.get(11));
		panelNubmers1.add(buttonList.get(12));
		panelNubmers1.add(buttonList.get(13));
		panelNubmers1.add(buttonList.get(15));
		
		panelNubmers2.setLayout(new GridLayout(1, 3, 0, 0));
		panelNubmers2.add(buttonList.get(7));
		panelNubmers2.add(buttonList.get(8));
		panelNubmers2.add(buttonList.get(9));
		
		panelNubmers3.setLayout(new GridLayout(1, 3, 0, 0));
		panelNubmers3.add(buttonList.get(4));
		panelNubmers3.add(buttonList.get(5));
		panelNubmers3.add(buttonList.get(6));
	
		panelNubmers4.setLayout(new GridLayout(1, 3, 0, 0));
		panelNubmers4.add(buttonList.get(1));
		panelNubmers4.add(buttonList.get(2));
		panelNubmers4.add(buttonList.get(3));
				
		panelNubmers5.setLayout(new GridLayout(1, 3, 0, 0));
		panelNubmers5.add(buttonList.get(14));
		panelNubmers5.add(buttonList.get(0));
		panelNubmers5.add(buttonList.get(16));
				
		panel1.add(panelNubmers1);
		panel1.add(panelNubmers2);
		panel1.add(panelNubmers3);
		panel1.add(panelNubmers4);
		panel1.add(panelNubmers5);
		
		panel0.add(label, BorderLayout.NORTH);
		panel0.add(panel1, BorderLayout.CENTER);
		setContentPane(panel0);
		
		/*
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
		    public void eventDispatched(AWTEvent event) {
			java.awt.event.KeyEvent kEvt = (java.awt.event.KeyEvent) event;
				
		    }
		}, AWTEvent.KEY_EVENT_MASK);
		*/
		
		setBounds(150, 150, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Калькулятор v1.0");
		setVisible(true);
	}

	private void setButtonActions(ArrayList<JButton> buttonList, JLabel label) {
		//Действия для цифровых кнопок
		for(int i=0; i<10;i++){
		JButton b = buttonList.get(i);
		b.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				if (label.getText()=="0") label.setText(b.getText());
				else label.setText(label.getText()+b.getText());
			}
		});
		}
		
		//действия для кнопок арифметичесих действий
		for(int i=10; i<14;i++){
			JButton b = buttonList.get(i);
			b.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
				char ch = label.getText().charAt(label.getText().length()-1);
				if (ch!='.') { 
				if (!(label.getText().contains("*")) &&	!(label.getText().contains("+")) && !(label.getText().contains("-")) && !(label.getText().contains("/"))){
					label.setText(label.getText()+b.getText());					
				}
				}
				}
			});
			}
		//Запятая 
		buttonList.get(14).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char ch = label.getText().charAt(label.getText().length()-1);
				if ((ch!='*') && (ch!='/') && (ch!='+') & (ch!='-')){		
				if (!(label.getText().contains("."))) {
					label.setText(label.getText()+buttonList.get(14).getText());	
				}
				}
			}
		});
				
		//Кнопка "CE"
		buttonList.get(15).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("0");
			}
		});
		
		//Кнопка "=" Самое сложное
		buttonList.get(16).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentAction=null;
				float result=0;
				if(label.getText().contains("*")) currentAction="\\*";
				if(label.getText().contains("+")) currentAction="\\+";
				if(label.getText().contains("-")) currentAction="-";
				if(label.getText().contains("/")) currentAction="/";
				
				String[] parts = label.getText().split(currentAction);
				
				try {
					float a = new Float(parts[0]);
					float b = new Float(parts[1]);
					if (b==0){
						label.setText("Zero devide!");
						return;
					}
					if (currentAction=="\\*") result=a*b;
					if (currentAction=="\\+") result=a+b;
					if (currentAction=="-") result=a-b;
					if (currentAction=="/") result=a/b;
					
					if (result % 1 == 0) label.setText(Integer.toString((int) result));
					else label.setText(String.valueOf(result));
				} catch (Exception e2) {
				}
				
				
			}
		});
	}

	private ArrayList<JButton> getButtonArray() {
		ArrayList<JButton> list = new ArrayList<JButton>();
		list.add(new JButton("0"));
		list.add(new JButton("1"));
		list.add(new JButton("2"));
		list.add(new JButton("3"));
		list.add(new JButton("4"));
		list.add(new JButton("5"));
		list.add(new JButton("6"));
		list.add(new JButton("7"));
		list.add(new JButton("8"));
		list.add(new JButton("9"));
		list.add(new JButton("+"));	//10
		list.add(new JButton("-"));	//11
		list.add(new JButton("*"));	//12
		list.add(new JButton("/"));	//13
		list.add(new JButton("."));//14
		list.add(new JButton("CE"));//15
		list.add(new JButton("="));//16
		return list;
	}
	
}
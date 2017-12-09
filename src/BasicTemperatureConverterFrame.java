import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;

public class BasicTemperatureConverterFrame extends JFrame{
	private ActionListener acList;
	private ActionListener chList;
	private JTextField inputbox = new JTextField(10);
	private JTextField outputbox = new JTextField(10);
	private JRadioButton CelInput;
	private JRadioButton FahInput;
	private JRadioButton KelInput;
	private JRadioButton CelOutput;
	private JRadioButton FahOutput;
	private JRadioButton KelOutput;
	private String degree = "" + (char)176;
	private JLabel inputTitle = new JLabel("Input:");
	private JLabel outputTitle = new JLabel("Output:");
	DecimalFormat rnd = new DecimalFormat("0.00");
	TempConverter tCon = new TempConverter();
	
	/*Input and Output fields*/
	public BasicTemperatureConverterFrame(){
		JPanel inputPanel = new JPanel();
		inputPanel.add(inputTitle);
		inputPanel.add(inputbox);
		//inputbox.setEditable(true);
		JPanel outputPanel = new JPanel();
		outputPanel.add(outputTitle);
		outputPanel.add(outputbox);
		outputbox.setEditable(false);
		add(inputPanel, BorderLayout.NORTH); 
		add(outputPanel, BorderLayout.SOUTH);
		/*Make sure a button gets clicked to respond*/
		class ChoiceListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				outputConvertedTemp();
			}
		}
		acList = new ChoiceListener();
		/*Respond to ENTER key*/
		inputbox.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        System.out.println("Click any Scale...");
			        outputConvertedTemp();
			}
		});
		createConversionTable();
		setSize(337, 200);//Size of the Frame
	}
	/*Main center panel to hold radio button*/
	public void createConversionTable(){
		JPanel leftPnl = inputRadioButton();//Left Panel for Radio Buttons 
		JPanel rightPnl = outputRadioButton();//Right Panel for Radio Buttons
		JPanel conversionTable = new JPanel();
		conversionTable.setLayout(new GridLayout(1, 2));
		conversionTable.add(leftPnl);
		conversionTable.add(rightPnl);
		add(conversionTable, BorderLayout.CENTER);
	}
	/*Create Radio Buttons for input*/
	public JPanel inputRadioButton(){
		//Action Listeners
		CelInput = new JRadioButton("Celsius");
		CelInput.addActionListener(acList);
		FahInput = new JRadioButton("Fahrenheit");
		FahInput.addActionListener(acList);
		KelInput = new JRadioButton("Kelvin");
		KelInput.addActionListener(acList);	
		ButtonGroup group = new ButtonGroup();//Create input button group
		group.add(CelInput);
		group.add(FahInput);
		group.add(KelInput);
		JPanel inputButtons = new JPanel();//New panel for input
		inputButtons.setLayout(new GridLayout(3, 1));
		inputButtons.add(CelInput);
		inputButtons.add(FahInput);
		inputButtons.add(KelInput);
		inputButtons.setBorder(new TitledBorder("Input Scale"));//Create a border to organize
		return inputButtons;		
	}
	/*Create Radio Buttons for output*/
	public JPanel outputRadioButton(){
		//Action Listeners
		CelOutput = new JRadioButton("Celsius");
		CelOutput.addActionListener(acList);
		FahOutput = new JRadioButton("Fahrenheit");
		FahOutput.addActionListener(acList);
		KelOutput = new JRadioButton("Kelvin");
		KelOutput.addActionListener(acList);
		ButtonGroup group2 = new ButtonGroup();//Create button group for output
		group2.add(CelOutput);
		group2.add(FahOutput);
		group2.add(KelOutput);
		JPanel outputButtons = new JPanel();//New panel for output
		outputButtons.setLayout(new GridLayout(3, 1));
		outputButtons.add(CelOutput);
		outputButtons.add(FahOutput);
		outputButtons.add(KelOutput);
		outputButtons.setBorder(new TitledBorder("Output Scale"));
		return outputButtons;		
	}
	
	/*Calculate Temperature*/
	private void outputConvertedTemp(){
		double temp;
		double outTemp = 0;
		temp = Double.parseDouble(inputbox.getText());
		if (CelInput.isSelected() & KelOutput.isSelected())
			outTemp = (temp + 273);//Celsius to Kelvin
		else if (FahInput.isSelected() & KelOutput.isSelected())
			outTemp = ((.55555) * (temp - 32) + 273);//Fahrenheit to Kelvin
		else if (KelInput.isSelected() & FahOutput.isSelected())
			outTemp = (((temp - 273) * (1.8)) + 32);//Kelvin to Fahrenheit
		else if (CelInput.isSelected() & FahOutput.isSelected())
			outTemp = (((1.8) * temp) + 32);//Celsius to Fahrenheit
		else if (FahInput.isSelected() & CelOutput.isSelected())
			outTemp = ((.55555) * (temp - 32));//Fahrenheit to Celsius
		else if (KelInput.isSelected() & CelOutput.isSelected())
			outTemp = (temp - 273);//Kelvin to Celsius
		/*Input and output are same temperature category*/
		else if (CelInput.isSelected() & CelOutput.isSelected())
			outTemp = temp;
		else if (FahInput.isSelected() & FahOutput.isSelected())
			outTemp = temp;
		else if (KelInput.isSelected() & KelOutput.isSelected())
			outTemp = temp;
		outputbox.setText(" "+ rnd.format(outTemp) + degree);//Adding degree (º) sign
	}	
}

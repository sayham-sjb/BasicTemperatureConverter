import java.awt.Color;
import java.awt.Graphics;
import java.applet.*;
import java.awt.*;

import javax.swing.*;
public class BasicTemperatureConverterTest 
{
	public static void main(String[] args){
		//Creates main panel to show output
		JFrame frame = new BasicTemperatureConverterFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Basic Temperature Converter");
		frame.setLocationRelativeTo(null);//Set frame location
		frame.setVisible(true);
	}
}

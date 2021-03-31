package cs112project1;

import javax.print.DocFlavor.URL;
import javax.swing.*;
import cs112project1.DataPoint;

import java.awt.*;
import java.io.*;
import java.awt.GridLayout;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JLabel;


public class Driver {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		myFrame.setTitle("Data Points");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = myFrame.getContentPane();
		
		DummyPredictor dum = new DummyPredictor();
		ArrayList<DataPoint> list = dum.readData("Project1.txt");
		DataPoint trainPoint = list.get(0);
		DataPoint testPoint = list.get(1);
		System.out.println(dum.test(testPoint));
		System.out.println(dum.getPrecision(list));
		
		JLabel accuracy = new JLabel("Accuracy is " + dum.getAccuracy(list));
		contentPane.add(accuracy);
		JLabel precision = new JLabel("Precision is " + dum.getPrecision(list));
		contentPane.add(precision);
		
		myFrame.setVisible(true);
		myFrame.setLayout(new GridLayout(2,2));
		myFrame.setSize(200,200);
	}

}

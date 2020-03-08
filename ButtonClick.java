import javax.swing.JFrame;
import javax.swing.JPanel;//swings are light weights
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;//ActionListener is an interface
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;//awt is heavy weight
import java.awt.event.MouseEvent;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

class ButtonFrame extends JFrame implements ActionListener{
    Container contentPane = getContentPane();

    public ButtonFrame(){
        setBounds(100,100,600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JPanel myButtonPanel = new JPanel();

        myButtonPanel.setLayout(new FlowLayout());//flow layout arranges them left to right

        JButton button1 = new JButton("Button One");
        button1.addActionListener(this);

        JButton button2 = new JButton("Button Two");
        button2.addActionListener(new SeparateActionListener());

        JButton button3 = new JButton("Button Three");
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //System.out.println("Anonymous:: actionPerformed");
                JLabel button3Press = new JLabel("You Pressed Button Three!");
                button3Press.setLocation(40,40);
                button3Press.setSize(20,20);
                button3Press.setOpaque(true);
                button3Press.setForeground(Color.BLUE);
                add(button3Press);
                validate();
                repaint();
            }
        });

        myButtonPanel.add(button1);//button panel is a flow layout
        myButtonPanel.add(button2);
        myButtonPanel.add(button3);

        
        contentPane.setLayout(new BorderLayout());
        contentPane.add(myButtonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e){
        JLabel button1Press = new JLabel("You pressed Button One!");
        button1Press.setLocation(100,100);
        button1Press.setSize(20,20);
        button1Press.setOpaque(true);
        button1Press.setForeground(Color.BLUE);
        add(button1Press);
        validate();
        repaint();

    }
}

class SeparateActionListener extends JFrame implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
        JLabel button2Press = new JLabel("You pressed Button Two!");
        button2Press.setLocation(30,30);
        button2Press.setSize(20,20);
        button2Press.setOpaque(true);
        button2Press.setForeground(Color.BLUE);
        add(button2Press);
        validate();
        repaint();
        System.out.println("This button does nothing. I could not figure out how to get something to print through a separate ActionListener.");


        
    }
}

public class ButtonClick{
    public static void main(String[] args){
        System.out.println("Hello Button Click");

        ButtonFrame myButtonFrame = new ButtonFrame();
        myButtonFrame.setVisible(true);
    }
}
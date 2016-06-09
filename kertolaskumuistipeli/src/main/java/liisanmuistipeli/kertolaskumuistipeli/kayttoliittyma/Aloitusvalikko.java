/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author liisapauliina
 */
//public class Aloitusvalikko extends JPanel implements Runnable {
//
//    private JFrame frame;
//    private JPanel panel;
//    private Container c;
//
//    public Aloitusvalikko() {
//        
//    }
//    
//    @Override
//    public void run() {
//        frame = new JFrame("Kertolaskumuistipeli-valikko");
//        frame.setPreferredSize(new Dimension(600,400));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//     //   this.lisaaKomponentit(frame.getContentPane());
//        frame.pack();
//        frame.setVisible(true);
//    }

//    private void lisaaKomponentit(Container container) {
//        this.c = container;
//        Kuuntelija kuuntelija = new Kuuntelija();
//        FlowLayout fl = new FlowLayout();
//        frame.getContentPane().setLayout(fl);
//        for (int i = 1; i < 10; i++) {
//            JButton button = new JButton();
//            button.addActionListener(kuuntelija);
//            button.setText(Integer.toString(i));
//            frame.getContentPane().add(button);
//        }
//        
//    }
// }
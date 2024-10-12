import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JFrame frm = new JFrame("Fin the Card Game");
        frm.setBounds(100,50,800,800);
        frm.setLayout(null);

        Border b1 = BorderFactory.createLineBorder(Color.gray,4);

        JButton baslat = new JButton("Start the Game");
        baslat.setBounds(550,0,250,30);
        baslat.setBackground(Color.darkGray);
        baslat.setForeground(Color.CYAN);
        frm.add(baslat);

        ArrayList<JButton> butonlar = new ArrayList<>();
        JButton btn;
        for(int i=0;i<10;i++){
            int x = (int)(Math.random()*700);
            int y = (int)(Math.random()*700);
            int s = (int)(Math.random()*100);

            btn = new JButton(Integer.toString(s));
            btn.setFont(new Font("Comic Sans Ms",Font.BOLD,30));
            btn.setBounds(x,y,100,100);
            btn.setForeground(Color.red);
            btn.setBackground(Color.CYAN);
            btn.setBorder(b1);
            frm.add(btn);
            butonlar.add(btn);
        }

        Integer[] bb = new Integer[1];
        baslat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i< butonlar.size();i++){
                    butonlar.get(i).setForeground(Color.CYAN);
                }

                int a = (int)(Math.random()*butonlar.size());
                int b = Integer.parseInt(butonlar.get(a).getText());
                bb[0] = b;

                JOptionPane.showMessageDialog(null," Can you find the number " +b+ " ?","HAFIZA OYUNU",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        for(int i=0;i< butonlar.size();i++){
            JButton bt = butonlar.get(i);

            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(bb[0] == Integer.parseInt(bt.getText())){
                        bt.setBackground(Color.BLUE);
                        JOptionPane.showMessageDialog(null,"CORRECT !!!","GAME RESULT",JOptionPane.INFORMATION_MESSAGE);
                        for(int i=0;i< butonlar.size();i++){
                            butonlar.get(i).setForeground(Color.red);
                        }
                        JOptionPane.showMessageDialog(frm,"THE GAME IS OVER! PRESS THE START GAME BUTTON TO PLAY AGAIN!");
                        bt.setBackground(Color.CYAN);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"WRONG !!!","GAME RESULT",JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            frm.setVisible(true);
            frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }
}

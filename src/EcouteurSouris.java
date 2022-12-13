import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcouteurSouris extends MouseAdapter {
    @Override
    public void mouseEntered(MouseEvent e){
        JFrame fenSource = (JFrame) (e.getSource());
        fenSource.getContentPane().setBackground(Color.pink);
        fenSource.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e){
        JFrame fenSource = (JFrame) (e.getSource());
        fenSource.getContentPane().setBackground(Color.green);
        fenSource.repaint();
    }
}

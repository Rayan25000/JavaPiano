
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyInterface {



    public static void main(String[] args) {

        JFrame fen = new MaFrame();
        EcouteurSouris ecouteS = new EcouteurSouris();

        JLabel jl = new JLabel("mon label");
        JLabel jl2 = new JLabel("mon label2");

        JButton jbDO = new MesBoutons("DO");
        JButton jbRE = new MesBoutons("RE");
        JButton jbMI = new MesBoutons("MI");
        JButton jbFA = new MesBoutons("FA");
        JButton jbSOL = new MesBoutons("SOL");

        fen.addMouseListener(ecouteS);

        Container fenCont = fen.getContentPane();
        fenCont.setLayout(new BorderLayout());

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(1,5));
        jp.add(jbDO);
        jp.add(jbRE);
        jp.add(jbMI);
        jp.add(jbFA);
        jp.add(jbSOL);

        fenCont.add(jl, BorderLayout.NORTH);
        fenCont.add(jp, BorderLayout.CENTER);
        fenCont.add(jl2, BorderLayout.SOUTH);



        fen.setVisible(true);

    }

    static class MaFrame extends JFrame implements MouseListener, ActionListener {
        public MaFrame(){
            setSize(500,300);
            setTitle("voilà une fenêtre");
            addMouseListener(
                    new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int x = e.getX();
                            int y = e.getY();
                            System.out.println("click en " + x +","+  y);
                        }
                    }
            );

            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }
        public void mouseClicked(MouseEvent e){
            System.out.println("souris cliquée sur la fen");
        }
        public void mousePressed(MouseEvent e){
            System.out.println("souris pressee sur la fen");
        }
        public void mouseReleased(MouseEvent e){
            System.out.println("souris relachée sur la fen");
        }
        public void mouseEntered(MouseEvent e){
            this.getContentPane().setBackground(Color.pink);
        }
        public void mouseExited(MouseEvent e){
            this.getContentPane().setBackground(Color.green);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("bonton pressé eheheh");
        }
    }
}

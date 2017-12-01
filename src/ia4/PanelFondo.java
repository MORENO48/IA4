package ia4;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelFondo extends javax.swing.JPanel implements Runnable{
    int y = 5;
    Thread hilo;
    private JLabel lblNaveImg;
    private ImageIcon ImagenNave;
    
    public PanelFondo() {
        initComponents();
        hilo = new Thread(this);     
    }
    
    public void paint(Graphics g){
        ImagenNave = new ImageIcon( getClass().getResource("/Img/nave1.png"));     
       
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight()-20);
        
        Color cafecito = new Color(199, 150, 75);
        g.setColor(cafecito);
        g.fillRect(0, getHeight()-20, getWidth(),20 );
    
        //g.fillOval(x, getHeight()/2, 30, 30);
        g.drawImage( ImagenNave.getImage(), 165,y, 60, 60, null);
    }
    
    public void inicio(){
        hilo.start();
    }
    
    public void pause(){
        hilo.suspend();
    }
    
    public void continuar(){
        hilo.resume();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void run(){
        int Pf= getHeight()-75;
        double HI = 500;
        double H = 0;
        double Vo = 0;
        double G = 9.8;
        double T = 0;
        double unit = ((getHeight()-75)-y) / HI;
        try {
            while(true){
                while(y<getHeight()-75){
                    Thread.sleep(10);
                    T=T+0.2;
                    H = (Vo*T) + HI- ((0.5*G)*(Math.pow(T, 2)));
                    y = Pf-(int)(H*unit);
                    System.out.println(unit);
                    System.out.println("T= "+T+" H= "+H+" Y= "+y);
                    //y+=3;
                    repaint();
                }
                /*while(y>10){
                    Thread.sleep(25);
                    y-=3;
                    repaint();
                }*/
            }
            /*
                _FIS.setVariable("xcol", pathX);
                _FIS.setVariable("yfil", pathY);
                _FIS.evaluate();

                double objetivo = _FIS.getVariable("objetivo").getLatestDefuzzifiedValue();
                dialogoFIS.repaint();

                System.out.println("objetivo: " +objetivo);
                System.out.println(laberinto[pathY][pathX]);
                System.out.println("COL: "+pathX+" FIL: "+pathY);
            */
            
            
        } catch (Exception e) {
            System.out.println("Sucedio un error: "+e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

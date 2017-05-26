
package graficaothello;

import Box.EseguiMosse;
import Box.Casella;
import Box.ControlOthello;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.text.IconView;

@SuppressWarnings("serial")
public class GraficaOthello extends JPanel {
   private static final int PREF_W = 1750; //grandezza finestra
   private static final int PREF_H = 1550; //grandezza finestra
   private static final int GRID_ROWS = 8;
   private static final int GRID_COLS = 8;
   //JLabel img = new JLabel(new ImageIcon("me.jpeg"));
   ImageIcon img = new ImageIcon("n.jpg");
   
    public Casella [][]CampoDiGioco;
    public boolean [][]Mosse;
    ColorGridCell C[][]=new ColorGridCell[8][8];
    
    public GraficaOthello(EseguiMosse Ex) {
        CampoDiGioco = Ex.CampoDiGioco;
        Mosse=Ex.Mosse;
        JPanel gridPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int row = 0; row < GRID_ROWS; row++) {
           for (int col = 0; col < GRID_COLS; col++) {
                   //setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
                   //setBorder(BorderFactory.createLineBorder(Color.BLACK));
                   gridPanel.setBorder((Border) new CompoundBorder(new LineBorder(Color.black, 2), new EmptyBorder(2, 2, 2, 2)));
                   C[row][col]=new ColorGridCell(row, col,Ex);
                   gridPanel.add(C[row][col]);
            }
        }
        createAndShowGui(this);
        setLayout(new GridBagLayout()); // per centrare
        add(gridPanel);
    }
     

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void createAndShowGui(GraficaOthello mainPanel) {
      JFrame frame = new JFrame("Othello");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }
   
   
   public void Update (EseguiMosse Ex) {
        CampoDiGioco = Ex.CampoDiGioco;
        Mosse= Ex.Mosse;
        JPanel gridPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int row = 0; row < GRID_ROWS; row++) {
           for (int col = 0; col < GRID_COLS; col++) {
                   //setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
                   //setBorder(BorderFactory.createLineBorder(Color.BLACK));
                   gridPanel.setBorder((Border) new CompoundBorder(new LineBorder(Color.black, 2), new EmptyBorder(2, 2, 2, 2)));
                   gridPanel.add(new ColorGridCell(row, col,Ex));
            }
        }
        createAndShowGui(this);
        setLayout(new GridBagLayout()); // per centrare
        add(gridPanel);
    }
}

@SuppressWarnings("serial")
class ColorGridCell extends JPanel {
   private static final int PREF_W = 100;
   private static final int PREF_H = 100;
   private final static Color[] COLORS = {Color.green, Color.white, Color.black};
   private int row;
   private int col;
   protected Casella [][]CampoDiGioco;
   protected boolean [][]Mosse;

   public ColorGridCell(int row, int col,EseguiMosse Ex) {
        CampoDiGioco = Ex.CampoDiGioco;
        Mosse= Ex.Mosse;
        this.row = row;
        this.col = col;
        if(Ex.Mosse[row][col]==true){
           setBorder(BorderFactory.createLineBorder(Color.BLACK));
           setBackground(red);
        }else{
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            setBackground(CampoDiGioco[row][col].colore);
        }


      addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            if(Mosse[row][col]==true){
                Ex.eseguimossa(row, col, black);
                setBackground(CampoDiGioco[row][col].colore);
            }
         }
      });
   }
   

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public int getRow() {
      return row;
   }

   public int getCol() {
      return col;
   }
}
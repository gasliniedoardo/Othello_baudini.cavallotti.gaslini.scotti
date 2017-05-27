package othello;

import Box.ControlOthello;
import Box.EseguiMosse;
import View.view;
import graficaothello.GraficaOthello;
import java.awt.Color;
import static java.awt.Color.black;

public class Othello extends Thread{
    Color turno;
    public Othello(Color turno){
        this.turno=turno;
    }
    @Override
    public void run(){
        EseguiMosse b = new EseguiMosse();
        b.Mosse(turno);
        view v = new view(b.CampoDiGioco, b.Mosse);
        GraficaOthello G=new GraficaOthello(b);
        ControlOthello Ctrl=new ControlOthello(b,v,G);
    }
}
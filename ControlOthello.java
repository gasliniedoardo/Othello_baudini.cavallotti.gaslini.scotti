package Box;

import View.view;
import graficaothello.GraficaOthello;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlOthello implements ActionListener{
    int TOTW;
    int TOTB;
    EseguiMosse b;
    view v;
    GraficaOthello G;
    public ControlOthello(EseguiMosse b,view v,GraficaOthello G){
        this.b=b;
        this.v=v;
        this.G=G;

    }
        
    public void Conteggio(){
        TOTW=0;
        TOTB=0;
        for(int r=0;r<b.CampoDiGioco.length;r++){
            for(int c=0;c<b.CampoDiGioco.length;c++){
                if(b.CampoDiGioco[r][c].colore==black){
                   TOTB++;
                }else if(b.CampoDiGioco[r][c].colore==white){
                    TOTW++;
                }
            }
        }
        System.out.println("NERI: "+TOTB+" BIANCHI: "+TOTW);
    }
    public void Fine(){
        System.out.println("FINE GIOCO");
        System.out.println("NERI: "+TOTB+" BIANCHI: "+TOTW);
        if(TOTB<TOTW){
            System.out.println("HANNO VINTO I BIANCHI");
        }else if(TOTB>TOTW){
            System.out.println("HANNO VINTO I NERI");
        }else{System.out.println("PAREGGIO");}
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        b.Mosse(black);
        v.Stampa();
        b.MostraMosse();     
        v.Update(G.CampoDiGioco, G.Mosse);
        G.Update(b);

        Conteggio();
        if(b.finegioco()!=false){
            Fine();
        }
        b.azzera();
    }
}
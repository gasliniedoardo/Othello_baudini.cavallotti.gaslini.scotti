

package Box;

import java.awt.Color;

public class PossibiliMosse extends Box{
    
    public void Mosse(Color giocatore){
        for(int r=0;r<8;r++){
            for(int c=0;c<8;c++){
                if((CampoDiGioco[r][c].colore)==(giocatore)){
                    int Pos1=c;
                    MossaOrizzdx(r,c,Pos1, giocatore);
                    MossaOrizzsx(r,c,Pos1, giocatore);
                    int Pos2=r;
                    MossaVertUp(r,c,Pos2, giocatore);
                    MossaVertDown(r,c,Pos2, giocatore);
                    
                    MossaObldx1(r,c,Pos2,Pos1,giocatore);
                    MossaObldx2(r,c,Pos2,Pos1,giocatore);
                    MossaOblsx1(r,c,Pos2,Pos1,giocatore);
                    MossaOblsx2(r,c,Pos2,Pos1,giocatore);
                }
            }
        }
    }
    
    public void MostraMosse(){
        for(int r=0;r<8;r++){
            for(int c=0;c<8;c++){
                if(Mosse[r][c]==true){
                    System.out.println("Possibile mossa nella posizione "+"("+(1+r)+";"+(1+c)+")");
                }
            }
        }
    }
    private boolean MossaOrizzdx(int r, int c,int Pos, Color giocatore) {
        try{
            c++;
            if(CampoDiGioco[r][c].colore==(giocatore)){
                Mosse[r][c]=false;
                return false;
            }else if(CampoDiGioco[r][c].libera==false){
                    Mosse[r][c]=false;
                    MossaOrizzdx(r,c,Pos,giocatore);
                    return false;
            }else if(c==Pos+1){
                Mosse[r][c]=false;
                return false;
            }
            Mosse[r][c]=true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    
    private boolean MossaOrizzsx(int r, int c,int Pos, Color giocatore) {
        try{
            c--;
            if(CampoDiGioco[r][c].colore==(giocatore)){
                Mosse[r][c]=false;
                return false;
            }else if(CampoDiGioco[r][c].libera==false){
                    Mosse[r][c]=false;
                    MossaOrizzsx(r,c,Pos,giocatore);
                    return false;
            }else if(c==Pos-1){
                Mosse[r][c]=false;
                return false;
            }
            Mosse[r][c]=true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    
    private boolean MossaVertUp(int r, int c,int Pos, Color giocatore) {
        try{
            r++;
            if(CampoDiGioco[r][c].colore==(giocatore)){
                Mosse[r][c]=false;
                return false;
            }else if(CampoDiGioco[r][c].libera==false){
                    Mosse[r][c]=false;
                    MossaVertUp(r,c,Pos,giocatore);
                    return false;
            }else if(r==Pos+1){
                Mosse[r][c]=false;
                return false;
            }
            Mosse[r][c]=true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    
    private boolean MossaVertDown(int r, int c,int Pos, Color giocatore) {
        try{
            r--;
            if(CampoDiGioco[r][c].colore==(giocatore)){
                Mosse[r][c]=false;
                return false;
            }else if(CampoDiGioco[r][c].libera==false){
                    Mosse[r][c]=false;
                    MossaVertDown(r,c,Pos,giocatore);
                    return false;
            }else if(r==Pos-1){
                Mosse[r][c]=false;
                return false;
            }
            Mosse[r][c]=true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    } 
    
    //In basso a destra
    private boolean MossaObldx1(int r, int c,int Pos1, int Pos2,Color giocatore) {
        try{
            r++;
            c++;
            if(Mosse[r][c]==true){
                return false;
            }
            
            if(CampoDiGioco[r][c].colore==(giocatore)){
                Mosse[r][c]=false;
                return false;
            }else if(CampoDiGioco[r][c].libera==false){
                    Mosse[r][c]=false;
                    MossaObldx1(r,c,Pos1,Pos2,giocatore);
                    return false;
            }else if(r==Pos1+1 && c==Pos2+1){
                Mosse[r][c]=false;
                return false;
            }else if(Mosse[r][c]==true){
                return false;
            }
            Mosse[r][c]=true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    
    //In alto a destra
    private boolean MossaObldx2(int r, int c,int Pos1, int Pos2,Color giocatore) {
        try{
            r--;
            c++;
            if(Mosse[r][c]==true){
                return false;
            }
            
            if(CampoDiGioco[r][c].colore==(giocatore)){
                Mosse[r][c]=false;
                return false;
            }else if(CampoDiGioco[r][c].libera==false){
                    Mosse[r][c]=false;
                    MossaObldx2(r,c,Pos1,Pos2,giocatore);
                    return false;

            }else if(r==Pos1-1 && c==Pos2+1){
                Mosse[r][c]=false;
                return false;
            }else if(Mosse[r][c]==true){
                return false;
            }
            Mosse[r][c]=true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    
    //In basso a sinistra
    private boolean MossaOblsx2(int r, int c,int Pos1, int Pos2,Color giocatore) {
        try{
            r++;
            c--;
            if(Mosse[r][c]==true){
                return false;
            }
            
            if(CampoDiGioco[r][c].colore==(giocatore)){
                Mosse[r][c]=false;
                return false;
            }else if(CampoDiGioco[r][c].libera==false){
                    Mosse[r][c]=false;
                    MossaOblsx2(r,c,Pos1,Pos2,giocatore);
                    return false;

            }else if(r==Pos1+1 && c==Pos2-1){
                Mosse[r][c]=false;
                return false;
            }else if(Mosse[r][c]==true){
                return false;
            }
            Mosse[r][c]=true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    
    //In alto a sinistra
    private boolean MossaOblsx1(int r, int c,int Pos1, int Pos2,Color giocatore) {
        try{
            r--;
            c--;
            if(Mosse[r][c]==true){
                return false;
            }
            
            if(CampoDiGioco[r][c].colore==(giocatore)){
                Mosse[r][c]=false;
                return false;
            }else if(CampoDiGioco[r][c].libera==false){
                    Mosse[r][c]=false;
                    MossaOblsx1(r,c,Pos1,Pos2,giocatore);
                    return false;
            }else if(r==Pos1-1 && c==Pos2-1){
                Mosse[r][c]=false;
                return false;
            }
            Mosse[r][c]=true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    } 
}
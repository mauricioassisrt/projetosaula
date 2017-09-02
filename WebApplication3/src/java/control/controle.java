/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Seduc
 */
@ManagedBean
@SessionScoped
public class controle{
 
    private String ipcampo1,ipcampo2, ipcampo3, ipcampo4;
    private int mascara1,mascara2, mascara3, mascara4;
    List<String> lista = new ArrayList<>();
    
    public void metodo(){
        if(mascara4==128||mascara4==192||mascara4==224||mascara4==240||mascara4==248||mascara4==252||mascara4==254){
            if(mascara4==128){
                int varia =255;
                varia =varia -mascara4;
              
                for (int i = 0; i < varia; i++) {
                  
                        System.out.println("ip"+ipcampo1+"-"+ipcampo2+"-"+ipcampo3+"-"+i);
                        lista.add(String.valueOf(ipcampo1+ipcampo2+ipcampo3+i));
                       
                       
                    }
                 for (int i = 127; i < 254; i++) {
                  
                      
                         lista.add(String.valueOf(ipcampo1+ipcampo2+ipcampo3+i));
                         System.out.println("ip outros ip"+ipcampo1+"-"+ipcampo2+"-"+ipcampo3+"-"+i);
                    }
                    
                }
            
        }else{
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Erro ",  "Your message: " ) );
        }
    }

    public String getIpcampo1() {
        return ipcampo1;
    }

    public void setIpcampo1(String ipcampo1) {
        this.ipcampo1 = ipcampo1;
    }

    public String getIpcampo2() {
        return ipcampo2;
    }

    public void setIpcampo2(String ipcampo2) {
        this.ipcampo2 = ipcampo2;
    }

    public String getIpcampo3() {
        return ipcampo3;
    }

    public void setIpcampo3(String ipcampo3) {
        this.ipcampo3 = ipcampo3;
    }

    public String getIpcampo4() {
        return ipcampo4;
    }

    public void setIpcampo4(String ipcampo4) {
        this.ipcampo4 = ipcampo4;
    }
    
    
   
    public int getMascara1() {
        return mascara1;
    }

    public void setMascara1(int mascara1) {
        this.mascara1 = mascara1;
    }

    public int getMascara2() {
        return mascara2;
    }

    public void setMascara2(int mascara2) {
        this.mascara2 = mascara2;
    }

    public int getMascara3() {
        return mascara3;
    }

    public void setMascara3(int mascara3) {
        this.mascara3 = mascara3;
    }

    public int getMascara4() {
        return mascara4;
    }

    public void setMascara4(int mascara4) {
        this.mascara4 = mascara4;
    }
    
    
    

}

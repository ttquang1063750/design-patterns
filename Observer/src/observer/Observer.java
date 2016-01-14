/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;

/**
 *
 * @author GUMI-QUANG
 */
public class Observer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Stock s = new Stock();
      
      TA ta = new TA(s);
      DUC duc = new DUC(s);
      
      s.setvalue("thanh cong");
      
      s.notiFy();
      
      ta.unAttach();
      s.setvalue("delete TA");
      s.notiFy();
      
      
    }
    
}


interface ObserverObj{
    void update(String value);
}

interface SubjectObj{
    void attach(ObserverObj o);
    void unAttach(ObserverObj o);
    void notiFy();
}

class Stock implements SubjectObj{
    ArrayList<ObserverObj> _obj = new ArrayList<>();
    String value = "";
    
    @Override
    public void attach(ObserverObj o) {
        _obj.add(o);
    }

    @Override
    public void unAttach(ObserverObj o) {
        int i = _obj.indexOf(o);
        _obj.remove(i);
    }

    @Override
    public void notiFy() {
        for(ObserverObj o:_obj){
            o.update(this.value);
        }
    }
    public void setvalue(String value){
        this.value = value;
    }
}

class TA implements ObserverObj{
    SubjectObj s;
    public TA(SubjectObj s) {
        this.s = s;
        s.attach(this);
    }
    
    public void unAttach() {
        s.unAttach(this);
    }

    @Override
    public void update(String value) {
        System.out.println("observer.TA.update() "+value);
    }    
}

class DUC implements ObserverObj{
    SubjectObj s;
    public DUC(SubjectObj s) {
        this.s = s;
        s.attach(this);
    }
    
    public void unAttach() {
        s.unAttach(this);
    }

    @Override
    public void update(String value) {
        System.out.println("observer.DUC.update() "+value);
    }    
}
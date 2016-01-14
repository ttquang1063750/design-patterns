/*
* Mẫu chiến lược Strategy đã được giới thiệu trước đây, 
* giúp bạn xử lý những sự thay đổi bằng cách cho phép bạn chọn lựa một 
* thuật toán thích hợp từ một tập hợp thuật toán bên ngoài hơn là phải viết lại mã nguồn.
 */
package stategy;

/**
 * 
 *
 * @author GUMI-QUANG
 */
public class Stategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Boeing bo = new Boeing();
        bo.go(); //I am flying
        
        Wave wave = new Wave();
        wave.go(); //I am running
        
        wave.setGoAlGorithm(new Rocket());
        wave.go(); //I am Rocket
    }
    
}

interface ActionAlgorithm{
    void go();
}

class Moto implements ActionAlgorithm{

    @Override
    public void go() {
        System.out.println("I am running");
    } 
}

class Airplan implements ActionAlgorithm{

    @Override
    public void go() {
        System.out.println("I am flying");
    }
    
}

class Rocket implements ActionAlgorithm{

    @Override
    public void go() {
        System.out.println("I am Rocket");
    }
    
}

abstract class Vehicle{
    private ActionAlgorithm actionAlgorithm;
    public void setGoAlGorithm(ActionAlgorithm g){
        actionAlgorithm = g;
    }
    
    public void go(){
        actionAlgorithm.go();
    }
}

class Wave extends Vehicle{

    public Wave() {
        setGoAlGorithm(new Moto());
    }
}

class Boeing extends Vehicle{

    public Boeing() {
        setGoAlGorithm(new Airplan());
    }
    
}

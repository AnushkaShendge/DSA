import javax.print.attribute.standard.Destination;

public class towerOfHanoi {
    public static void TOH(int disk , String sor , String helper , String des){
        if(disk == 1){
            System.out.println("Tranfer disk " + disk + " from " +sor+ " to " +des);
        }
        else{
            TOH(disk - 1, sor, des, helper);
            System.out.println("Tranfer disk " +disk+ " from " +sor+ " to  " +des);
            TOH(disk-1, helper, sor, des);
        }
    }
    public static void main(String args[]){
    
        //steps = 2 ^ disk - 1 = 2 ^ 3 - 1 = 7  [O(2 ^ N)]
        TOH(3, "Root", "Helper", "Destination");
        
    }
    
}

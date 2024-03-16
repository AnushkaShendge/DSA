public class firstLastOcc{
    public static void Occarance(String s , char data){
        for(int i = 0 ; i < s.length() ; i++){
            if(data == s.charAt(i)){
                System.out.println("Index at which data has occorred first time is : " +i);
                break;
            }
        }
        for(int j = s.length() - 1 ; j >= 0 ; j--){
            if(data == s.charAt(j)){
                System.out.println("Index at which data has occorred last time is : " +j);
                break;
            }
        }

    }
    public static void main(String args[]){
        String s = "abaacdaefaah";
        Occarance(s, 'a');
    }
}
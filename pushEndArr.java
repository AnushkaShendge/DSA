public class pushEndArr {
    public static String pushEnd(String s , char ele){
        String ns = "";
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ele){
                count ++;
            }
            else{
                ns += s.charAt(i);
            }
        }
        for(int i = 0 ; i < count ; i++ ){
            ns += ele;
        }
        return ns;
    }
    public static void main(String args[]){
        String s = "axbxxcd";
        System.out.println("New String : " +pushEnd(s, 'x'));
    }
   
}

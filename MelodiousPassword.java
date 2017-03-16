import java.util.ArrayList;
import java.util.Scanner;

public class MelodiousPassword {
	static ArrayList<String> list=new ArrayList<String>();
	static ArrayList<String> newList=new ArrayList<String>();
    static char[] alphabet;
    static char[] vowel; 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] chars = "abcdefghijklmnopqrstuvwxz".toCharArray();
        vowel="aeiou".toCharArray();
        iterate(chars, n, new char[n], 0);
        isAlt(list);
        printHash(list);
    }
   
    public static void iterate(char[] chars, int len, char[] build, int pos) {
        if (pos == len) {
            String word = new String(build);
            // do what you need with each word here
            list.add(word);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            build[pos] = chars[i];
            iterate(chars, len, build, pos + 1);
        }
    }
    
    
    static boolean isVowel(char c){
        for(int i = 0;i<5;i++){
            if(c==vowel[i])
                return true;
        }
        return false;
    }
    
   /* static void printHash(HashSet<String> hs){
        Iterator<String> itr = hs.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
            }
    }*/
    
    static void printHash(ArrayList<String> list){
    	for(int i=0;i<list.size();i++){
    		System.out.println(list.get(i));
    	}
    }
    
    static void isAlt(ArrayList<String> list){
    	for(int index=0;index<list.size();index++){
    		String pass=list.get(index);
    		//System.out.println("in isAlt: "+pass);
    		boolean fault=false;
        if(isVowel(pass.charAt(0)))
            {
        	System.out.println("in if :"+ pass);
            for(int i=1;i<pass.length();i++){
                if(i%2==0){
                    if(!isVowel(pass.charAt(i))){
                    	list.remove(index);
                    	--index;
                    	//System.out.println("Removed :"+ pass);
                    	//fault=true;
                        break;
                    
                    }
                }
                else{
                    if(isVowel(pass.charAt(i)))
                    {
                    	list.remove(index);
                    	//fault=true;
                       -- index;
                    	break;
                        }
            }
                
            }
        }
        else{
            for(int i=1;i<pass.length();i++){
                if(i%2==0){
                    if(isVowel(pass.charAt(i)))
                    {
                       list.remove(index);
                    	//fault=true;
                      -- index;
                       break;
                        }
                }
                    
                else{
                    if(!isVowel(pass.charAt(i)))
                    {
                    	list.remove(index);
                    	
                    	--index;
                    	//fault=true;
                        break;
                        }
            }
                }
        }
        //if(!fault)
        //newList.add(pass);
       
    }
    }
}

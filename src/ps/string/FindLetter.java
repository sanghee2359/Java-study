package ps.string;

import java.util.Scanner;


public class FindLetter {
    public int Find(String str, char let) {
        int answer = 0;
        str = str.toUpperCase();
        let = Character.toUpperCase(let);
        for(char x : str.toCharArray()){
            if(x == let) answer++;
        }
//        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args){
        FindLetter O = new FindLetter();
        Scanner in=new Scanner(System.in);
        String str = in.next();
        char let = in.next().charAt(0);

        System.out.println(O.Find(str,let));
        return ;
    }
}
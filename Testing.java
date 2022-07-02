package BackTracking;

import java.util.*;

public class Testing {
    public static void main(String[] args) {
//        double value=12.667890;
//
//        double newValue=Math.round(value*100.0)/100.0;
//
//
       int arr[]=new int[3];

       System.out.println(removeInvalidParentheses("(a)())()"));
     //nice
    }
    static boolean match(char close,char open){

        if(close== ')'&& open =='(')
            return true;

        return false;
    }
    public static boolean isValid(String s) {


        Stack<Character> s1=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(c>='a' && c<='z')
                continue;


            if(c=='(' ){
                s1.push(c);
            }
            else{
                if(s1.isEmpty())
                    return false;
                if(match(c,s1.peek()))
                    s1.pop();
                else
                    return false;
            }
        }
        if(!s1.isEmpty())
            return false;
        return true;
    }

    static int getRemove(String s){

        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(c=='(')
                st.push(c);
            else if(c==')'){
                if(st.isEmpty() || st.peek()==')')
                    st.push(c);
                else
                    st.pop();
            }

        }

        return st.size();

    }


    public static List<String> removeInvalidParentheses(String s) {

        int remove=getRemove(s);

        List<String> ans=new ArrayList<>();
        System.out.println(remove);
        solve(s,ans,remove,"",new HashSet<>());

        return ans;
    }


    static void solve(String s,List<String> ans,int rem,String temp,HashSet<String> hs){

        if(rem==0 && 0==s.length()){
            if( isValid(temp) && !hs.contains(temp)){
                ans.add(temp);
                hs.add(temp);
            }
            return;
        }


        if(0==s.length() || rem<0 )
            return;

        if(s.charAt(0)!='(' && s.charAt(0)!=')'){
            solve(s.substring(1),ans,rem,temp+s.charAt(0),hs);

        }else{
            solve(s.substring(1),ans,rem,temp+s.charAt(0),hs);
            solve(s.substring(1),ans,rem-1,temp,hs);
        }

    }



}

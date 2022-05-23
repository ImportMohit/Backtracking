package BackTracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations2coinRespect {
    public static void main(String[] args) {
        //non-infinite coins
        //duplicate coins
        int coin[]={1,2,2,2,5};
        int amount=5;
        Arrays.sort(coin);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        solve(coin,amount,0,ans,temp,false);

    }


    private static void solve(int[] coin, int amount, int idx, List<List<Integer>> ans, List<Integer> temp,boolean flag) {

        if(amount==0){
            ans.add(new ArrayList<>(temp));
            System.out.println(temp);
            return;
        }


        if(amount<0 || idx==coin.length)
            return;





        if(idx>0  &&  coin[idx]==coin[idx-1] && flag==false ){
            //only exclude
            solve(coin, amount, idx + 1, ans, temp,false);
        }
        else{
            //both include and exclude
            temp.add(coin[idx]);
            solve(coin, amount - coin[idx], idx + 1, ans, temp,true);
            temp.remove(temp.size() - 1);

            solve(coin, amount, idx + 1, ans, temp,false);
        }

    }

}

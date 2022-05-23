package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations1CoinRespect {
    public static void main(String[] args) {

        //infinite coins
        //unique coins
        int coin[]={2,3,6,7};
        int amount=7;

        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        solve(coin,amount,0,ans,temp);

    }

    private static void solve(int[] coin, int amount, int idx, List<List<Integer>> ans, List<Integer> temp) {

        if(amount==0){
            ans.add(new ArrayList<>(temp));
            System.out.println(temp);
            return;
        }


        if(amount<0 || idx== coin.length)
            return;





            temp.add(coin[idx]);
            solve(coin,amount-coin[idx],idx,ans,temp);
            temp.remove(temp.size()-1);


            solve(coin,amount,idx+1,ans,temp);



    }

}

package BackTracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations2userRespect {
    public static void main(String[] args) {
        //non-infinite coins
        //duplicate coins
        int coin[]={2,2,2,4};
        int amount=6;
     Arrays.sort(coin);
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


        if(amount<0)
            return;



        for(int i=idx;i<coin.length;i++){

            if(i>idx &&  coin[i]==coin[i-1])
                continue;

            temp.add(coin[i]);
            solve(coin,amount-coin[i],i+1,ans,temp);
            temp.remove(temp.size()-1);

        }


    }

}

package leetcode;

import java.util.ArrayList;

public class MinSessions {
    public int minSessions(int[] tasks, int sessionTime) {

        boolean visited[] = new boolean[tasks.length];
        for(int i=0;i<tasks.length;i++)
            visited[i] = false;

        int completed = 0, total = tasks.length, ans = 0;
        while(completed < total) {

            int closestSum = Integer.MIN_VALUE;
            ArrayList<Integer> closestSet = null;
            //find Tasks that can be completed within sessionTime
            int sum = 0;
            for(int i = (1<<total)-1; i>0; i--){
                sum = 0;
                ArrayList<Integer> selected = new ArrayList();
                for(int j = 0;j< total;j++){
                    if(((i>>j)&1)==1 && !visited[j] && sum+tasks[j]<=sessionTime){
                        sum+= tasks[j];
                        selected.add(j);
                    }
                }
                if(sum>closestSum) {
                    closestSum = sum;
                    closestSet = selected;
                }
            }
            for(Integer ind: closestSet) {
                visited[ind] = true;
                completed++;
            }
            System.out.println(closestSet);
            System.out.println(closestSum);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinSessions obj = new MinSessions();
//        System.out.println(obj.minSessions(new int[]{1,2,3,4,5}, 15));
//        System.out.println(obj.minSessions(new int[]{1}, 1));
        System.out.println(obj.minSessions(new int[]{2,3,3,4,4,4,5,6,7,10}, 12));
    }
}

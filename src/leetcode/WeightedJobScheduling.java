package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

//https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/409009/JavaC%2B%2BPython-DP-Solution
//https://www.youtube.com/watch?v=cr6Ip0J9izc
public class WeightedJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int numberOfJobs = startTime.length;
        int[][] jobs = new int[numberOfJobs][3];
        for (int i=0;i<numberOfJobs;i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[1]));
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for(int[] job : jobs) {
            int profitPossibleByDoingThisJob = dp.floorEntry(job[0]).getValue() + job[2];
            int currentMaxProfit = dp.lastEntry().getValue();
            if (profitPossibleByDoingThisJob > currentMaxProfit) {
                dp.put(job[1], profitPossibleByDoingThisJob);
            }
        }
        return dp.lastEntry().getValue();
    }

    class Job implements Comparable<Job>{
        int start;
        int end;
        int profit;
        public Job(int s, int e, int p){
            start = s;
            end = e;
            profit = p;
        }
        public int compareTo(Job other){
            return this.end - other.end;
        }
    }
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int num = startTime.length;
        if(num==0)
            return 0;
        int[] ans =  new int[num];
        Job[] jobs = new Job[num];
        for(int i=0;i<num;i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            ans[i] = 0;
        }
        Arrays.sort(jobs);
        int i,j;
        ans[0] = jobs[0].profit;
        int ret = Integer.MIN_VALUE;
        for(i=1;i<num;i++){
            ans[i] = Math.max(jobs[i].profit, ans[i-1]);
            for(j=i-1;j>=0;j--){
                if(jobs[i].start >= jobs[j].end){
                    ans[i] = Math.max(ans[i], ans[j] + jobs[i].profit);
                    ret = Math.max(ret, ans[i]);
                    break;
                }
            }
            ret = Math.max(ret, ans[i]);
        }
        return ret;
    }
}

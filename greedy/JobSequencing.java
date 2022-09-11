package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class JobSequencing {
	public static void main(String[] args) {
		int[] deadline = { 2, 1, 2, 1, 3 };
		int[] profit = { 100, 19, 27, 25, 15 };

		findJoBSequencing(deadline, profit,3);
	}

	private static void findJoBSequencing(int[] deadline, int[] profit, int js) {
		ArrayList<Job> l = new ArrayList<Job>();
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for (int i = 0; i < deadline.length; i++) {
			Job j = new Job(deadline[i], profit[i], i);
			l.add(j);
		}
		Collections.sort(l, Comparator.comparing(Job::getProfit).reversed());
		 l.forEach(job->{
			 if(hm.size()==js) return;
			 int jobKey=job.deadline;
			while(hm.get(jobKey)!=null && jobKey!=0) {
				jobKey--;
			}
			if(jobKey!=0)hm.put(jobKey, job.profit);
		 });
		
        hm.entrySet().forEach(x->System.out.println(x.getKey()+","+x.getValue()));
	}

}

class Job {
	int deadline;
	int profit;
	int id;

	Job(int deadline, int profit, int id) {
		this.deadline = deadline;
		this.id = id;
		this.profit = profit;

	}

	public int getProfit() {
		return this.profit;
	}

}

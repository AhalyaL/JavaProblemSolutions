package Intervals;

public class MeeintgRoom {

	public static void main(String[] args) {
		
		int[][] schedule = {{0,30},{5,10},{15,20}};
		
		boolean b=checkSchedule(schedule);
		System.out.println(b);
	}

	private static boolean checkSchedule(int[][] schedule) {
		
		for(int i=0;i<schedule.length-1;i++) {
			
			if(schedule[i][1]>schedule[i+1][0]) {
				return false;
			}
			
			
		}
		return true;
		
	}
	
}

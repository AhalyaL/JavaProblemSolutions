package greedy;

import java.util.List;

public class Node {
	public int val;
	public int weight;
//	public int prevWeight=0;

	public Node(int val, int weight) {
		this.val = val;
		this.weight = weight;

	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

//	public int getPrevWeight() {
//		return prevWeight;
//	}
//
//	public void setPrevWeight(int prevWeight) {
//		this.prevWeight = prevWeight;
//	}
	
	
}

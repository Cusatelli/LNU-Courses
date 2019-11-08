package assignment_2.exercise_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PossibleRolls {
	
	public boolean yahtzee(ArrayList<Integer> list) {
		boolean yahtzee = false;
		for (int i = 1; i <= 6; i++) {
			int outcome = Collections.frequency(list, i);

			if (outcome == 5) {
				yahtzee = true;
				outcome = 0; // Reset since it causes problems...
				break;
			}
		}
		return yahtzee;
	}
	
	public boolean fourOfAKind(ArrayList<Integer> list) {
		boolean foak = false;
		for (int i = 1; i <= 6; i++) {
			int outcome = Collections.frequency(list, i);

			if (outcome == 4) {
				foak = true;
				outcome = 0; // Reset since it causes problems...
				break;
			}
		}
		return foak;
	}
	
	public boolean threeOfAKind(ArrayList<Integer> list) {
		boolean toak = false;
		for (int i = 1; i <= 6; i++) {
			int outcome = Collections.frequency(list, i);
			
			if (outcome == 3) {
				toak = true;
				outcome = 0; // Reset since it causes problems...
				break;
			}
		}
		return toak;
	}
	
	public boolean fullHouse(ArrayList<Integer> list) {
        boolean twos = false;
        boolean threes = false;
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int outcome = Collections.frequency(list, list.get(i));
            
            if (outcome == 3) {
                threes = true;
                list2 = removeAllX(list, list.get(i));
				outcome = 0; // Reset since it causes problems...
                break;
            }
        }

        if (twos == true) {
            if (list2.get(0) == list2.get(1)) {
            	threes = true;
            }
        }
        
        if (twos == true && threes == true) {
            return true;
        
        } else {
            return false;
        }
	}
	
	public ArrayList<Integer> removeAllX(ArrayList<Integer> list, int x) {
		ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            
        	if (list.get(i) != x) {
                list2.add(list.get(i));
            }
        }
        return list2;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean smallStraight(ArrayList<Integer> list) {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2,3,4,5));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3,4,5,6));
        
        if (list.contains(list1) || list.contains(list2) || list.contains(list3)) {
            return true;
        
        } else {
            return false;
        }
	}
	@SuppressWarnings("unlikely-arg-type")
	public boolean largeStraight(ArrayList<Integer> list) {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2,3,4,5,6));
        
        if (list.contains(list1) || list.contains(list2)) {
            return true;
        
        } else {
            return false;
        }
	}
	public boolean pair(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
            int outcome = Collections.frequency(list, list.get(i));
            
            if (outcome == 2) {
                return true;
            }
        }
        return false;	
	}
}

/* Spoj #ad-hoc 1
	Java Solution for: MMASS
	@author: Ayush Bhatnagar*/

import java.util.*;
public class Mmass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack <Integer> stk = new Stack <> ();
		int bmass = 0;
		for(int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if(x == '(')
				stk.push(-1);
			else if(x == ')') {
				bmass = 0;
				while(!stk.empty() && stk.peek() != -1) {
					bmass += stk.pop();
				}
				if(!stk.empty())
					stk.pop();
				if(i + 1 < str.length() && str.charAt(i + 1) >= '2' && str.charAt(i + 1) <= '9') {
					bmass *= str.charAt(i + 1) - 48;
					i++;
				}
				stk.push(bmass);
			}
			else if(x == 'C' || x == 'H' || x == 'O') {
				int num = 1;
				if(i + 1 < str.length() && str.charAt(i + 1) >= '2' && str.charAt(i + 1) <= '9') {
					num = str.charAt(i + 1) - 48;
					i++;
				}
				if(x == 'C')
					stk.push(12 * num);
				else if(x == 'H')
					stk.push(num);
				else
					stk.push(16 * num);
			}
		}
		bmass = 0;
		while(!stk.empty()) {
			bmass += stk.pop();
		}
		System.out.println(bmass);
		sc.close();
	}
}

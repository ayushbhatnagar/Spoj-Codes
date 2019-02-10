/* Spoj # stack
	Java Solution for: ONP
	@author: Ayush Bhatnagar*/

import java.util.*;
public class Onp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- > 0) {
			String str = sc.nextLine();
			Stack <Character> stk = new Stack <> ();
			for(int  i = 0; i < str.length(); i++) {
				char x = str.charAt(i);
				if(x == '+' || x == '-' || x == '*' || x == '/' || x == '^')
					stk.push(x);
				else if(x != '(') {
					if(x == ')') {
						System.out.print(stk.peek());
						stk.pop();
					}
					else
						System.out.print(x);
				}
			}
			while(!stk.empty()) {
				System.out.print(stk.peek());
				stk.pop();
			}
			System.out.println();
		}
	}
}

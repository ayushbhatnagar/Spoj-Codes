/* Spoj # stack #ad-hoc 1
	Java Solution for: STPAR
	@author: Ayush Bhatnagar*/

import java.util.*;
public class Stpar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n == 0)
				break;
			else {
				int i = 0, z = 1;
				int a[] = new int[n];
				for(i = 0; i < n; i++) 
					a[i] = sc.nextInt();
				Stack <Integer> stk = new Stack <>();
				i = 0;
				while(i < n) {
					if(a[i] == z) {
						while(!stk.empty() && stk.peek() == z + 1) {
							stk.pop();
							z++;
						}
						z++;
						i++;
					}
					else {
						stk.push(a[i++]);
					}
				}
				while(!stk.empty()) {
					if(z == stk.peek()) {
						z++;
						stk.pop();
					}
					else
						break;
				}
				if(stk.empty())
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}
}


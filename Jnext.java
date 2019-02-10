/* Spoj #ad-hoc 1
	Java Solution for: JNEXT
	@author: Ayush Bhatnagar*/

import java.util.*;
import java.lang.*;

public class Jnext {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			int i;
			for (i = 0; i < n; i++)
				a[i] = sc.nextInt();
			Stack <Integer> s = new Stack <>();
			i = n - 1;
			while(a[i - 1] >= a[i] && i >= 1) {
				s.push(a[i]);
				i--;
			}
			s.push(a[i]);
			if(i == 0)
				System.out.println(-1);
			else {
				i--;
				int min = i + 1;
				for(int j = i + 1; j < n; j++) {
					if(a[j] < a[min] && a[i] < a[j])
						min = j;
				}
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
				int j = n - 1;
				while(!s.empty()) {
					int top = s.pop();
					int peek = 0;
					if(!s.empty())
					    peek = s.peek();
					if(top != a[i] || top == peek)
						a[j] = top;
					else {
						a[j] = temp;
					}
					j--;
				}
				for(i = 0; i < n; i++)
					System.out.print(a[i]);
				System.out.println();
			}
		}
	}
}
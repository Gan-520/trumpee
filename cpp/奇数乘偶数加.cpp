#include<iostream>
using namespace std;

int main(){
	int n,result;
	char flag;
	do{
		cin >> n;
		if(n % 2 == 0){
			result = 0;
			for(int i = 2;i <= n;i+=2){
				result += i;
			}
		}
		else{
			result = 1;
			for(int i = 1;i <=n;i+=2){
				result *= i;
			}
		}
		cout << result << endl;
		cout << "Continue Or Not(Y/y is yes,N/n is no)";
		cin >> flag;
	}while(flag == 'Y' || 'y');
	
} 

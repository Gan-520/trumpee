#include<iostream>
#include <iomanip>
using namespace std;

int factorial(int n){
	int result = 1;
	for(int i = 1;i <= n;i++){
		result *= i;
	}
	return result;
}

int main(){
	int n;
	cout <<  "Enter the value of n:";
	cin >> n;
	cout << "integer" << setw(10) << "factorial" << endl;
	for(int i = 1;i <=5;i++){
		cout <<setw(5)  << i << setw(10) <<factorial(i)<<endl;
	}
	 
} 

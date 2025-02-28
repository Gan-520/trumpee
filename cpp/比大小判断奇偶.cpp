#include<iostream>
using namespace std;

void EorO(int n,int m){
	if(n % 2 == 0) cout << "number " << m << "is ODD" << endl;
	else cout << "number " << m << "is EVEN" << endl;
}

int main(){
	int num1,num2;
	cout << "Welcome!" << endl;
	cout << "Enter number 1:";
	cin >> num1;
	cout << "Enter number 2:";
	cin >> num2;
	if(num1 > num2) cout << "number 1 is greater than number 2" <<endl;
	else cout << "number 2 is greater than number 1" <<endl;
	
	EorO(num1,1);
	EorO(num2,2);
} 

#include<iostream>
using namespace std;

int main(){
	cout << "Please enter two numbers" << endl;
	double num1,num2;
	cin >> num1 >> num2;
	cout << "Please make a selection:\n1)Addition\n2)Subtraction\n3)Multiplication\n4)Division" << endl;
	int n;
	cin >> n;
	switch(n){
		case 1:
			cout << "Addition:"<< num1 + num2 <<endl;
			break;
		case 2:
			cout << "Subtraction:" << num1 - num2 <<endl;
			break;
		case 3:
			cout << "Multiplication:" << num1 * num2 << endl;
			break;
		case 4:
			cout << "Division:" << num1 / num2 << endl;
			break;	
	}
	if(num1 > num2) cout << num1 << "is greater.";
	else cout << num2 << "is greater."; 
} 

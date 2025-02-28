#include<iostream>
using namespace std;

int main(){
	double money1,money2,RMB,sum;
	char flag;
	cout << "Welcome!" << endl;
	do{
		cout << "Enter first amount: ¡ê";
		cin >> money1;
		cout << "Enter second amount: ¡ê";
		cin >> money2;
		sum = money1 + money2;
		cout << "Total amount: ¡ê" << sum << endl;
		RMB = sum * 9.5;
		cout << "Amount in RMB: RMB." << RMB << endl;
		cout << "Do you wish to continue (y or Y/n or N)?";
		cin >> flag;
	}while(flag == 'y' || 'Y');
	cout << "Thank you for using the system!";
} 

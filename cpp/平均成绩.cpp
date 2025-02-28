#include<iostream>
using namespace std;

int main(){
	double sum,marks,n = 10;
	cout << "Welcome" << endl;
	while(n--){
		cout << "Enter marks:";
		cin >> marks;
		sum += marks;
	}
	cout << "Class Average is:" << sum / 10;
} 

#include<iostream>
using namespace std;

int main(){
	cout << "Enter temprature in Fahrenheit: ";
	double FahTemp,CelTemp;
	cin >> FahTemp;
	CelTemp = (FahTemp - 32)/1.8;
	cout << "In Celsius that's: " << CelTemp << endl;
} 

#include<iostream>
using namespace std;

int main(){
	int flag;
	while(1){
		cin >> flag;
		switch(flag){
			case 100:
				cout << "normal speed range" <<endl;
				break;
			case 101:
				cout << "over-speed warning" << endl;
				break;
			case 88:
				cout << "Low Oil Pressure" << endl;
				break;
			case 187:
				cout << "Engine Failure" <<endl;
				break;
		}
	}	
} 

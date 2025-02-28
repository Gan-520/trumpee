#include<iostream>
using namespace std;

int main(){
	cout << "Do you want to draw the pattern or quit?\nY (or y) - yes\nQ (or q) - Quit\n" << endl;
	char anwser;
	while(1){
		cin >> anwser; 
		if(anwser == 'Y' || anwser == 'y'){
			for(int i = 0;i < 8;i++){
				for(int j = 0;j < 9;j++){
					if(i % 2 == 0){
						cout << "* ";	
					}
					else cout << " *"; 
				}
				cout << "\n"; 
			}		
		}
		else if(anwser == 'Q' || anwser == 'q'){
			break;
		}
		else cout << "Input not recognized.Program will not exit\nPress any key to continue\n";
	}
}

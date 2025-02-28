#include<iostream>
using namespace std;

int main(){
	cout << "Welcome!\nEnter your balance: ";
	int balance;
	cin >> balance;
	cout << "----------------------------------" <<endl;
	cout << "Select an option:\n1.Withdraw Amount\n2.Deposit Amount\n3.Exit"  << endl;
	cout << "----------------------------------" <<endl;
	int n;
	bool flag = true;
	while(flag){
		cin >> n;
		switch(n){
			case 1:
				cout << "How much amount you want to withdraw from your account?" << endl;
				cout << "Amount:";
				int withdraw;
				cin >> withdraw;
				if(withdraw > balance) {
					cout << "Sorry,the your balance is not enough!" <<endl;
					break;
				}
				else{
					balance = balance - withdraw;
					cout << "Your new balance is:" << balance << endl;
					break;
				} 	
			case 2:
				cout << "How much amount you want to deposit in your account?" << endl;
				cout << "Amount:";
				int deposit;
				cin >> deposit;
				balance +=deposit;
				cout << "Your new balance is:" << balance << endl;
				break;
			case 3:
				cout << "Thank you for using the system!" << endl;
				flag = false; 
				break; 
		}
	}
	
} 

#include<iostream>
using namespace std;

int main(){
	int n1,n2;
	char operate;
	while(1){
		cout << "�������һ����������"; 
		cin >> n1;
		cout << "�������������" ;
		cin >> operate;
		if(operate != '+'&& operate != '-' && operate != '*' && operate !='/'){
			cout << "����������������" << endl; 
			continue; 
		} 
		cout << "������ڶ�����������";
		cin >> n2;
		switch(operate){
		case '+':
			cout << "���ǣ�" << static_cast<long long>(n1) + static_cast<long long>(n2) << endl;
			break;
		case '-':
			cout << "���ǣ�" << static_cast<long long>(n1) - static_cast<long long>(n2) << endl;
			break;
		case '*':
			cout << "���ǣ�" << static_cast<long long>(n1) * static_cast<long long>(n2) << endl;
			break;
		case '/':
			cout << "���ǣ�" << static_cast<long long>(n1) / static_cast<long long>(n2) << endl;
			break;
		}
	}
}

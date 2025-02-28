#include<iostream>
using namespace std;

int main(){
	int n1,n2;
	char operate;
	while(1){
		cout << "请输入第一个操作数："; 
		cin >> n1;
		cout << "请输入操作符：" ;
		cin >> operate;
		if(operate != '+'&& operate != '-' && operate != '*' && operate !='/'){
			cout << "输入有误，重新输入" << endl; 
			continue; 
		} 
		cout << "请输入第二个操作数：";
		cin >> n2;
		switch(operate){
		case '+':
			cout << "答案是：" << static_cast<long long>(n1) + static_cast<long long>(n2) << endl;
			break;
		case '-':
			cout << "答案是：" << static_cast<long long>(n1) - static_cast<long long>(n2) << endl;
			break;
		case '*':
			cout << "答案是：" << static_cast<long long>(n1) * static_cast<long long>(n2) << endl;
			break;
		case '/':
			cout << "答案是：" << static_cast<long long>(n1) / static_cast<long long>(n2) << endl;
			break;
		}
	}
}

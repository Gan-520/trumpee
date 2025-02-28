#include<iostream>
using namespace std;

const int validPins[] = {1234,2345,3456,4567,5678};
const int MAX_ATTEMPTS = 4;

bool validatePin(int inputPin){
	for(int i = 0;i < 5;++i){
		if(inputPin == validPins[i]){
			return true;
		}
	}
	return false;
}

int main(){
	int attempts = 0;
	int inputPin;
	while (attempts < MAX_ATTEMPTS){
		cout << "���������PIN�룺";
		cin >> inputPin;
		if(validatePin(inputPin)){
			cout << "��֤ͨ��" << endl;
			cout << "��ӭ!!!!!" << endl;
			return 0;
		}
		else{
			attempts++;
			cout << "PIN�����������һ�Σ�����ʣ" << MAX_ATTEMPTS - attempts <<"�γ��Ի���" << endl;	
		} 
	}
	cout << "���ƹ���" << endl;
	return 0;
}


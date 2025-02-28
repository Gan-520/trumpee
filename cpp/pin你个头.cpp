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
		cout << "请输入你的PIN码：";
		cin >> inputPin;
		if(validatePin(inputPin)){
			cout << "验证通过" << endl;
			cout << "欢迎!!!!!" << endl;
			return 0;
		}
		else{
			attempts++;
			cout << "PIN码错误，请再试一次，您还剩" << MAX_ATTEMPTS - attempts <<"次尝试机会" << endl;	
		} 
	}
	cout << "限制过期" << endl;
	return 0;
}


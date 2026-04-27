#include <iostream>
using namespace std;

class Player {
public:
	int pay;
	string name;
	Player();
};

Player::Player() {
	pay = 0;
	name = "";
}

Player newSigning() {
	int n;
	cin >> n;

	Player good;

	for (int i = 0; i < n; i++) {
		long Pay;
		string Name;

		cin >> Pay >> Name;

		if (Pay > good.pay) {
			good.name = Name;
			good.pay = Pay;
		}
	}
	return good;
}

int main() {
	int testCase;

	cin >> testCase;
	for (int i = 0; i < testCase; i++) {
		Player good = newSigning();
		cout << good.name << endl;
	}
}
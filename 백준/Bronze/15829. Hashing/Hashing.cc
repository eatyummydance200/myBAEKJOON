#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {
	long long mod_31[50];
	long long a = 1;

	for (int i = 0; i < 50; i++) {
		mod_31[i] = a;
		a *= 31;
		a %= 1234567891;
	}

	int l;
	string input;
	long long result = 0;

	cin >> l;
	cin >> input;

	for (int i = 0; i < l; i++) {
		int a = input[i] - 'a' + 1;
		result += (a * mod_31[i]) % 1234567891;
	}
	result %= 1234567891;
	cout << result;
	return 0;
}
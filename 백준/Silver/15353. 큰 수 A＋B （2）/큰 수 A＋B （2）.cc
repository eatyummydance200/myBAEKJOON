#include <iostream>
#include <string>
using namespace std;

int main() {
	string n1, n2;
	string result;

	cin >> n1 >> n2;

	int n1_len = n1.length();
	int n2_len = n2.length();

	if (n1_len > n2_len) {
		for (int i = 0; i < n1_len - n2_len; i++)
			n2.insert(0, "0");
		n2_len = n1_len;
	}
	else {
		for (int i = 0; i < n2_len - n1_len; i++)
			n1.insert(0, "0");
		n1_len = n2_len;
	}
	result = n1;

	bool carry = false;
	for (int i = n1_len-1; i >= 0; i--) {
		int temp = (n1.at(i) - '0') + (n2.at(i) - '0');

		if (carry) {
			temp += 1;
			carry = false;
		}

		if (temp >= 10) {
			carry = true;
			temp -= 10;
		}
		result[i] = (char)(temp + '0');
	}
	if (carry) {
		result.insert(0, "1");
	}
	while (true) {
		if (result.front() == '0') {
			result.erase(0, 1);
		}
		else
			break;
	}

	cout << result;
	
	return 0;
}
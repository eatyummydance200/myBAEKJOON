#include <iostream>
#include <string>
using namespace std;

int main() {
	int a, b, c;
	cin >> a >> b >> c;

	int result1, result2;
	
	result1 = a + b - c;

	result2 = stoi(to_string(a) + to_string(b)) - c;

	cout << result1 << endl << result2;
	return 0;
}
#include <iostream>
using namespace std;

int main() {
	int a, b;
	cin >> a >> b;

	int i = a;
	int j = b;
	while (j != 0) {
		int temp = i % j;
		i = j;
		j = temp;
	}
	cout << i << endl;
	cout << a * b / i;

	return 0;
}
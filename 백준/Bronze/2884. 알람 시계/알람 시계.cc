#include <iostream>
using namespace std;

int main() {
	int h, m;
	cin >> h >> m;

	if (m >= 45) m -= 45;
	else {
		m += 15;
		if (h >= 1) h -= 1;
		else h = 23;
	}
	cout << h << endl << m;
	return 0;
}
#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n, t, p;
	vector<int> size(6);
	cin >> n;
	for (int& i : size) cin >> i;
	cin >> t >> p;

	int t_result = 0;
	for (int& i : size) {
		t_result += i / t;
		t_result += (i % t) ? 1 : 0;
	}

	cout << t_result << endl;
	cout << (int)(n / p) << ' ' << n % p;

	return 0;
}
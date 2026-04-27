#include <iostream>
using namespace std;

int main() {
	int m, n;
	int sum=0, min=99999;

	cin >> m;
	cin >> n;

	int i = 1;
	while (true) {
		int sq = i * i;
		if (sq > n) break;
		if (m <= sq && sq <= n) {
			sum += sq;
			if (sq < min)
				min = sq;
		}
		i++;
	}
	if (sum <= 0) cout << "-1";
	else
		cout << sum << endl << min;

}
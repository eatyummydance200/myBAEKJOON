#include <iostream>
using namespace std;

class DOB {
public:
	int dd, mm, yyyy;
	string name;
};

int main() {
	int t;
	cin >> t;

	DOB old, young;

	for (int i = 0; i < t; i++) {
		DOB man;

		cin >> man.name >> man.dd >> man.mm >> man.yyyy;

		if (i == 0) {
			old = man;
			young = man;
		}
		else {
			//old
			if (old.yyyy > man.yyyy)
				old = man;
			else if (old.yyyy == man.yyyy) {
				if (old.mm > man.mm)
					old = man;
				else if (old.mm == man.mm)
					if (old.dd > man.dd)
						old = man;
			}
			//young
			if (young.yyyy < man.yyyy)
				young = man;
			else if (young.yyyy == man.yyyy) {
				if (young.mm < man.mm)
					young = man;
				else if (young.mm == man.mm)
					if (young.dd < man.dd)
						young = man;
			}
		}
	}

	cout << young.name << endl << old.name;
}
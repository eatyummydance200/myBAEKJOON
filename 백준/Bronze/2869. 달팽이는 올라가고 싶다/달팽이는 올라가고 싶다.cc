#include <iostream>
using namespace std;

int main(){
    int a, b, v;
    cin >> a >> b >> v;
    
    int gap = a - b;
    cout << (v-a) / gap + 1 + !!((v-a) % gap);
    return 0;
}
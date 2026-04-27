#include <iostream>
using namespace std;

class Stack {
	int* mem;
	int top;
	int size;
	int capacity;
public:
	Stack(int c = 100) {
		top = -1;
		capacity = c;
		size = 0;
		mem = new int[c];
	}
	~Stack() {
		delete[]mem;
	}
	void push(int n);
	int pop();
	int get_size() { return size; }
	int is_empty() { return (size <= 0); }
	int get_top();
};

void Stack::push(int n){
	if (top < capacity - 1) {
		mem[++top] = n;
		size++;
	}
}

int Stack::pop(){
	if (!is_empty()){
		size--;
		return mem[top--];
	}
	else
		return -1;
}

int Stack::get_top() {
	if (!is_empty())
		return mem[top];
	else
		return -1;
}

int main() {
	int instruction_list;
	cin >> instruction_list;

	Stack s(instruction_list);

	for (int i = 0;i < instruction_list; i++) {
		string instruction;
		cin >> instruction;

		if (instruction == "push") {
			int n;
			cin >> n;

			s.push(n);
		}
		else if(instruction == "pop"){
			cout << s.pop() << endl;
		}
		else if(instruction == "size"){
			cout << s.get_size() << endl;
		}
		else if(instruction == "empty"){
			cout << s.is_empty() << endl;
		}
		else if(instruction == "top"){
			cout << s.get_top() << endl;
		}
	}

	return 0;
}
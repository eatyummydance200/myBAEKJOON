#include <iostream>
#include <string>
using namespace std;

class Queue {
	int size, capacity;
	int front, rear;
	int* mem;
public:
	Queue(int c = 100) {
		capacity = c;
		mem = new int[capacity];
		size = 0;
		front = 0, rear = 0;
	}
	~Queue() {
		delete[]mem;
	}

	void push(int n);
	int pop();
	int is_empty();
	int get_size();
	int get_front();
	int get_rear();
};

void Queue::push(int n) {
	if (size < capacity) {
		mem[rear++] = n;
		size++;
	}
}

int Queue::pop() {
	if (!is_empty()) {
		size--;
		return mem[front++];
	}
	else
		return -1;
}

int Queue::is_empty() {
	if (size > 0)
		return 0;
	else
		return 1;
}

int Queue::get_size() {
	return size;
}

int Queue::get_front() {
	if (!is_empty())
		return mem[front];
	else
		return -1;
}

int Queue::get_rear() {
	if (!is_empty())
		return mem[rear - 1];
	else 
		return -1;
}

int main() {
	int instruction_line;
	cin >> instruction_line;

	Queue q(instruction_line);

	int i = 0;
	while(i < instruction_line) {
		string instruction;
		cin >> instruction;

		if (instruction == "push") {
			int n;
			cin >> n;
			q.push(n);
		}
		else if (instruction == "pop") {
			cout << q.pop() << endl;
		}
		else if (instruction == "size") {
			cout << q.get_size() << endl;
		}
		else if (instruction == "empty") {
			cout << q.is_empty() << endl;
		}
		else if (instruction == "front") {
			cout << q.get_front() << endl;
		}
		else if (instruction == "back") {
			cout << q.get_rear() << endl;
		}
		i++;
	}
	return 0;
}
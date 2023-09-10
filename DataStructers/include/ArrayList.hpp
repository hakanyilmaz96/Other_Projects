#ifndef ARRAYLIST_HPP
#define ARRAYLIST_HPP
#include <iostream>
using namespace std;

class ArrayList{

public:
    ArrayList();
    int size() const;
	bool isEmpty() const;
	void add(int);
    void insert(int,int);    
    void updateElement(int,int);
    int elementAt(int);
	~ArrayList();
	
private:
    int length;
    int capacity;
	int *items;    
    void reverse(int);
};

#endif
/**
* @file ArrayList.cpp
* @description Başlangıçta kapasitesi 1 olan ArrayList oluşturur ve gerekli fonksiyonları
ekler.
* @course 1. Öğretim - A
* @assignment 1.Ödev
* @date 04.08.2022
* @author Hakan Yılmaz G181210382 / hakan.yilmaz15@ogr.sakarya.edu.tr
*/

#include "ArrayList.hpp"

ArrayList::ArrayList(){	
	length = 0;
	capacity = 1;
	items = new int[capacity];
}

void ArrayList::reverse(int newCapacity) {
    if (capacity >= newCapacity) return; 
    int *tmp = new int[newCapacity]; 
    for (int i = 0; i < length; i++) { 
        tmp[i] = items[i];
    }
    if (items != 0) { 
        delete[] items;
    }
    items = tmp; 
    capacity = newCapacity; 
}

void ArrayList::insert(int i, int item){    

	if (i < 0 || i > length) throw "index out of range";
    
	if (length >= capacity) reverse(2 * capacity);

    for (int j = length - 1; j >= i; j--) {
        items[j + 1] = items[j]; 
    }
    
	items[i] = item;
    length++;
}

void ArrayList::add(int item) {
	insert(length,item) ;
}

void ArrayList::updateElement(int i,int item){
	if(i < 0 || i > length) throw "index out of range";
	items[i] = item;
}

int ArrayList::size() const 
{
    return length;
}

int ArrayList::elementAt(int i) {
    if (i < 0 || i >= length) {
        throw "index out of range";
    }
    return items[i];
}

ArrayList::~ArrayList(){
	if (items != 0) { 
        delete[] items;
    }
}
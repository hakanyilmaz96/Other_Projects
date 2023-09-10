/**
* @file Main.cpp
* @description Programı çalıştırır.
* @course 1. Öğretim - A
* @assignment 1.Ödev
* @date 04.08.2022
* @author Hakan Yılmaz G181210382 / hakan.yilmaz15@ogr.sakarya.edu.tr
*/

#include "Factorial.hpp"

int main()
{
	Factorial *fact = new Factorial();
	
	int n;
	
	cout<<"Faktoriyelini bulmak istediginiz sayiyi girin: ";
	cin>>n;
	cout<<""<<endl;
	
	fact -> factorial(n);
	
	delete fact;
	
	return 0;
}
/**
* @file Factorial.cpp
* @description ArrayList'in ilk indexine '1' elemanını ekler ve ödevde istenen çarpma
işlemi yöntemini Multiply fonksiyonunu çağırarak hesaplar ve 'sonuc.txt' dosyasına yazdırır.
* @course 1. Öğretim - A
* @assignment 1.Ödev
* @date 04.08.2022
* @author Hakan Yılmaz G181210382 / hakan.yilmaz15@ogr.sakarya.edu.tr
*/

#include "Factorial.hpp"

void Factorial::factorial(int n)
{
	
	ArrayList *array = new ArrayList();
	Multiply *multi = new Multiply();
	array -> add(1);
	int length = array -> size();

	for (int x=2; x<=n; x++){		
		length = multi->multiply(x, array, length);		
	}
						
	ofstream writetoFile("sonuc.txt");
			
	for (int i=length-1; i>=0; i--)
		writetoFile << array -> elementAt(i);
		
	cout<<"Sonuc 'sonuc.txt' dosyasina yazdirildi.."<<endl;
	
	writetoFile.close();	
	
	delete array;
	delete multi;
	
		
}	
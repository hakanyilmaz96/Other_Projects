/**
* @file Multiply.cpp
* @description Ödevde istenen modeldeki çarpma işlemini SumOfDigit fonksiyonu yardımıyla basamak
 toplamları ile ArrayListteki elemanı çarparak gerçekleştirir ve sonuçların ArrayListe eklenme
işlemini gerçekleştirir.
* @course 1. Öğretim - A
* @assignment 1.Ödev
* @date 04.08.2022
* @author Hakan Yılmaz G181210382 / hakan.yilmaz15@ogr.sakarya.edu.tr
*/

#include "Multiply.hpp"

int Multiply::multiply(int x, ArrayList*& array , int length)
{
	int carry = 0; 
	
	SumOfDigit *digit= new SumOfDigit();
    x = digit -> sum(x);
	
	for (int i=0; i<length; i++)
	{
   		int product = array -> elementAt(i) * x + carry;

		array -> updateElement(i,product % 10);

		carry = product/10;
	
	}

	while (carry)
	{
		array -> add (carry%10);
		carry = carry/10;
	}
	
	delete digit;
	return array -> size();
}
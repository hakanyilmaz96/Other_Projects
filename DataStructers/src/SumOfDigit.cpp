/**
* @file SumOfDigit.cpp
* @description Çarpımda kullanılacak elemanın digitlerini toplar. 
Multiply fonksiyonunda kullanmak için yazılmıştır.
* @course 1. Öğretim - A
* @assignment 1.Ödev
* @date 04.08.2022
* @author Hakan Yılmaz G181210382 / hakan.yilmaz15@ogr.sakarya.edu.tr
*/

#include "SumOfDigit.hpp"
		
int SumOfDigit::sum(int n)
    {
        if(n == 0){
          return 0 ;
        }
       
        return (n % 10) + sum(n / 10) ;
    }
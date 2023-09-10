/****************************************************************************
**					     SAKARYA ÜNİVERSİTESİ
**				BİLGİSAYAR VE BİLİŞİM BİLİMLERİ FAKÜLTESİ
**				    BİLGİSAYAR MÜHENDİSLİĞİ BÖLÜMÜ
**				   NESNEYE DAYALI PROGRAMLAMA DERSİ
**					2021-2022 BAHAR DÖNEMİ
**	
**				ÖDEV NUMARASI..........: NDP-PROJE ÖDEVİ
**				ÖĞRENCİ ADI............: HAKAN YILMAZ
**				ÖĞRENCİ NUMARASI.......: G181210382
**              DERSİN ALINDIĞI GRUP...: 1. ÖĞRETİM C
****************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NDP_PROJE
{
    public class müsteri // Müşteri Dosyası/Sınıfı oluşturuldu
    {
        public string Adi { get; set; }
        public string Soyadi { get; set; }
        public string Alınan { get; set; }
        

        public müsteri(string isim, string soyisim, string satınaldıgı)
        {
            this.Adi = isim;
            this.Soyadi = soyisim;
            this.Alınan = satınaldıgı;
            
            
        }



        
    }
}

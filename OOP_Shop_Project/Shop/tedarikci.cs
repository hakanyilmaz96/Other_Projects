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
    class tedarikci  // Tedarikçi Dosyası/Sınıfı Oluşturuldu
    {
        public string Adi { get; set; }        
        public string TedarikEdilen { get; set; }
        public string Kategori { get; set; }


        public tedarikci(string isim, string urun, string kategori)
        {
            this.Adi = isim;
            this.TedarikEdilen = urun;
            this.Kategori = kategori;
            


        }


    }
}

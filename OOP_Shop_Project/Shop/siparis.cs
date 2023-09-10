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
    class siparis  // Sipariş Dosyası/Sınıfı Oluşturuldu
    {
        public string Urun { get; set; }
        public string Tedarikci { get; set; }
        public string Kategori { get; set; }



        public siparis (string urun, string sirket,string kategori)
        {
            this.Urun = urun;
            this.Tedarikci = sirket;
            this.Kategori = kategori;
        }


    }
}

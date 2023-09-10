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
    public class satis // Satış Dosyası/Sınıfı Oluşturuldu
    {
        public string Urun { get; set; }
        public string AlıcıAd { get; set; }
        public string AlıcıSoyad { get; set; }

        public satis(string isim,string soyisim, string urun)
        {
            this.AlıcıAd = isim;
            this.AlıcıSoyad = soyisim;
            this.Urun = urun;
        }
    
    
    }


}

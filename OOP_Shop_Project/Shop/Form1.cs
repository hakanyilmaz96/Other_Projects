/****************************************************************************
**					     SAKARYA ÜNİVERSİTESİ
**				BİLGİSAYAR VE BİLİŞİM BİLİMLERİ FAKÜLTESİ
**				    BİLGİSAYAR MÜHENDİSLİĞİ BÖLÜMÜ
**				   NESNEYE DAYALI PROGRAMLAMA DERSİ
**					  2021-2022 BAHAR DÖNEMİ
**	
**				ÖDEV NUMARASI..........: NDP-PROJE ÖDEVİ
**				ÖĞRENCİ ADI............: HAKAN YILMAZ
**				ÖĞRENCİ NUMARASI.......: G181210382
**              DERSİN ALINDIĞI GRUP...: 1. ÖĞRETİM C
****************************************************************************/


using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NDP_PROJE
{
    
    
    
    public partial class Form : System.Windows.Forms.Form
    {

        List<urun> urunler = new List<urun>  // Stok Listesi oluşturuldu
            {
                new urun("Etek",25,"Çocuk","raf"),
                new urun("Ceket",4,"Çocuk","depo"),
                new urun("Gömlek",12,"Kadın","raf"),
                new urun("Yelek",36,"Erkek","depo"),
                new urun("Pantolon",28,"Erkek","raf"),
                new urun("Toka",14,"Çocuk","depo"),
                new urun("Şapka",0,"Erkek","raf"),
                new urun("Eşarp",17,"Kadın","raf"),
                new urun("Çanta",66,"Kadın","depo"),

            };

        List<müsteri> musteriler = new List<müsteri> // Müşteri Listesi Oluşturuldu
            {
                new müsteri("Hakan","Yılmaz","Yelek"),
                new müsteri("Ayşe","Öztürk","Gömlek"),
                new müsteri("Elif","Özmen","Eşarp"),
                new müsteri("Buse","Vural","Etek"),
                new müsteri("Arif","Ölmez","Ceket"),

            };
        
        List<tedarikci> tedarikciler = new List<tedarikci> // Tedarikçi Listesi Oluşturuldu
            {
                new tedarikci("Aspava AŞ.","Etek","Çocuk"),
                new tedarikci("Lassa AŞ.","Ceket","Çocuk"),
                new tedarikci("Butik","Gömlek","Kadın"),
                new tedarikci("Arma Giyim AŞ.","Yelek","Erkek"),
                new tedarikci("Kiğılı","Pantolon","Erkek"),
                new tedarikci("Zeynep Aksesuar","Toka","Çocuk"),
                new tedarikci("Gülendam","Şapka","Erkek"),
                new tedarikci("Beymen","Çanta","Kadın"),
                new tedarikci("Kıyafetçim","Eşarp","Kadın"),        

            };

        List<siparis> siparisler = new List<siparis>  // Sipariş Listesi Oluşturuldu
        {

        };

        List<gider> giderler = new List<gider> // Gider Listesi Oluşturuldu
            {
                new gider("Eleman",1500),
                new gider("Yemek",250),
                new gider("Elektrik",120),
                new gider("Isınma",60),
                new gider("Vergi",200),
            };

        List<satis> satislar = new List<satis> // Satış Listesi Oluşturuldu
            {
               new satis("Hakan","Yılmaz","Yelek"),
               new satis("Ayşe","Öztürk","Gömlek"),
               new satis("Elif","Özmen","Eşarp"),
               new satis("Buse","Vural","Etek"),
               new satis("Arif","Ölmez","Ceket"),
            };

        


        public Form()
        {
            InitializeComponent();




            foreach (var urun in urunler)  // Ürünler Satış Kısmındaki Combobox'a Eklendi
            {
                satisComBox.Items.Add(urun.Adi); 

            }

            foreach (var tedarikci in tedarikciler)  // Sipariş Edilebilecek Eşyalar ve Tedarikçi isimleri Sipariş Kısmındaki Combobox'a Eklendi
            {
                siparisCB.Items.Add(tedarikci.TedarikEdilen);

            }


        }




        private void müsteriListeBtn_Click(object sender, EventArgs e) // Müşterileri Listelemek ve Güncellemek için Buton
        {
            musteriDGrid.Rows.Clear();

            foreach (var müsteri in musteriler)
            {
                musteriDGrid.Rows.Add(müsteri.Adi,müsteri.Soyadi,müsteri.Alınan);
            }
            
        }

        private void stokRafListeBtn_Click(object sender, EventArgs e) // Raftaki Ürünleri Listelemek ve Güncellemek için Buton
        {
            urunRafDGrid.Rows.Clear();

            foreach (var urun in urunler)
            {
                if (urun.Yer == "raf")
                {
                    urunRafDGrid.Rows.Add(urun.Adi, urun.Adet,urun.Ozellik);
                }
            }
        }

        private void stokDepoListeBtn_Click(object sender, EventArgs e) // Depodaki Ürünleri Listelemek ve Güncellemek için Buton
        {
            urunDepoDGrid.Rows.Clear();

            foreach (var urun in urunler)
            {
                if (urun.Yer == "depo")
                {
                    urunDepoDGrid.Rows.Add(urun.Adi, urun.Adet,urun.Ozellik);
                }
            }
        }

        private void giderListeBtn_Click(object sender, EventArgs e) // Giderleri Listelemek ve Güncellemek için Buton
        {
            giderlerDGrid.Rows.Clear();

            foreach(var gider in giderler)
            {
                giderlerDGrid.Rows.Add(gider.Tür, gider.Miktar);

            }
        }

        private void satisListeBtn_Click(object sender, EventArgs e) // Yapılan Satışları Listelemek ve Güncellemek için Buton
        {
            satisDGrid.Rows.Clear();

            foreach (var satis in satislar)
            {
                satisDGrid.Rows.Add(satis.Urun,satis.AlıcıAd,satis.AlıcıSoyad);
            }
           
        }



        private void satınAlBtn_Click_1(object sender, EventArgs e) // Satın Alma Butonu
        {
            
            string satilanurun = satisComBox.SelectedItem.ToString();   // Combobox'tan Satılan Ürün Tutuldu
            
            int urunindex = urunler.FindIndex(item => item.Adi == satilanurun);  // Satılan ürünün İndex'i Tutuldu


            if (urunler[urunindex].Adet == 0) // Ürünün Stoğu 0 ise Satış Yapılamadı ve Hata Mesajı Yayınlandı
            {
                MessageBox.Show("Aldığınız ürün stokta yoktur!");
            }

            else // Satış Yapıldı Müşteri, Müşteri Listesine Eklendi. Satılan Ürün Satılanlar Listesine Eklendi ve Stoktan Düşüldü
            {
            
                satis yapilansatis = new satis(musteriAdTxt.Text, musteriSoyadTxt.Text, satilanurun);
                müsteri yenimüsteri = new müsteri(musteriAdTxt.Text, musteriSoyadTxt.Text, satilanurun);
                
                satislar.Add(yapilansatis);
                musteriler.Add(yenimüsteri);

                urunler[urunindex].Adet -= 1; // Stoktan satılan ürün düşüldü

                MessageBox.Show("Satış başarılı. Satılan ürün stoktan düşüldü. Kontrol edebilirsiniz..");

            }


        }

        private void tedarikciListeBtn_Click(object sender, EventArgs e) // Tedarikçileri Listelemek ve Güncellemek için Buton
        {
            tedarikciDGrid.Rows.Clear();

            foreach (var tedarikci in tedarikciler)
            {
                tedarikciDGrid.Rows.Add(tedarikci.Adi, tedarikci.TedarikEdilen,tedarikci.Kategori);
            }
        }

        private void siparisListeBtn_Click(object sender, EventArgs e) // Siparişleri Listelemek ve Güncellemek için Buton
        {
            siparisDGrid.Rows.Clear();

            foreach (var siparis in siparisler)
            {
                siparisDGrid.Rows.Add(siparis.Urun+ " x 10",siparis.Tedarikci,siparis.Kategori);
            }
        }

        private void siparisBtn_Click(object sender, EventArgs e) // Sipariş verildi ve Sipariş Verilen Ürün Stoğa Eklendi
        {
            int siparisindex = tedarikciler.FindIndex(item => item.TedarikEdilen == siparisCB.SelectedItem.ToString());  // Sipariş verilen ürünün İndex'i Tutuldu


            siparis verilensiparis = new siparis(tedarikciler[siparisindex].TedarikEdilen, tedarikciler[siparisindex].Adi, tedarikciler[siparisindex].Kategori);
            siparisler.Add(verilensiparis);

            urunler[siparisindex].Adet += 10; // Sipariş verilen ürün stoğa eklendi

            MessageBox.Show("Sipariş başarılı. Sipariş verilen ürün stoğa eklendi.");
        }
    }
}

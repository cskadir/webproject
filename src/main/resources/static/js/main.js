/**
 * Created by cScientist on 11.07.2019.
 */


function masaUrunleriniAl(){

    $.post("/showmasa", function (result) {
        //alert(JSON.stringify(result));
        var html = "";
        for (var i = 0; i < result.length; i++) {
            var obj = result[i];
            var bill = obj.bill;
            var uruns="";
            var acikKapali=obj.open
            ll=obj.masaUrunleri.length
            for(var x=0; x<ll; x++){
                if(ll != 0){
                    urun=obj.masaUrunleri[x];
                    billurun = urun.fiyat;
                    isim = urun.name;
                    uruns += isim+" "+ billurun.toString();
                    console.log(isim);
                }


                //html+=obj.masaUrunleri[i].name+ obj.masaUrunleri[i].fiyat;"\n"
            }


            html += '<div class="card" style="width: 18rem;">' +
                '<div class="card-body" >'
            if(acikKapali==true){
                html+= '<h5 class="card-title p-3 mb-2 bg-success text-white">' +
                    obj.name +
                    '</h5>'
            }
            else{
                html+='<h5 class="card-title p-3 mb-2 bg-danger text-white">' +
                    obj.name +
                    '</h5>'
            }
            html+= '<h6 class="card-subtitle mb-2 text-muted">Masanın Hesabı: ' +
                bill.toString() +
                '</h6>' +
                '<p class="card-text">' +uruns+
                '</p>' +
                '<a href="/siparisAlmaEkrani?masaNo=' + obj.masaNo +
                '"class="card-link">Urun Ekle</a>' +
                '<a href="" onclick="hesapAl('+
                obj.masaNo +
                ')" class="card-link">Hesap Al</a>' +
                '</div>' +
                '</div>'
        }
        $("#scrolling-wrapper").html(html);
        //  $("").html ( JSON.stringify(result));
    });

}

function urunleriGetir(){
    $(document).ready(function(){
        $.post("/getUrunler", function (result) {
            //alert(JSON.stringify(result));
            var html="";
            for(var i = 0; i < result.length; i++) {
                var obj=(result[i]);
                console.log(obj);
                var name = result[i].name ;
                var fiyat= result[i].fiyat;
                var id= result[i].id;
                console.log(id);
                //var onclic1 = 'sec('+paramValue+',"'+name.toString()+'")'
                /* html += "<div onclick="+onclic1+" class='card'>" +
                 obj.name +
                 "</div>";*/

                html+='<div class="card bg-light mb-3" style="max-width: 18rem;">' +
                    '<div class="card-header bg-transparent border-success">' +
                    fiyat +" TL"+
                    '</div>' +
                    '<div class="card-body text-success">' +
                    '<h5 class="card-title">' + name+
                    '</h5>' +
                    '<p class="card-text" ></p>' +
                    '</div>' +
                    '<a href="/urunDuzenlemeEkrani/edit?id=' +id+
                    '"'+
                    'class="card-footer bg-transparent border-success">duzenle</a href>' +
                    '</div>'
            }
            $("#kk").html(html);

        });
    });
}

function urunGetir(name) {
    $(document).ready(function(){
        $.post("/urunDuzenlemeEkrani/edit?name="+name, function (result) {
            //alert(JSON.stringify(result));
            var html="";
            if(result!=null) {
                var obj=(result[i]);
                console.log(obj);
                var name = result.name ;
                var fiyat= result.fiyat;
                //var onclic1 = 'sec('+paramValue+',"'+name.toString()+'")'
                /* html += "<div onclick="+onclic1+" class='card'>" +
                 obj.name +
                 "</div>";*/

                html+='<div class="card bg-light mb-3" style="max-width: 18rem;">' +
                    '<div class="card-header bg-transparent border-success">' +
                    fiyat +" TL"+
                    '</div>' +
                    '<div class="card-body text-success">' +
                    '<h5 class="card-title">' + name+
                    '</h5>' +
                    '<p class="card-text" ></p>' +
                    '</div>' +
                    '<a href="/urunDuzenlemeEkrani/edit" class="card-footer bg-transparent border-success">duzenle</a href>' +
                    '</div>'
            }
            $("#kk").html(html);

        });
    });




}

function urunGuncelle() {
    var id;
    var name;
    var fiyat;
    var indirim;
    var pisirmeSuresi=null;//yemek+
    var pisirmeSekli=null; //tatlı
    var asitliMi=false; //icecek
    var sicakMi =false; //icecek

    name = document.getElementById('urunName').value;
    fiyat = document.getElementById('urunFiyat').value;
    id = document.getElementById('urunId').value
    indirim=document.getElementById('urunIndirim').value;
    if(document.getElementById('urunPisirmeSuresi')!=null)
        pisirmeSuresi=document.getElementById('urunPisirmeSuresi').value;
    if(document.getElementById('urunPisirmeSekli')!=null)
        pisirmeSekli=document.getElementById('urunPisirmeSekli').value;
    if(document.getElementById('urunasitliMi')!=null)
        asitliMi=document.getElementById('urunasitliMi').value;
    if(document.getElementById('urunsıcakMi')!=null)
        sicakMi=document.getElementById('urunsıcakMi').value;


    $.post("/urunDuzenlemeEkrani/edit/urunGuncelle?id="+id+"&name="+name+
        "&fiyat="+fiyat+"&indirim="+indirim+"&pisirmeSuresi="+pisirmeSuresi+"&pisirmeSekli="+pisirmeSekli+
        "&asitliMi="+asitliMi+"&sicakMi="+sicakMi, function(result){
        alert(result);

    });



}

function urunBilgileri() {
    $(document).ready(function(){
    var url_string = window.location.href; // www.test.com?filename=test

    var url = new URL(url_string);
    var paramValue = url.searchParams.get("id");
    $.post("/urunDuzenlemeEkrani/edit?id="+paramValue, function(result){
        var id;
        var name;
        var fiyat;
        var indirim;
        var pisirmeSuresi;//yemek+
        var pisirmeSekli; //tatlı
        var asitliMi; //icecek
        var sicakMi ; //icecek
        if(result!=null){
            name=result.name;
            fiyat=result.fiyat;
            indirim=result.indirim;
            pisirmeSuresi=result.pisirmeSuresi;
            pisirmeSekli=result.pisirmeSekli;
            asitliMi=result.asitliMi;
            sıcakMi=result.sıcakMi;

            var html="";

            html+='<form>' +
                '<div class="form-group row">' +
                '<label for="name" class="col-sm-2 col-form-label">Id :</label>' +
                '<div class="col-sm-10">' +
                '<input type="text" readonly class="form-control-plaintext" id="urunId">' +
                '</div>' +
                '</div>' +
                '<div class="form-group row">' +
                '<label for="name" class="col-sm-2 col-form-label">Isim :</label>' +
                '<div class="col-sm-10">' +
                '<input type="text" class="form-control" id="urunName" placeholder="Isım">' +
                '</div>' +
                '</div>'+
                '<div class="form-group row">' +
                '<label for="name" class="col-sm-2 col-form-label">Fiyat : </label>' +
                '<div class="col-sm-10">' +
                '<input type="text" class="form-control" id="urunFiyat" placeholder="Fiyat">' +
                '</div>' +
                '</div>'+
                '<div class="form-group row">' +
                '<label for="name" class="col-sm-2 col-form-label">Indirim:   </label>' +
                '<div class="col-sm-10">' +
                '<input type="text" class="form-control" id="urunIndirim" placeholder="Indirim">' +
                '</div>' +
                '</div>';

                if(pisirmeSuresi!=undefined){
                    html+='<div class="form-group row">' +
                        '<label for="name" class="col-sm-2 col-form-label">Pisirme Suresi :   </label>' +
                        '<div class="col-sm-10">' +
                        '<input type="text" class="form-control" id="urunPisirmeSuresi" placeholder="Pisirme Suresi">' +
                        '</div>' +
                        '</div>';
             //       document.getElementById('urunPisirmeSuresi').value= pisirmeSuresi;
                }
                else if(pisirmeSekli!=undefined){

                    html+='<div class="form-group row">' +
                        '<label for="name" class="col-sm-2 col-form-label">Pisirme Sekli :   </label>' +
                        '<div class="col-sm-10">' +
                        '<input type="text" class="form-control" id="urunPisirmeSekli" placeholder="Pisirme Sekli">' +
                        '</div>' +
                        '</div>';
               //     document.getElementById('urunPisirmeSekli').value=pisirmeSekli;
                }
                else{

                    html+='<div class="form-group row">' +
                        '<label for="name" class="col-sm-2 col-form-label">Asitli mi :   </label>' +
                        '<div class="col-sm-10">' +
                        '<input type="text" class="form-control" id="urunasitliMi" placeholder="Asitli mi">' +
                        '</div>' +
                        '</div>';

                    html+='<div class="form-group row">' +
                        '<label for="name" class="col-sm-2 col-form-label">Sıcak mi :   </label>' +
                        '<div class="col-sm-10">' +
                        '<input type="text" class="form-control" id="urunsıcakMi" placeholder="Sıcak mi">' +
                        '</div>' +
                        '</div>';
                 //   document.getElementById('urunasitliMi').value=asitliMi;
                 //   document.getElementById('urunsıcakMi').value=sıcakMi
                }
            html+='</form>';
            $("#kk").html(html);
            document.getElementById('urunName').value=name;
            document.getElementById('urunFiyat').value=fiyat;
            document.getElementById('urunId').value=result.id;
            document.getElementById('urunIndirim').value=indirim;
            if(document.getElementById('urunPisirmeSuresi')!=null)
                document.getElementById('urunPisirmeSuresi').value= pisirmeSuresi;
            if(document.getElementById('urunPisirmeSekli')!=null)
                document.getElementById('urunPisirmeSekli').value=pisirmeSekli;
            if(document.getElementById('urunasitliMi')!=null)
                document.getElementById('urunasitliMi').value=asitliMi;
            if(document.getElementById('urunsıcakMi'))
                document.getElementById('urunsıcakMi').value=sicakMi;










        }


        //değişiklik yaptıktan sonra:


    });
    });


}

function  urunDuzenleme() {

    window.location = "/urunDuzenlemeEkrani";

}
function yeniUrunEkleEkran(){
    window.location = "/yeniUrun";
}

function adminGiris() {
    var sfr=document.getElementById('sifre').value;
    var klc=document.getElementById('kullaniciAdi').value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if(this.responseText=="true"){
                window.location = "/menu";

            }else{
                alert("Hatalı giris");
            }

        }
    };
    xhttp.open("POST", "/login?name="+klc+"&pass="+sfr, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    /*
    if(x==true){
        alert("giris yapıldı");
        document.getElementById("kitaplar").innerHTML = "";
        document.getElementById("kitaplar").innerHTML += JSON.stringify(myJson);
    }
    else{
        alert("yanlısss");
        return false;
    }


    const show = async () =>
    {
        fetch('http://localhost:8080/adminKontrol=')
            .then(function (response) {
                return response.booleanValue();
            })
            .then(function (mybool) {
                if (mybool == true) {
                    alert("giris yapıldı");
                    document.getElementById("kitaplar").innerHTML = "";
                    document.getElementById("kitaplar").innerHTML += JSON.stringify(myJson);
                }
                else{
                    alert("yanlısss");
                    return false;
                }

            });


    }*/
    return false ;

}

function MasaAc(x) {
        window.location = "/siparisAlmaEkrani?masaNo="+x;
}

function goBack() {
    window.history.back();
}

function yeniUrunDivYarat() {


    var html="";

    var html="";

    html+='<form>' +
        '<div class="form-group row">' +
        '<label for="name" class="col-sm-2 col-form-label">Id :</label>' +
        '<div class="col-sm-10">' +
        '<input type="text" readonly class="form-control-plaintext" id="urunId">' +
        '</div>' +
        '</div>' +
        '<div class="form-group row">' +
        '<label for="name" class="col-sm-2 col-form-label">Isim :</label>' +
        '<div class="col-sm-10">' +
        '<input type="text" class="form-control" id="urunName" placeholder="Isım">' +
        '</div>' +
        '</div>'+
        '<div class="form-group row">' +
        '<label for="name" class="col-sm-2 col-form-label">Fiyat : </label>' +
        '<div class="col-sm-10">' +
        '<input type="text" class="form-control" id="urunFiyat" placeholder="Fiyat">' +
        '</div>' +
        '</div>'+
        '<div class="form-group row">' +
        '<label for="name" class="col-sm-2 col-form-label">Indirim:   </label>' +
        '<div class="col-sm-10">' +
        '<input type="text" class="form-control" id="urunIndirim" placeholder="Indirim">' +
        '</div>' +
        '</div>';

    html+='<div id="yemek" style="display:none">' +
        '<div class="form-group row">' +
        '<label for="name" class="col-sm-2 col-form-label">Pisirme Suresi :   </label>' +
        '<div class="col-sm-10">' +
        '<input type="text" class="form-control" id="urunPisirmeSuresi" placeholder="Pisirme Suresi">' +
        '</div>' +
        '</div>' +
        '</div>';

    html+='<div id="tat" style="display:none">' +
        '<div class="form-group row">' +
        '<label for="name" class="col-sm-2 col-form-label">Pisirme Sekli :   </label>' +
        '<div class="col-sm-10">' +
        '<input type="text" class="form-control" id="urunPisirmeSekli" placeholder="Pisirme Sekli">' +
        '</div>' +
        '</div>'+
        '</div>';

    html+='<div id="ic" style="display:none">' +
        '<div class="form-group row">' +
        '<label for="name" class="col-sm-2 col-form-label">Asitli mi :   </label>' +
        '<div class="col-sm-10">' +
        '<input type="text" class="form-control" id="urunasitliMi" placeholder="Asitli mi">' +
        '</div>' +
        '</div>';


    html+='<div class="form-group row">' +
        '<label for="name" class="col-sm-2 col-form-label">Sıcak mi :   </label>' +
        '<div class="col-sm-10">' +
        '<input type="text" class="form-control" id="urunsıcakMi" placeholder="Sıcak mi">' +
        '</div>' +
        '</div>'+
        '</div>';
    $("#kk").html(html);

}

function divGosterKapat() {

    var e=document.getElementById("inputGroupSelect");
    var kontrol = e.options[e.selectedIndex].value;

    var y = document.getElementById("yemek");
    var i= document.getElementById("ic");
    var t = document.getElementById("tat");


    if(kontrol=="1"){

        y.style.display = "block";
        i.style.display = "none";
        t.style.display = "none";
    }
    else if(kontrol=="2"){

        y.style.display = "none";
        t.style.display = "block";
        i.style.display = "none";
    }
    else if(kontrol=="3"){


        y.style.display = "none";
        t.style.display = "none";
        i.style.display = "block";

    }



}

function urunEkle() {


    var name = document.getElementById('urunName').value;
    var fiyat = document.getElementById('urunFiyat').value;
    var indirim=document.getElementById('urunIndirim').value;

    var y = document.getElementById("yemek");
    var i= document.getElementById("ic");
    var t = document.getElementById("tat");

    if(y.style.display=="block"){
        var pisirmeSuresi=document.getElementById('urunPisirmeSuresi').value;
        $.post("/YemekEkle?name="+name+"&fiyat="+fiyat+"&indirim="+indirim+"&pisirmeSuresi="+pisirmeSuresi, function(result){
            alert(result);
        });
    }
    else if(t.style.display=="block"){
        var pisirmeSekli=document.getElementById('urunPisirmeSekli').value;
        $.post("/TatliEkle?name="+name+"&fiyat="+fiyat+"&indirim="+indirim+"&pisirmeSekli="+pisirmeSekli, function(result){
            alert(result);
        });
    }
    else if(i.style.display=="block"){
        var asitliMi=document.getElementById('urunasitliMi').value;
        var sicakMi=document.getElementById('urunsıcakMi').value;
        $.post("/IcecekEkle?name="+name+"&fiyat="+fiyat+"&indirim="+indirim+"&asitliMi="+asitliMi+"&sicakMi="+sicakMi, function(result){
            alert(result);
        });

    }



}


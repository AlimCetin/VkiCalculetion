import React, { useEffect, useState } from 'react';
import vkiApi from '../services/VkiApi';
import './main.css'
import { useNavigate } from 'react-router-dom';
// userCreateSubmit tıklandığında sonucu gösteren alanı dislayi için konrol değişkeni
localStorage.setItem("sumbitOnClick", true);

function Main() {
    // Const
    const navigate = useNavigate();
    const [sumbitOnClick, setSumbitOnClick] = useState(localStorage.getItem("sumbitOnClick"));
    const [useId, setUserId] = useState();
    const [userName, setUserName] = useState();
    const [userKilo, setUserKilo] = useState();
    const [userHeight, setUserHeight] = useState();
    const [referenceVki, setReferenceVki] = useState([]);
    let [explanation, setExplanation] = useState();
    const [sonuc, setSonuc] = useState();
    //  ERROR,
    const [error, setError] = useState(undefined);

    /////////////////////////////////////////////////
    // ilk yüklendiğinde vki referans  bilgilerini aldık.
    useEffect(() => {
        apiReferenceVki();
    }, []);

    /////////////////////////////////////////////////
    // FUNCTION
    // vki referans çekme fonksiyonu
    const apiReferenceVki = async (event) => {
        try {
            const response = await vkiApi.vkiReferenceApiList();
            if (response.status == 200) {
                setReferenceVki(response.data);
            }
        } catch (err) {
            console.error(err);
            setError(err);
        }
    }
    //verileri temizliyor
    const inputListClear = () => {
        document.getElementById("userName").textContent = "";
        document.getElementById("userKilo").textContent = "";
        document.getElementById("uHeight").textContent = "";
    }
    // OnChange
    //Girilen bilgileri değişkenlere set ediliyor.
    //userName 
    const userNameOnChange = (event) => {
        setUserName(event.target.value);
    }
    //userKilo
    const userKiloOnChange = (event) => {
        setUserKilo(Number(event.target.value));
    }
    //userHeight
    const userHeightOnChange = (event) => {
        setUserHeight(Number(event.target.value));
    }

    // forma tıklanınca işlemleri durdurması için
    const onSubmitForm = (e) => {
        e.preventDefault();
    }
    // Çıkan sonuca göre karşılaştırma yapılıyor
    function calculetion(sonuc) {
        for (let data of referenceVki) {
            console.log(data);
            if (data.minReference <= sonuc && data.maxReference >= sonuc) { return data.vkiExplanation }
        }
    }

    //SUBMIT
    // Hesaplama, kayıt ve geçmiş bilgileri listelem sayfasına gidiyor
    const userCreateSubmit = async (event) => {
        // Kayıt Object
        const userCreateObject = {
            "uname": userName,
            "ukilo": userKilo,
            "uheight": userHeight
        }
        document.getElementById("nav-label").textContent = userName;
        //hesapla yerini göstermek için kullanılıyor.
        setSumbitOnClick(false);
        //kayıt işlemi yapılıyor ve bilgiler sıfırlanıyor
        try {
            const son = userKilo / (userHeight * userHeight) * 10000;
            setSonuc(son);
            setExplanation(calculetion(son));
            const response = await vkiApi.userApiCreate(userCreateObject);
            if (response.status == 200) {
                inputListClear();
                alert("Bilginiz kaydedildi.");
                navigate("/findbyuname/" + userName);
            }
        } catch (err) {
            console.error(err);
            setError(err)
        }

    }
    //Sonucun gösterilip gösterilmemesini ayarlıyoruz.
    let classNameSumbit;
    if (sumbitOnClick) { classNameSumbit = "none" } else { classNameSumbit = "flex"; }

    /////////////////////////////////////////////////
    // RETURN
    return (
        <div className='container text-center' >
            <h1 className="mt-5">Vücut kitle indeksini hesaplamak için bilgileri giriniz. </h1>
            <div className='row' style={{ marginTop: "1rem", flexWrap: "nowrap" }}>
                <div className='col-6'>
                    <form onSubmit={onSubmitForm} >
                        <div className="d-grid gap-1">
                            {/* Name */}
                            <div className="form-group"><label htmlFor="userName"> Adınız Soyadınız : </label>
                                <input
                                    type="text"
                                    className="form-control mb-3"
                                    id="userName"
                                    name="userName"
                                    placeholder='...'
                                    autoFocus={true}
                                    required={true}
                                    onChange={userNameOnChange}
                                />
                            </div>
                            {/* Kilo */}
                            <div className="form-group"><label htmlFor="userKilo">Kilonuzu Giriniz :</label>
                                <input
                                    type="text"
                                    className="form-control mb-3"
                                    id="userKilo"
                                    name="userKilo"
                                    placeholder='Kg'
                                    autoFocus={false}
                                    required={true}
                                    onChange={userKiloOnChange}
                                />
                            </div>
                            {/* Boy */}
                            <div className="form-group"><label htmlFor="uHeight">Boyunuzu giriniz :</label>
                                <input
                                    type="text"
                                    className="form-control mb-3"
                                    id="uHeight"
                                    name="uHeight"
                                    placeholder='Cm'
                                    autoFocus={false}
                                    required={true}
                                    onChange={userHeightOnChange}
                                />
                            </div>
                            {/* RESET */}
                            <div className='col '>
                                <button
                                    type='reset'
                                    onClick={inputListClear}
                                    className="btn btn-danger mt-2 me-2">Temizle</button>

                                {/* CREATSUBMİT  */}
                                <button
                                    id="UserCreateSubmit"
                                    type='submit'
                                    onClick={userCreateSubmit}
                                    className="btn btn-primary mt-2 me-2" >
                                    Hesapla
                                </button></div>
                        </div>
                    </form>
                </div>
                {/* SONUC */}
                <div id="calculetion " className="cards col-6" style={{ display: `${classNameSumbit}`, width: "100%" }}>
                    <div className="card text-dark bg-light mb-3" style={{ maxWidth: "18rem" }}>
                        <div className="card-header">{userName}</div>
                        <div className="card-body">
                            <h5 className="card-title">Sonuç : {sonuc}</h5>
                            <p className="card-text">Açıklama : {explanation}</p>
                        </div>
                    </div>
                </div></div></div>
    )
}
export default Main;
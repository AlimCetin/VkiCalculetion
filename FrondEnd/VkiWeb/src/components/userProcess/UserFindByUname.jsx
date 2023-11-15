// rfce
import React, { useEffect, useState } from 'react';
import vkiApi from '../../services/VkiApi';
import { useParams } from 'react-router-dom';

function UserFindByUname() {
  
  //Const
  const [apiListData, setApiListData] = useState([]);
  const paramsId = useParams();
  const [userIdUp, setUserIdUp] = useState();
  const [userNameUp, setUserNameUp] = useState('');
  const [userKiloUp, setUserKiloUp] = useState();
  const [userHeightUp, setUserHeightUp] = useState();

  /////////////////////////////////////////////////
  // EFFECT
  useEffect(() => {
    fetchRegisterList();
  }, []);

/////////////////////////////////////////////////
  // Function
  //Geçmiş data bilgileri getiriyor ve apiListData ya aktarıyor.
  const fetchRegisterList = async () => {
    try {
      const response = await vkiApi.userApiFindByUName(paramsId.uname)
      setApiListData(response.data);

    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };
   // OnChange
   //Güncellenecek bilgilerin deişkenleri
    //Girilen bilgileri değişkenlere set ediliyor. 
    //userNameUp 
  const userNameOnChange = (event) => {
    setUserNameUp(event.target.value);
  }
  //userKiloUp
  const userKiloOnChange = (event) => {
    setUserKiloUp(Number(event.target.value));
  }
//userHeightUp
  const userHeightOnChange = (event) => {
    setUserHeightUp(Number(event.target.value));
  }

  //Kullanıcının güncellediği verileri database de güncelliyor
  const userUpdate = async () => {
    //Gönderilecek obje
    const userUpObject = {
      "uname": userNameUp,
      "ukilo": userKiloUp,
      "uheight": userHeightUp
    }
    try {
      const response = await vkiApi.userApiUpdate(userIdUp, userUpObject);
      if (response.status == 200) {
        alert("Güncellendi ");
       //Sayfa yenileniyor 
        window.location.reload();
      }
    }
    catch (error) {
      console.error('Error fetching users:', error);
    }

  }
  //Tablo da seçtiği datayı database de siliyor.
  const userDeteleId = async (id) => {
    try {
      const response = await vkiApi.userApiDeleteById(id);
      if (response.status == 200) {
        alert("silindi ");
        window.location.reload();
      }

    }
    catch (error) {
      console.error('Error fetching users:', error);
    }

  }
  //Tablo da güncellemek için seçtiği verilerin bilgisini  modala taşıyor. 
  const userUpdateControl = async (id) => {
    setUserIdUp(id);
    try {
      const response = await vkiApi.userApiFindById(id);
      setUserNameUp(response.data.uname);
      setUserKiloUp(response.data.ukilo);
      setUserHeightUp(response.data.uheight);
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  }
  // RETURN
  return (
    <React.Fragment><div>
      <h1>Geçmiş bilgilerin listesi</h1>
      {/* Table */}
      <table className='table table-striped table-hover  '>
        <thead>
          <tr>
            <th>Id</th>
            <th>Ad Soyad</th>
            <th>Kilo</th>
            <th>Boy</th>
            <th>Tarih</th>
            <th>Güncelle</th>
            <th>Sil</th>
          </tr>
        </thead>
        <tbody>
          {
            // Gelen verileri listeliyor.
            apiListData.map((data) =>
              <tr key={data.id}>
                <td>{data.id}</td>
                <td>{data.uname}</td>
                <td>{data.ukilo}</td>
                <td>{data.uheight}</td>
                <td>{data.systemDate}</td>
                <td>

                  <i type="button" onClick={() => userUpdateControl(data.id)} className="fa-solid fa-pencil text-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"></i>
                </td>
                <td>
                  <i type="button" onClick={() => userDeteleId(data.id)} className="fa-solid fa-trash text-danger"></i>
                </td>
              </tr>
            )
          }
        </tbody>
      </table>
      <br />
      {/* ////////////////////////////////////////////// */}
{/* Modal  */}
      <div
        className="modal fade"
        id="exampleModal"
        tabIndex={-1}
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title" id="exampleModalLabel">
                Güncellemek istediğiniz  bilgileri giriniz
              </h5>
              <button
                type="button"
                className="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              />
            </div>
            <div className="modal-body">
              <div className="d-grid gap-4">
                {/* Name */}
                <div className=""><label htmlFor="userUpName"> Adınız Soyadınız : </label>
                  <input
                    type="text"
                    disabled
                    id="userUpName"
                    //  placeholder={apiFindByIdData.uname}
                    onChange={userNameOnChange}
                    value={userNameUp}
                  />
                </div>

                {/* Kilo */}
                <div className=""><label htmlFor="userUpKilo">Kilonuzu Giriniz :</label>
                  <input
                    type="text"
                    id="userUpKilo"
                    //placeholder={apiFindByIdData.ukilo}
                    onChange={userKiloOnChange}
                    value={userKiloUp}
                  />

                </div>

              {/* Height */}
                <div className=""><label htmlFor="userUpHeight">Boyunuzu giriniz :</label>
                  <input
                    type="text"
                    id="userUpHeight"
                    // placeholder={apiFindByIdData.uheight}
                    onChange={userHeightOnChange}
                    value={userHeightUp}
                  />

                </div>
              </div>
            </div>
            {/* Buttons */}
            <div className="modal-footer">
              <button
                type="button"
                className="btn btn-secondary"
                data-bs-dismiss="modal"
              >
                Kapat
              </button>
              <button type="button" className="btn btn-primary" onClick={userUpdate} data-bs-dismiss="modal">
                Güncelle
              </button>
            </div>
          </div>
        </div>
      </div>
      </div>
    </React.Fragment>
  )
} 

export default UserFindByUname;

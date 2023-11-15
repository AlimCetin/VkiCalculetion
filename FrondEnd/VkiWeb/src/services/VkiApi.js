
// Axios
import axios from "axios";

// Persist Data Url
const PERSIST_URL = "http://localhost:3737/api";

class VkiApi {
 ///////////////////////////////////////////////////////////////////////////
    // SPEED DATA
    // http://localhost:3737/api/v1.0.0/speed/data/10
    // @GetMapping("/speed/data/{id}")
    userApiSpeedData(id) {
        return axios.get(`${PERSIST_URL}/speed-data/${id}`)
    }
  ///////////////////////////////////////////////////////////////////////////
    // DELETE ALL
    // http://localhost:3737/api/delete/all
    // @GetMapping("/delete/all")
    userApiDeleteAll() {
        return axios.get(PERSIST_URL + "/delete/all")
    }
    ///////////////////////////////////////////////////////////////////////////

    // SEARCH  NAME
    // http://localhost:3737/api/search?uName=Ali
    //@GetMapping("/search")
    userApiFindByUName(uName) {
        return axios.get((`${PERSIST_URL}/search?uName=${uName}`));
    }

    ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // http://localhost:3737/api/create
    // @PostMapping("/create")
    userApiCreate(vkiDto) {
        return axios.post(`${PERSIST_URL}/create`, vkiDto, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(vkiDto),
        })
    }
     ///////////////////////////////////////////////////////////////////////////
    // LIST ALL
    // http://localhost:3737/api/list
    // @GetMapping("/list")
    userApiList() {
        return axios.get(`${PERSIST_URL}/list`)
    }
 ///////////////////////////////////////////////////////////////////////////
    // FIND BY ID
    // http://localhost:3737/api/find/1
    // @GetMapping("/find/{id}")
   userApiFindById(id) {
        return axios.get(`${PERSIST_URL}/find/${id}`)
    }
///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // http://localhost:3737/api/update/1
    // @PutMapping(value = "/update/{id}")
    userApiUpdate(id, registerDto) {
        return axios.put(`${PERSIST_URL}/update/${id}`, registerDto)
    }
 ///////////////////////////////////////////////////////////////////////////
    // DELETE BY ID
    // http://localhost:3737/api/delete/1
    // @DeleteMapping("/delete/{id}")
    userApiDeleteById(id) {
        return axios.delete(`${PERSIST_URL}/delete/${id}`)
    }

     ///////////////////////////////////////////////////////////////////////////
     // VKI REFERENCE
     // http://localhost:3737/api/referenceVki
     //@GetMapping("/referenceVki")
     vkiReferenceApiList() {
        return axios.get(`${PERSIST_URL}/referenceVki`)
    }
} //end class

export default  new VkiApi()

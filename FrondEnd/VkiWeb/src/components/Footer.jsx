// rcc
import React, { Component } from 'react';

// Class  Footer Component
class Footer extends Component {
    constructor(props) {
        super(props);
        this.state = {
        }
    }

    // Function
    //Bulunduğu yıl
    nowDate() {
        return new Date().getFullYear();
    }

    // RENDER
    render() {

        // RETURN
        return (
            // Footer
                <footer className="bg-light text-center text-lg-start fixed-bottom">
                    <div
                        className="text-center p-3"
                        style={{ backgroundColor: "rgba(0, 0, 0, 1)", color: "white" }}
                    >
                        © 2023 - {this.nowDate()} Copyright:   
                        <a className="text-dark" href="#!">
                            Vücut  Kitle indeksi   &copy; Bütün haklar saklıdır
                        </a>
                    </div>
                </footer>
        );
    }
}

//Export
export default Footer;
import React, { Component } from 'react';
import Avatar from '@mui/material/Avatar';
class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
        }
    }
    render() {
        // RETURN
        return (

            // Nav bar oluşturuldu.
            <header >
                <nav className="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
                    <div className="container" style={{
                        display: "flex",
                        flexDirection: "row",
                        justifyContent: "flex-start"
                    }}>
                        {/* Avatar */}
                        <Avatar></Avatar>
                        {/* Label */}
                        <label id='nav-label' style={{ color: "rgb(208, 250, 250)" }}>-----</label>
                    </div>
                </nav>
                <span style={{ marginBottom: "2rem" }}>.</span>
            </header>
        ); 
    }
}
export default Header;
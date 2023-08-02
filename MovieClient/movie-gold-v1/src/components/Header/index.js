import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faVideoSlash} from "@fortawesome/free-solid-svg-icons/faVideoSlash";
import {Button, Container, Nav, Navbar, NavLink} from "react-bootstrap";

export default function Header() {
    return (
        <Navbar bg={"dark"} variant={"dark"} expand={"lg"}>
            <Container fluid>
                <Navbar.Brand href={"/"} style={{"color": "gold"}}>
                    <FontAwesomeIcon icon={faVideoSlash}/>Gold
                </Navbar.Brand>
                <Navbar.Toggle aria-controls={"navbarScroll"}/>
                <Navbar.Collapse id={"navbarScroll"}>
                    <Nav
                        className={"me-auto my-2 my-lg-0"}
                        style={{maxHeight: "100px"}}
                        navbarScroll>
                        <NavLink className={"nav-link"} href={"/"}>Home</NavLink>
                        <NavLink className={"nav-link"} href={"/watch-list"}>Watch List</NavLink>
                    </Nav>
                    <Button variant={"outline-info"} className={"me-2"}>Login</Button>
                    <Button variant={"outline-info"} className={"me-2"}>Register</Button>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

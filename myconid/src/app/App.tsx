import {Outlet} from "react-router"
import Header from "../components/header"

function App() {
    return (
        <>
            <Header />

            <div className="flex flex-col w-full p-18">
                <Outlet />
            </div>
        </>
    )
}

export default App

import { type ReactNode, useState } from "react"
import { Link } from "react-router";
import { ChevronDown } from "lucide-react";

export default function Header(): ReactNode {
    return (
        <header className="flex flex-col justify-center">
            <MainHeader />

            <SubHeader />
        </header>
    );
}

function MainHeader(): ReactNode {
    return (
        <div className="flex justify-center w-full bg-black p-4 border-2 border-b-red-500">
            <Link to="/" className="w-min whitespace-nowrap flex justify-center cursor-pointer">
                <img className="max-w-8 mr-2" src="./rpg-beyond.svg" />
                <h1 className="text-white text-2xl text-center">
                    <span className="text-red-500">R</span>
                    <span className="text-yellow-500">P</span>
                    <span className="text-blue-500">G </span>
                    Beyond
                </h1>
            </Link>
        </div>
    );
}

function SubHeader(): ReactNode {
    const [showTools, setShowTools] = useState(false);

    const toggleTools = () => {
        setShowTools(!showTools);
    }

    const toggleAll = () => {
        toggleTools();
    }

    return (
        <div onMouseLeave={toggleAll}>
            <div className="flex justify-center w-full p-4 bg-zinc-700 m-auto">
                <button className="flex text-zinc-300 hover:text-zinc-50" onMouseEnter={toggleTools}>
                    Tools
                    <ChevronDown />
                </button>
            </div>

            <div>
                <Tools show={showTools} toggle={toggleTools} />
            </div>
        </div>
    );
}

function Tools({show, toggle}: {show: boolean, toggle: () => void}): ReactNode {
    return (
        <div className="absolute px-2 w-full">
            {show && (
                <div className="grid grid-cols-3 bg-zinc-800 text-white px-24 py-12 shadow-md shadow-black rounded">
                    <Link to="/create" onClick={toggle}>CHARACTER CREATION</Link>
                </div>
            )}
        </div>
    );
}
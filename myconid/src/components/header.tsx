import type { ReactNode } from "react"
import { Link } from "react-router";

export default function Header(): ReactNode {
    return (
        <header className="bg-black p-4 flex justify-center content-center">
            <Link to="/" className="w-min whitespace-nowrap flex justify-center content-center cursor-pointer">
                <img className="max-w-8 mr-2" src="./rpg-beyond.svg"/>
                <h1 className="text-white text-2xl text-center">
                    <span className="text-red-500">R</span>
                    <span className="text-yellow-500">P</span>
                    <span className="text-blue-500">G </span>
                    Beyond
                </h1>
            </Link>
        </header>
    );
}
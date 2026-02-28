import {type ReactNode, useEffect, useState} from "react";
import type {Class} from "../model/class.ts";
import {findAllClasses} from "../services/classService.ts";

export default function CreateCharacter(): ReactNode {
    const [classes, setClasses] = useState<Class[] | undefined>(undefined);
    const [error, setError] = useState<string | undefined>(undefined);

    useEffect(() => {
        findAllClasses()
            .then(classes => setClasses(classes))
            .catch(error => setError(error.message));
    }, []);

    if (error)
        return <>{ error }</>

    return (
        <>
            <label>Classes</label>
            <select>
                {classes?.map(clazz => (
                    <option>{clazz.name}</option>
                ))}
            </select>
        </>
    );
}
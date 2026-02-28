import type {Class} from "../model/class.ts";
import api from "./api.ts";

export async function findAllClasses(): Promise<Class[]> {
    const response = await api.get<Class[]>("/classes");

    return response.data;
}
import api from "./api.ts";
import type {Background} from "../model/background.ts";

export async function findAllBackgrounds(): Promise<Background[]> {
    const response = await api.get<Background[]>("/backgrounds");

    return response.data;
}
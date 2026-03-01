import api from "./api.ts";
import type {Species} from "../model/species.ts";

export async function findAllSpecies(): Promise<Species[]> {
    const response = await api.get<Species[]>("/species");

    return response.data;
}
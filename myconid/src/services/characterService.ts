import type {CreateCharacterForm} from "../pages/create-character.tsx";
import api from "./api.ts";

export function createCharacter(character: CreateCharacterForm) {
    api.post("/characters", character)
        .catch(error => console.log(error));
}
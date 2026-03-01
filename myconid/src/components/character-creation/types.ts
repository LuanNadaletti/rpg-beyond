import { z } from "zod";

export const CreateCharacterSchema = z.object({
    name: z.string().trim().min(1, "Character name is required"),
    classId: z.int("Invalid value").positive("Select a class"),
    backgroundId: z.int("Invalid value").positive("Select a background"),
    speciesId: z.int("Invalid number").positive("Select a species"),
    strength: z.int("Invalid value").positive("Strength is required"),
    dexterity: z.int("Invalid value").positive("Dexterity is required"),
    constitution: z.int("Invalid value").positive("Constitution is required"),
    intelligence: z.int("Invalid value").positive("Intelligence is required"),
    wisdom: z.int("Invalid value").positive("Wisdom is required"),
    charisma: z.int("Invalid value").positive("Charisma is required"),
});

export type CreateCharacterForm = z.infer<typeof CreateCharacterSchema>;

export type Stats = "strength" | "dexterity" | "constitution" | "intelligence" | "wisdom" | "charisma";
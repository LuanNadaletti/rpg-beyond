import {z} from "zod";
import {type ReactNode, useEffect, useState} from "react";
import type {Class} from "../model/class.ts";
import type {Background} from "../model/background.ts";
import {type SubmitHandler, useForm} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";
import type {Species} from "../model/species.ts";
import {findAllSpecies} from "../services/speciesService.ts";
import {findAllBackgrounds} from "../services/backgroundService.ts";
import {findAllClasses} from "../services/classService.ts";
import {createCharacter} from "../services/characterService.ts";

const CreateCharacterSchema = z.object({
    name: z.string().trim().min(1, "Character name is required"),
    classId: z.number().int().positive("Select a class"),
    backgroundId: z.number().int().positive("Select a background"),
    speciesId: z.number().int().positive("Select a species"),
});

export type CreateCharacterForm = z.infer<typeof CreateCharacterSchema>;

export default function CreateCharacter(): ReactNode {
    const [classes, setClasses] = useState<Class[]>();
    const [backgrounds, setBackgrounds] = useState<Background[]>();
    const [species, setSpecies] = useState<Species[]>();
    const [loadError, setLoadError] = useState<string>();

    const {
        register,
        handleSubmit,
        formState: {errors, isSubmitting},
    } = useForm<CreateCharacterForm>({
        resolver: zodResolver(CreateCharacterSchema),
        mode: "onBlur"
    });

    useEffect(() => {
        findAllClasses().then(setClasses).catch((e) => setLoadError(e?.message ?? String(e)));
        findAllBackgrounds().then(setBackgrounds).catch((e) => setLoadError(e?.message ?? String(e)));
        findAllSpecies().then(setSpecies).catch((e) => setLoadError(e?.message ?? String(e)));
    }, []);

    const onSubmit: SubmitHandler<CreateCharacterForm> = async (data) => {
        console.log("CreateCharacter DTO: ", data);

        createCharacter(data);
    };

    return (
        <form onSubmit={handleSubmit(onSubmit)} noValidate>
            <div className="flex flex-col gap-2">
                {loadError && (
                    <div className="p-2 border border-red-600 text-red-700">
                        {loadError}
                    </div>
                )}

                <div>
                    <label htmlFor="name" className="font-bold">
                        Character name
                    </label>
                    <input
                        id="name"
                        type="text"
                        className="p-1 border border-zinc-950 w-full"
                        aria-invalid={!!errors.name}
                        {...register("name")}
                    />
                    {errors.name?.message && (
                        <p className="mt-1 text-sm text-red-700">{errors.name.message}</p>
                    )}
                </div>

                <div>
                    <label htmlFor="classId" className="font-bold">
                        Classes
                    </label>
                    <select
                        id="classId"
                        defaultValue=""
                        disabled={!classes}
                        className="p-1 border border-zinc-950 w-full disabled:opacity-60"
                        aria-invalid={!!errors.classId}
                        {...register("classId", {
                            setValueAs: (v) => (v === "" ? undefined : Number(v)),
                        })}
                    >
                        <option value="" disabled>
                            {classes ? "Select a class..." : "Loading classes..."}
                        </option>

                        {classes?.map((clazz) => (
                            <option key={clazz.id} value={String(clazz.id)}>
                                {clazz.name}
                            </option>
                        ))}
                    </select>
                    {errors.classId?.message && (
                        <p className="mt-1 text-sm text-red-700">{errors.classId.message}</p>
                    )}
                </div>

                <div>
                    <label htmlFor="backgroundId" className="font-bold">
                        Backgrounds
                    </label>
                    <select
                        id="backgroundId"
                        defaultValue=""
                        disabled={!backgrounds}
                        className="p-1 border border-zinc-950 w-full disabled:opacity-60"
                        aria-invalid={!!errors.backgroundId}
                        {...register("backgroundId", {
                            setValueAs: (v) => (v === "" ? undefined : Number(v)),
                        })}
                    >
                        <option value="" disabled>
                            {backgrounds ? "Select a background..." : "Loading backgrounds..."}
                        </option>

                        {backgrounds?.map((bg) => (
                            <option key={bg.id} value={String(bg.id)}>
                                {bg.name}
                            </option>
                        ))}
                    </select>
                    {errors.backgroundId?.message && (
                        <p className="mt-1 text-sm text-red-700">{errors.backgroundId.message}</p>
                    )}
                </div>

                <div>
                    <label htmlFor="speciesId" className="font-bold">
                        Species
                    </label>
                    <select
                        id="speciesId"
                        defaultValue=""
                        disabled={!species}
                        className="p-1 border border-zinc-950 w-full disabled:opacity-60"
                        aria-invalid={!!errors.speciesId}
                        {...register("speciesId", {
                            setValueAs: (v) => (v === "" ? undefined : Number(v)),
                        })}
                    >
                        <option value="" disabled>
                            {species ? "Select a species..." : "Loading species..."}
                        </option>

                        {species?.map((sp) => (
                            <option key={sp.id} value={String(sp.id)}>
                                {sp.name}
                            </option>
                        ))}
                    </select>
                    {errors.speciesId?.message && (
                        <p className="mt-1 text-sm text-red-700">{errors.speciesId.message}</p>
                    )}
                </div>

                <button
                    type="submit"
                    disabled={isSubmitting}
                    className="mt-2 p-2 border border-zinc-950 disabled:opacity-60"
                >
                    {isSubmitting ? "Creating..." : "Create"}
                </button>
            </div>
        </form>
    );
}
import type { ReactNode } from "react";
import { useFormContext } from "react-hook-form";
import type { CreateCharacterForm, Stats } from "./types";

export default function StatsEdit(): ReactNode {
    return (
        <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-6 gap-2">
            <StatEdit name="strength" />
            <StatEdit name="dexterity" />
            <StatEdit name="constitution" />
            <StatEdit name="intelligence" />
            <StatEdit name="wisdom" />
            <StatEdit name="charisma" />
        </div>
    );
}

function StatEdit({ name }: { name: Stats }): ReactNode {
    const {
        register,
        formState: { errors },
    } = useFormContext<CreateCharacterForm>();

    return (
        <div>
            <label htmlFor={name} className="font-bold">
                {name.toLocaleUpperCase()}
            </label>
            <input
                id={name}
                aria-invalid={!!errors.name}
                type="number"
                {...register(name, {
                    setValueAs: (v) => (v === "" ? undefined : Number(v)),
                })}
                className="border w-full"
            />
            {errors[name]?.message && (
                <p className="mt-1 text-sm text-red-700">{errors[name].message}</p>
            )}
        </div>
    )
}
import type { ReactNode } from "react";
import type { CreateCharacterForm, Stats } from "./types";
import { useFormContext } from "react-hook-form";

export default function ScoreCalculations(): ReactNode {
    return (
        <div className="max-w-2xl m-auto p-2">
            <div>Score calculations</div>

            <div className="flex flex-wrap">
                <ScoreCalculation name="strength" />
                <ScoreCalculation name="dexterity" />
                <ScoreCalculation name="constitution" />
                <ScoreCalculation name="intelligence" />
                <ScoreCalculation name="wisdom" />
                <ScoreCalculation name="charisma" />
            </div>
        </div>
    )
}

function ScoreCalculation({ name }: { name: Stats }): ReactNode {
    const { watch } = useFormContext<CreateCharacterForm>();

    let [score] = watch([name]);

    if (isNaN(score)) {
        score = 10
    }

    const modifier = getScoreModifier(score)

    return (
        <div className="flex-1/3 p-2">
            <div className="p-2 bg-black text-white font-bold">{name.toLocaleUpperCase()}</div>
            <table className="w-full">
                <tbody>
                    <tr>
                        <td className="p-2 bg-blue-300">Total Score</td>
                        <td className="p-2 bg-blue-200 text-center w-12">{score}</td>
                    </tr>
                    <tr>
                        <td className="p-2 bg-blue-300">Modifier</td>
                        <td className="p-2 bg-blue-200 text-center w-12">{modifier >= 0 ? `+${modifier}` : modifier}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}

function getScoreModifier(score: number): number {
    const modifier = (score - 10) / 2
    return modifier < 0 ? Math.ceil(modifier) : Math.floor(modifier);
}
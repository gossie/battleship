import { useEffect, useState } from "react";
import { useParams } from "react-router-dom"
import BoardComponent from "../components/BoardComponent";
import { getGame } from "../service/api";
import { Game } from "../service/model";

export default function GamePage() {

    const [game, setGame] = useState<Game>()

    const {id} = useParams();

    useEffect(() => {
        getGame(id!)
            .then(setGame)
    }, [id])

    return (
        <div>
            {game && <BoardComponent board={game.board} />}
        </div>
    )
}
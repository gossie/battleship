import { useEffect, useState } from "react";
import { useParams } from "react-router-dom"
import BoardComponent from "../components/BoardComponent";
import Players from "../components/Players";
import ShipComponent from "../components/ShipComponent";
import { getGame } from "../service/api";
import { Game } from "../service/model";

import './GamePage.css'

export default function GamePage() {

    const [game, setGame] = useState<Game>()
    const [selectedShipLength, setSelectedShipLength] = useState<number>()

    const {id} = useParams();

    useEffect(() => {
        getGame(id!)
            .then(setGame)
    }, [id])

    return (
        <div className="game">
            <div>
                {selectedShipLength && <div>{selectedShipLength} adjacent cells need to be selected</div>}
                {game && <BoardComponent onBoardChange={setGame} board={game.board} />}
                <ShipComponent length={4} onSelect={setSelectedShipLength} />
                <ShipComponent length={3} onSelect={setSelectedShipLength} />
                <ShipComponent length={2} onSelect={setSelectedShipLength} />
                <ShipComponent length={1} onSelect={setSelectedShipLength} />
            </div>
            <div>
                {game && <Players players={game.players} />}
            </div>
        </div>
    )
}
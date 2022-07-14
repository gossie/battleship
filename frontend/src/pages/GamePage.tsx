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
    const [selectedShipLength, setSelectedShipLength] = useState(4)

    const {id} = useParams();

    useEffect(() => {
        getGame(id!)
            .then(setGame)
    }, [id])

    const isSelectable = (length: number) => {
        return selectedShipLength !== length
                && game!.board.ships.every(ship => ship.length !== length)
    }

    return (
        <div className="game">
            <div>
                {selectedShipLength && <div>{selectedShipLength} adjacent cells need to be selected</div>}
                {game &&
                    <div>
                        <BoardComponent onBoardChange={setGame} shipLength={selectedShipLength} board={game.board} />
                        <ShipComponent length={4} selectable={isSelectable(4)} onSelect={setSelectedShipLength} />
                        <ShipComponent length={3} selectable={isSelectable(3)} onSelect={setSelectedShipLength} />
                        <ShipComponent length={2} selectable={isSelectable(2)} onSelect={setSelectedShipLength} />
                        <ShipComponent length={1} selectable={isSelectable(1)} onSelect={setSelectedShipLength} />
                    </div>
                }
            </div>
            <div>
                {game && <Players players={game.players} />}
            </div>
        </div>
    )
}
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { startNewGame } from "../service/api";

export default function LandingPage() {

    const [gameId, setGameId] = useState('')

    const nav = useNavigate()

    const startGame = () => {
        startNewGame()
            .then(game => nav(`/game/${game.id}`))
    }
    
    const joinGame = () => nav(`/game/${gameId}`)

    return (
        <div>
            <div>
                <button onClick={startGame}>Start game</button>
            </div>
            <div>
                <input type="text" value={gameId} onChange={ev => setGameId(ev.target.value)} /> <button onClick={joinGame}>Join game</button>
            </div>
        </div>
    )
}
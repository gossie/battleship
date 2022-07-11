import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { startNewGame } from "../service/api";

import './LandingPage.css';

export default function LandingPage() {

    const [playerName, setPlayerName] = useState('')
    const [gameId, setGameId] = useState('')
    const [errorMessage, setErrorMessage] = useState('')

    const nav = useNavigate()

    useEffect(() => {
        const timeoutId = setTimeout(() => setErrorMessage(''), 5000)
        return () => clearTimeout(timeoutId)
    }, [errorMessage])

    const startGame = () => {
        if (playerName) {
            startNewGame(playerName)
                .then(game => nav(`/game/${game.id}`))
        } else {
            setErrorMessage('You need to tell us who you are.')
        }
    }
    
    const joinGame = () => {
        if (playerName && gameId) {
            nav(`/game/${gameId}`)
        } else {
            setErrorMessage(`${playerName ? '' : 'You need to tell us who you are.'} ${gameId ? '' : 'You need to specify the game you want to join.'}`)
       }
    }

    return (
        <div>
            <div className="landing-page">
                <div>
                    <input type="text" 
                        placeholder="Your name"
                        value={playerName}
                        onChange={ev => setPlayerName(ev.target.value)}
                    />
                </div>
                <div>
                    <div>
                        <button onClick={startGame}>Start game</button>
                    </div>
                    <div>
                        <input type="text"
                            placeholder="Game id"
                            value={gameId}
                            onChange={ev => setGameId(ev.target.value)}
                        />
                        <button onClick={joinGame}>Join game</button>
                    </div>
                </div>
            </div>
            { errorMessage && <div className="error">{errorMessage}</div> }
        </div>
    )
}
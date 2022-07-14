import { Board, Game } from "../service/model";
import FieldComponent from "./FieldComponent";

import './BoardComponent.css';
import { useEffect, useState } from "react";

interface BoardComponentProps {
    board: Board
    shipLength: number
    onBoardChange: (g: Game) => void
}

export default function BoardComponent(props: BoardComponentProps) {

    const [errorMessage, setErrorMessage] = useState('')

    useEffect(() => {
        const timeoutId = setTimeout(() => setErrorMessage(''))
        return () => clearTimeout(timeoutId)
    }, [errorMessage])

    const battlefield = props.board.fields
        .map(row => <div className="row">{row.map(field => <FieldComponent board={props.board} field={field} shipLength={props.shipLength} onShipAdd={props.onBoardChange} onError={setErrorMessage} />)}</div>)

    return (
        <div>
            <div>{battlefield}</div>
            { errorMessage && <div className="error">{errorMessage}</div> }
        </div>
    )
}

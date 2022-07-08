import { Board, Game } from "../service/model";
import FieldComponent from "./FieldComponent";

import './BoardComponent.css';
import { useState } from "react";

interface BoardComponentProps {
    board: Board
    onBoardChange: (g: Game) => void
}

export default function BoardComponent(props: BoardComponentProps) {

    const [errorMessage, setErrorMessage] = useState('')

    const battlefield = props.board.fields
        .map(row => <div className="row">{row.map(field => <FieldComponent board={props.board} field={field} onShipAdd={props.onBoardChange} onError={setErrorMessage} />)}</div>)

    return (
        <div>
            <div>{battlefield}</div>
            { errorMessage && <div className="error">{errorMessage}</div> }
        </div>
    )
}

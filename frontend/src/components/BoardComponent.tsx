import { Board, Game } from "../service/model";
import FieldComponent from "./FieldComponent";

import './BoardComponent.css';

interface BoardComponentProps {
    board: Board
    onBoardChange: (g: Game) => void
}

export default function BoardComponent(props: BoardComponentProps) {

    const battlefield = props.board.fields.map(row => <div className="row">{row.map(field => <FieldComponent board={props.board} field={field} onShipAdd={props.onBoardChange} />)}</div>)

    return (
        <div>{battlefield}</div>
    )
}

import { addShip } from "../service/api";
import { Field, Board, Direction, Game } from "../service/model";

import './FieldComponent.css';

interface FieldComponentProps {
    board: Board
    field: Field
    onShipAdd: (g: Game) => void
}

export default function FieldComponent(props: FieldComponentProps) {

    const select = (direction: Direction) => {
        addShip(props.board, {
            start: props.field.position,
            length: 4,
            direction: direction
        })
        .then(game => props.onShipAdd(game))
    }

    return (
        <span className={`field ${props.field.occupied ? 'ship' : ''}`}>
            { !props.field.occupied &&
            <div>
                <button onClick={() => select(Direction.UP)}>Up</button>
                <button onClick={() => select(Direction.LEFT)}>Left</button>
                <button onClick={() => select(Direction.RIGTH)}>Right</button>
                <button onClick={() => select(Direction.DOWN)}>Down</button>
            </div>
            }
        </span>
    )
}
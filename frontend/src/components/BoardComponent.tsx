import { Board } from "../service/model";
import FieldComponent from "./FieldComponent";

interface BoardComponentProps {
    board: Board
}

export default function BoardComponent(props: BoardComponentProps) {

    const battlefield = props.board.fields.map(row => <div>{row.map(field => <FieldComponent field={field} />)}</div>)

    return (
        <div>{battlefield}</div>
    )
}

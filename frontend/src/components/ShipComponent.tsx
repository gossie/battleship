interface ShipComponentProps {
    length: number
    selectable: boolean
    onSelect: (length: number) => void
}

export default function ShipComponent(props: ShipComponentProps) {
    return (
        <div>
            <div>{props.length} {props.selectable && <button onClick={() => props.onSelect(props.length)}>Setzen</button>}</div>
        </div>
    )
}

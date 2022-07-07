interface ShipComponentProps {
    length: number
    onSelect: (length: number) => void
}

export default function ShipComponent(props: ShipComponentProps) {
    return (
        <div>
            <div>{props.length} <button onClick={() => props.onSelect(props.length)}>Setzen</button></div>
        </div>
    )
}

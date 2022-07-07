import { useState } from "react"
import { Field } from "../service/model"

interface FieldComponentProps {
    field: Field
}

export default function FieldComponent(props: FieldComponentProps) {

    const [full, setFull] = useState(false)

    const select = () => {
        setFull(old => !old)
    }

    return (
        <button onClick={select}>{full ? 1 : 0}</button>
    )
}
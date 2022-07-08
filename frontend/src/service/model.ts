export interface Game {
    id: string
    board: Board
    links: Array<Link>
}

export interface Board {
    fields: Array<Array<Field>>
    links: Array<Link>
}

export interface Ship {
    start: Position
    length: number
    direction: Direction
}

export enum Direction {
    UP="UP",
    DOWN="DOWN",
    LEFT="LEFT",
    RIGTH="RIGHT"
}

export interface Field {
    position: Position
    occupied: boolean
}

export interface Position {
    x: number
    y: number
}

interface Link {
    href: string
    rel: string
}